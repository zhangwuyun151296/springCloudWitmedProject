package com.whackon.witmed.service.impl;

import com.whackon.witmed.dao.GeneratorDao;
import com.whackon.witmed.pojo.Entity;
import com.whackon.witmed.pojo.Property;
import com.whackon.witmed.pojo.entity.Column;
import com.whackon.witmed.pojo.entity.Table;
import com.whackon.witmed.pojo.vo.GeneratorVO;
import com.whackon.witmed.service.GeneratorService;
import com.whackon.witmed.util.FreemarkerUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 * <b></b>
 *
 * @author 张武超
 * @date 2022/1/12
 * @since
 */
@Service("generatorService")
public class GeneratorServiceImpl implements GeneratorService {
	@Resource(name = "generatorDao")
	private GeneratorDao generatorDao;

	/**
	 * <b>根据连接对象生成代码</b>
	 * @param generatorVO
	 * @param connection
	 * @return
	 * @throws Exception
	 */
	@Override
	public boolean generateCode(GeneratorVO generatorVO, Connection connection) throws Exception {
		// 根据数据库连接对象和数据库名查询所有数据库表集合
		List<Table> tableList = generatorDao.findTableList(connection, generatorVO.getDbSchema());
		// 循环所有的数据表，获取每个表信息，获得这个表对应的字段集合，生成对应的代码
		// 一个 Table 会对应一个 Entity，需要将 Table转换为 Entity
		List<Entity> entityList = new ArrayList<Entity>();
		for (Table table : tableList) {
			// 根据表获得对应的字段集合
			List<Column> columnList = generatorDao.findColumnListByTable(generatorVO.getDbSchema(), table.getTableName(), connection);
			// 循环字段集合获得 Property 集合
			List<Property> propertyList = new ArrayList<Property>();
			for (Column column : columnList) {
				Property property = new Property();
				property.setName(column.getColumnName());
				property.setComment(column.getColumnComment());
				if (column.getDataType().equalsIgnoreCase("varchar")) {
					property.setType("String");
				} else if (column.getDataType().equalsIgnoreCase("int")) {
					property.setType("Integer");
				} else if (column.getDataType().equalsIgnoreCase("decimal")) {
					property.setType("Double");
				} else if (column.getDataType().equalsIgnoreCase("date") || column.getDataType().equalsIgnoreCase("datetime") || column.getDataType().equalsIgnoreCase("timestamp")) {
					property.setType("Date");
				}
				propertyList.add(property);
			}
			// 将 Table 变为 Entity
			// 根据表名获得实体类名
			String tableName = table.getTableName();
			// 根据下划线将数据变为数组
			String[] names = tableName.split("_");
			String entityName = "";
			for (int i = 1; i < names.length; i++) {
				// 获取当前部分内容
				String str = names[i];
				// 将首字母大写进行拼接
				str = str.substring(0, 1).toUpperCase() + str.substring(1, str.length());
				entityName = entityName + str;
			}

			Entity entity = new Entity();
			entity.setEntityName(entityName);
			entity.setComment(table.getTableComment());
			entity.setTableName(table.getTableName());
			entity.setPropertyList(propertyList);
			// 使用 Freemarker 生成结果
			FreemarkerUtil.create(entity, entity.getEntityName(), "entity");
		}
		return true;
	}
}

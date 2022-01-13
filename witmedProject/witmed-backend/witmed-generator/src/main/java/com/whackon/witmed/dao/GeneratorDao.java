package com.whackon.witmed.dao;

import com.whackon.witmed.pojo.entity.Column;
import com.whackon.witmed.pojo.entity.Table;

import java.sql.Connection;
import java.util.List;

/**
 * <b></b>
 *
 * @author 张武超
 * @date 2022/1/12
 * @since
 */
public interface GeneratorDao {
	/**
	 * <b>根据数据库名获得所有的数据表信息</b>
	 * @param connection
	 * @param dbSchema
	 * @return
	 * @throws Exception
	 */
	List<Table> findTableList(Connection connection, String dbSchema) throws Exception;

	/**
	 * <b>根据数据库和表获得该表的所有字段信息</b>
	 * @param dbSchema
	 * @param tableName
	 * @param connection
	 * @return
	 */
	List<Column> findColumnListByTable(String dbSchema, String tableName, Connection connection) throws Exception;
}

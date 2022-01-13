package com.whackon.witmed.base.freemarker;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * <b>智慧医疗信息平台-</b>
 *
 * @version 1.0.0
 * @Author 张武超
 * @Date 2022/1/6
 * @serial 1.0.0
 */
public class FreemarkerEntity {

	public static void main(String[] args) {
		//获得数据连接对象
		Connection connection=ConnectionUtil.getConnection();
		//设定所需要执行的sql
		String sql="SELECT COLUMN_NAME,DATA_TYPE,COLUMN_COMMENT " +
					"FROM information_schema.columns " +
					"WHERE TABLE_SCHEMA='witmed_db' and TABLE_NAME='sys_admin' " +
					"ORDER BY ORDINAL_POSITION ";
		try {
			//创建PreparedStatement
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			//进行执行
			ResultSet resultSet = preparedStatement.executeQuery();
			//循环结果集，创建property类型的集合
			List<Property> propertyList=new ArrayList<Property>();
			while (resultSet.next()){
				//提取数据
				String type =resultSet.getString("DATA_TYPE");
				String name=resultSet.getString("COLUMN_NAME");
				String comment=resultSet.getString("COLUMN_COMMENT");
				//将数据库的数据类型变为java的数据类型
				if ("int".equals(type)){
					type="Long";
				}else if("varchar".equals(type)){
					type="String";
				}else if ("timestamp".equals(type)){
					type="Date";
				}
				//创建Property对象
				Property property=new Property();
				property.setType(type);
				property.setName(name);
				property.setComment(comment);
				propertyList.add(property);
			}
			Entity entity=new Entity("com.whackon.witmed.test","Admin",propertyList);
			//调用Freemarker工具类生成实体类
			if (FreemarterUtil.createFile("entity",entity)){
				System.out.println("目标文件生成成功");
			}else{
				System.out.println("目标文件生成失败");
			}
		}catch (Exception e){
			e.printStackTrace();
		}
	}
}

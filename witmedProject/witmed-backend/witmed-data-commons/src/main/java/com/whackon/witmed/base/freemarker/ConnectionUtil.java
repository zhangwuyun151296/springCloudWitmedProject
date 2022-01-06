package com.whackon.witmed.base.freemarker;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * <b>智慧医疗信息平台-</b>
 *
 * @version 1.0.0
 * @Author 张武超
 * @Date 2022/1/6
 * @serial 1.0.0
 */
public class ConnectionUtil {
	private static String driverName="com.mysql.cj.jdbc.Driver";
	private static String url="jdbc:mysql://localhost:3306/witmed_db? useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai&useSSL=false&allowPublicKeyRetrieval=true";
	private static String username="root";
	private static String password="root";
	private static ThreadLocal<Connection> threadLocal=new ThreadLocal<Connection>();

	static{
		try {
			Class.forName(driverName);
		}catch (Exception e){
			e.printStackTrace();
		}
	}

	public static Connection getConnection(){
		Connection connection=threadLocal.get();
		if (connection==null){
			try {
				connection= DriverManager.getConnection(url,username,password);
				threadLocal.set(connection);
			}catch (Exception e){
				e.printStackTrace();
			}
		}
		return connection;
	}
}

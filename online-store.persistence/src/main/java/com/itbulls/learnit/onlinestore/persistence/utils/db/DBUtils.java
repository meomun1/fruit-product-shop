package com.itbulls.learnit.onlinestore.persistence.utils.db;

import java.sql.Connection;

import java.sql.SQLException;

import com.itbulls.learnit.onlinestore.persistence.utils.connectionpools.DbcpDemo;

public class DBUtils {
	
	@SuppressWarnings("unused")
	private static final String JDBC_MYSQL_HOST = "jdbc:mysql://localhost:3306/";
	@SuppressWarnings("unused")
	private static final String DB_NAME = "final_task";
	@SuppressWarnings("unused")
	private static final String USERNAME = "root";
	@SuppressWarnings("unused")
	private static final String PASSWORD = "MaL1504@";
	
	private DBUtils() {
	}
	
	public static Connection getConnection() {
		// try {
		// 	Class.forName("com.mysql.cj.jdbc.Driver");
		// 	return DriverManager.getConnection(JDBC_MYSQL_HOST + DB_NAME, USERNAME, PASSWORD);
		// } catch (SQLException | ClassNotFoundException e) {
		// 	throw new RuntimeException(e);
		// }

		try{
			return DbcpDemo.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}

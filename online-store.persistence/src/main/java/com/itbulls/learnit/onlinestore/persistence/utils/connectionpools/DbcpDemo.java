package com.itbulls.learnit.onlinestore.persistence.utils.connectionpools;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;

public class DbcpDemo {

	private static BasicDataSource ds;
	
	static {
		try {
			ds = new BasicDataSource();
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		ds.setUrl("jdbc:mysql://localhost:3306/final_task");
		ds.setUsername("root");
		ds.setPassword("MaL1504@");
		ds.setMinIdle(3);
		ds.setTimeBetweenEvictionRunsMillis(1000);
		ds.setMaxIdle(20);
		ds.setMaxOpenPreparedStatements(200);
	}
	public static Connection getConnection() throws SQLException {
		return ds.getConnection();
	}
	
	public static void main(String[] args) throws SQLException {
		Connection conn = getConnection();
		try (conn) {
			System.out.println(conn);
		}
		System.out.println(conn);
	}


}
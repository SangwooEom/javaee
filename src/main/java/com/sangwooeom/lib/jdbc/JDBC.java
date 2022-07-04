package com.sangwooeom.lib.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// JAVA에서 기본적으로 제공한 JDBC API를 통해서 구현한 DB 연동
public class JDBC {
	private static final String URL = "jdbc:mysql://localhost:3306/test_db";
	private static final String USER_NAME = "sangwoo.eom";
	private static final String PASSWORD = "1234";
	
	public static void main(String[] args) {
		try {
			Connection conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from member");
			
			while(rs.next()) {
				int seq = rs.getInt("seq");
				String id = rs.getString("id");
				String password = rs.getString("password");
				String name = rs.getString("name");
				String email = rs.getString("email");
				
				System.out.println("seq: " + seq);
				System.out.println("id: " + id);
				System.out.println("password: " + password);
				System.out.println("name: " + name);
				System.out.println("email: " + email);
				System.out.println();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

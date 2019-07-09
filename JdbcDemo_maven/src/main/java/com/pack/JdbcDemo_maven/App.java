package com.pack.JdbcDemo_maven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class App {
	public static void main(String args[]) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "Sapient123");
			Statement stmnt = conn.createStatement();
			
			//stmnt.executeUpdate("insert into EMP values('xyz',23)");
			//stmnt.executeUpdate("delete from EMP where age>25");
			stmnt.executeUpdate("update EMP set AGE=AGE+1");
			ResultSet rs = stmnt.executeQuery("select * from emp");
			while (rs.next()) {
				System.out.println("Name: " + rs.getString(1));
				System.out.println("Age: " + rs.getInt(2));
				System.out.println("-------------------");
			}
			rs.close();
			stmnt.close();
			conn.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}

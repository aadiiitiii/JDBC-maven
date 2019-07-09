package com.pack.JdbcDemo_maven;

import java.sql.*;
import java.util.Scanner;

public class JdbcDynamic {
	public static void main(String args[]) {
		try {
			Scanner sc= new Scanner(System.in);
			
			int age;
			String name;
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "Sapient123");
			
			java.sql.PreparedStatement pstmnt= conn.prepareStatement("insert into EMP values(?,?)");
			System.out.println("Enter name: ");
			name=sc.next();
			System.out.println("Enter age");
			age= sc.nextInt();
			
			pstmnt.setString(1, name);
			pstmnt.setInt(2, age);
			pstmnt.execute();
			
			ResultSet rs = pstmnt.executeQuery("select * from emp");
			while (rs.next()) {
				System.out.println("Name: "+rs.getString(1));
				System.out.println("Age: "+rs.getInt(2));
				System.out.println("-------------------");
			}
			rs.close();
			pstmnt.close();
			conn.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}

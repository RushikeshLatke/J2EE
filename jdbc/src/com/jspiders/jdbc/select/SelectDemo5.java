package com.jspiders.jdbc.select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.jspiders.jdbc.object.Student;

public class SelectDemo5 {
	
	public static Connection connection;
	public static Statement statement;
	public static String query;
	public static ResultSet resultSet;
	private static String dburl="jdbc:mysql://localhost:3306/weja2?";
	private static String user="root";
	private static String password="root";
	
	public static void main(String[] args) {
		
	
	
	try {
		

		
		
		connection=DriverManager.getConnection(dburl, user, password);
		
		query="select * from student";
		statement= connection.createStatement();
		
		resultSet=statement.executeQuery(query);
		
		while (resultSet.next()) {
			
			Student student=new Student();
		  
			                  student.setId(resultSet.getInt(1));
					           student.setName(resultSet.getString(2));
					           student.setEmail(resultSet.getString(3));
					           
					           System.out.println(student);
			
		}
		
	} catch (Exception e) {
		
		e.printStackTrace();
	}finally {
		try {
			if (connection!=null) {
				connection.close();
				
			}
			if (statement!=null) {
				
				statement.close();
			}
			if (resultSet!=null) {
				resultSet.close();
			}
		} catch (Exception e2) {
		e2.printStackTrace();
		}
	 }

  }
}

package com.jspiders.jdbc.select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class SelectDemo1 {
	
	public static void main(String[] args) {
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection connection=DriverManager.getConnection("Jdbc:mysql://localhost:3306/weja2?user=root&password=root");
			
			Statement statement= connection.createStatement();
			
			ResultSet resultSet=statement.executeQuery("select * from student");
			
			while (resultSet.next()) {
				
				System.out.println(resultSet.getString(1)+" | "+
				                    resultSet.getString(2)+" | "+
						              resultSet.getString(3));
				
				
			}
			
			connection.close();
			statement.cancel();
			resultSet.close();
			
				
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
			
		}catch (SQLException e) {
		   e.printStackTrace();
		}
	}
}

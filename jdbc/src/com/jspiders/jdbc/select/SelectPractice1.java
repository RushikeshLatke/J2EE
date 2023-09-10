package com.jspiders.jdbc.select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectPractice1 {
	
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/scott? user = root & password =root");
			
			Statement statement = connection.createStatement();
			
			ResultSet resultSet = statement.executeQuery("select * from emp");
			
			while (resultSet.next()) {
				
				System.out.println(resultSet.getString(1)+"||"+
						            resultSet.getString(2)); 
				
			}
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}

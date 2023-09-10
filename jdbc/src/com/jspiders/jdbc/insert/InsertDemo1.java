package com.jspiders.jdbc.insert;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class InsertDemo1 {
	
	private static Connection connection;
	private static Statement statement;
	private static Properties properties=new Properties();
	private static ResultSet resultSet;
	private static FileInputStream file;
	private static String filePath="D:\\WEJA2\\jdbc\\src\\resources\\db_info.properties";
	private static String query;
	private static int result;
	
	public static void main(String[] args) {
		
		try {
			file= new FileInputStream(filePath);
			properties.load(file);
			
			Class.forName(properties.getProperty("driverPath"));
			
			connection=DriverManager.getConnection(properties.getProperty("dburl"), properties);
			
			statement= connection.createStatement();
			
			query="insert into student values(2,'Rushi','rushi@gmail.com')";
			
			result=statement.executeUpdate(query);
			
	          if (result!=0) {
				
				System.out.println(result+" record added.");
				
			    }
			
			query="select * from student";
			
			resultSet=statement.executeQuery(query);
			
			while (resultSet.next()) {
				

				System.out.println(resultSet.getString(1)+" | "+
						           resultSet.getString(2)+" | "+
						           resultSet.getString(3));
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
				if (file!=null) {
					file.close();
				}
			} catch ( Exception e) {
			
			}
		}
		
	}

}

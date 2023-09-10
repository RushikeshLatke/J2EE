package com.jspiders.jdbc.delete;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

public class DeleteDemo1 {
	
	public static Connection connection;
	public static Statement statement;
	public static Properties properties=new Properties();
	public static FileInputStream file;
    public static int result;
    public static String query;
    public static String filePath="D:\\WEJA2\\jdbc\\src\\resources\\db_info.properties";
    
    public static void main(String[] args) {
		try {
			file= new FileInputStream(filePath);
			properties.load(file);
			
			Class.forName(properties.getProperty("driverPath"));
			
			connection=DriverManager.getConnection(properties.getProperty("dburl"), properties);
			
			statement= connection.createStatement();
			
			query="delete from student where Id=2";
			
			result=statement.executeUpdate(query);
			
			if (result!=0) {
				
				System.out.println(result+" Rows affected");
			}
			
			
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}finally {
			try {
				
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
					
				}
				if (file!=null) {
					file.close();
				}
				
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	

}

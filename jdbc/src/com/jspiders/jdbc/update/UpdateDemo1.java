package com.jspiders.jdbc.update;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class UpdateDemo1 {
	
	private static Connection connection;
	private static Statement statement;
	private static FileInputStream file;
	private static Properties properties =new Properties();
	private static String filePath="D:\\WEJA2\\jdbc\\src\\resources\\db_info.properties";
	private static int result;
	private static String query;
	
	public static void main(String[] args) {
		
		    try {
				file=new FileInputStream(filePath);
				properties.load(file);
				Class.forName(properties.getProperty("driverPath"));
				
				connection=DriverManager.getConnection(properties.getProperty("dburl"),properties);
				
				statement= connection.createStatement();
				
				query="update student set Email='amar123@gmail.com'"+" where Id=1";
				result=statement.executeUpdate(query);
				
				if (result!=0) {
					
					System.out.println(result+" rows affected");
				}
				
				
			
			} catch (IOException | ClassNotFoundException | SQLException e) {
				
				e.printStackTrace();
			}finally {
				
				try {
					if (connection!=null) {
						connection.close();
					}
					if (statement!=null) {
						
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

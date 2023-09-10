package com.jspiders.jdbc.dynamic;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class DynamicSelect {
	
	public static Connection connection;
	public static PreparedStatement preparedStatement;
	public static Properties properties=new Properties();
	public static FileInputStream file;
	public static ResultSet resultSet;
	public static String query;
	public static String filePath="D:\\WEJA2\\jdbc\\src\\resources\\db_info.properties";
	
	public static void main(String[] args) {
		
		try {
			file=new FileInputStream(filePath);
			properties.load(file);
			
			Class.forName(properties.getProperty("driverPath"));
			
       connection=DriverManager.getConnection(properties.getProperty("dburl"), properties);
                  query="select * from student where Id=?";
                  preparedStatement=connection.prepareStatement(query);
                  
                  preparedStatement.setInt(1, 1);
                  
                  resultSet=preparedStatement.executeQuery();
                  
                  while (resultSet.next()) {
					
                	  System.out.println(resultSet.getInt(1)+" | "+
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
				if (preparedStatement!=null) {
					preparedStatement.close();
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

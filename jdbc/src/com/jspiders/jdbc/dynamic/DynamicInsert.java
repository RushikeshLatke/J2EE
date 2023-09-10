package com.jspiders.jdbc.dynamic;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

public class DynamicInsert {
	public static Connection connection;
	public static PreparedStatement preparedStatement;
	public static Properties properties=new Properties();
	public static FileInputStream file;
	public static int result;
	public static String query;
	public static String filePath="D:\\WEJA2\\jdbc\\src\\resources\\db_info.properties";
	
	public static void main(String[] args) {
		
		try {
			file=new FileInputStream(filePath);
			properties.load(file);
			
			Class.forName(properties.getProperty("driverPath"));
			
       connection=DriverManager.getConnection(properties.getProperty("dburl"), properties);
                  query="insert into student values(?,?,?)";
                  preparedStatement=connection.prepareStatement(query);
                  
                  preparedStatement.setInt(1,2);
                  preparedStatement.setString(2,"rushi");
                  preparedStatement.setString(3,"rushi@gmail.com");
                  
                  result=preparedStatement.executeUpdate();
                  
             if (result!=0) {
				System.out.println(result+" Rows affected.");
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

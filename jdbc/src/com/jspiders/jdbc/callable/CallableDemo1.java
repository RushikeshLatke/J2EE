package com.jspiders.jdbc.callable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.CallableStatement;

public class CallableDemo1 {
	
	public static Connection connection;
	public static CallableStatement callableStatement;
	public static String query="call proc1()";
	public static ResultSet resultSet;
	private static String driverPath="com.mysql.cj.jdbc.Driver";
	private static String dburl="jdbc:mysql://localhost:3306/weja2?";
	private static String user="root";
	private static String password="root";
	
	public static void main(String[] args) {
		try {
			
			Class.forName(driverPath);
			
			
			connection=DriverManager.getConnection(dburl, user, password);
			
			
			callableStatement= connection.prepareCall(query);
			
			resultSet=callableStatement.executeQuery();
			
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
				if (callableStatement!=null) {
					
					callableStatement.close();
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

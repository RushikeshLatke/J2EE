package operations;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcOperator2 {
	
	public static Connection connection;
	public static Statement statement;
	public static FileInputStream file;
	public static Properties properties=new Properties();
	public static String filePat ="D:\\WEJA2\\jdbc\\src\\resources\\db_info.properties";
	public static String query;
	public static ResultSet resultSet;
	public static int result;
	
	public static void main(String[] args) {
		//insert record
		openConnection();
		query="insert into student values(2,'Rushi','rushi@gmail.com')";
		
		try {
			result=statement.executeUpdate(query);
			if (result!=0) {
				
				System.out.println(result+" rows affected.");
			}
			
	
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			closeConnection();	
		}
		
		//Show inserted record in table
	     openConnection();
	     query="select * from student";
	     
	     try {
			resultSet=statement.executeQuery(query);
			while (resultSet.next()) {
				System.out.println(resultSet.getInt(1)+" | "+
						            resultSet.getString(2)+" | "+  
						            resultSet.getString(3));
			}
		} catch (SQLException e) {
		
			e.printStackTrace();
		}finally {
			closeConnection();
		}
		
		
		
	}
	
	public static void openConnection()
	{
		try {
			file= new FileInputStream(filePat);
			
			properties.load(file);
			
			Class.forName(properties.getProperty("driverPath"));
			
			connection=DriverManager.getConnection(properties.getProperty("dburl"),properties);
			
			statement=connection.createStatement();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	public static void closeConnection()
	{
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
			if (resultSet!=null) {
				resultSet.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

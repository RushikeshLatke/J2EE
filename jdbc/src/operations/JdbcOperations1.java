package operations;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class JdbcOperations1 {
	
	private static Connection connection;
	private static Statement statement;
	private static int result;
	private static ResultSet resultSet;
	private static Properties properties=new Properties();
	private static FileInputStream file;
	private static String filePath="D:\\WEJA2\\jdbc\\src\\resources\\db_info.properties";
	private static String query;
	
	public static void main(String[] args) {
		try {
			openConnection();
			query="create table emp(empno int(10),ename varchar(50),job varchar(30),mgr int(10),hiredate varchar(50),sal int(10),comm int(10), deptno int(10))";
			result=statement.executeUpdate(query);
			System.out.println("Query OK, "+result+" rows affected.");
		} catch (Exception e) {
		     e.printStackTrace();
		}finally {
			closeConnection();
		}
		
		try {
			openConnection();
			Scanner scanner=new Scanner(System.in);
			
			for (int i = 1; i <=14; i++) {
				System.out.println("Enter EmpNo : ");
				int empno= scanner.nextInt();
				
				System.out.println("Enter Ename : ");
				String ename=scanner.next();
				
				System.out.println("Enter Job : ");
				String job=scanner.next();
				
				System.out.println("Enter mgr : ");
				int mgr= scanner.nextInt();
				
				System.out.println("Enter Hiredate : ");
				String hiredate=scanner.next();
				
				System.out.println("Enter Sal : ");
				int sal= scanner.nextInt();
				
				System.out.println("Enter Comm : ");
				int comm= scanner.nextInt();
				
				System.out.println("Enter deptno : ");
				int deptno= scanner.nextInt();
				
				query="insert into emp values("+empno+",'"+ename+"','"+job+"',"+mgr+",'"+hiredate+"',"+sal+","+comm+","+deptno+")";
				
				result=result+statement.executeUpdate(query);
				
				
			}
			System.out.println("Query ok,"+result+"rows affected.");
			scanner.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeConnection();
		}
		
		try {
			openConnection();
			query="select * from emp";
			resultSet=statement.executeQuery(query);
			
			while (resultSet.next()) {
				System.out.println(resultSet.getString(1)+" | "+
						           resultSet.getString(2)+" | "+
						           resultSet.getString(3)+" | "+
						           resultSet.getString(4)+" | "+
						           resultSet.getString(5)+" | "+
						           resultSet.getString(6)+" | "+
						           resultSet.getString(7)+" | "+
						           resultSet.getString(8));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			closeConnection();
	 }
		
	}
	     
	    
	
	private static void openConnection() {
		try {
			file=new FileInputStream(filePath);
			properties.load(file);
			Class.forName(properties.getProperty("driverPath"));
			connection=DriverManager.getConnection(properties.getProperty("dburl"), properties);
			statement=connection.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private static void closeConnection() {
		
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
			if (result != 0) {
				result=0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

}

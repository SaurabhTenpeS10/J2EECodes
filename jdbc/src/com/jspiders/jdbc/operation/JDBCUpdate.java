package com.jspiders.jdbc.operation;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUpdate {
	
	private static Driver driver;
	private static Connection connection;
	private static Statement statement;
//	private static String query1;
	private static String query2;
	
	
	public static void main(String[] args) {
		
		try {
			openConnection();
			statement = connection.createStatement();
//			query = "update users set Email='saurabhtenpe@gmail.com' where Id=1";
			
//			query1= "insert into users values(5,'Rishn','rishn@gmail.com','rishn@123')";
//			boolean res1 = statement.execute(query1);
//			System.out.println(res1);
			
			query2 = "update users set Id=4 where Id=5";
			boolean res2 = statement.execute(query2);
			System.out.println(res2);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
	}
	private static void openConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		driver = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(driver);
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","Mysql#1432");
	}
	
	private static void closeConnection() throws SQLException {
		if(statement !=null) {
			statement.close();
		}
		if(connection !=null) {
			connection.close();
		}
		if(driver !=null) {
			DriverManager.deregisterDriver(driver);
		}
	}
	
}

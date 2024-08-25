package com.jspiders.jdbc.operation;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCSelect4 {
	private static Driver driver;
	private static Connection connection;
	private static Statement statement;
	private static ResultSet resultSet;
	private static String query;
	
	public static void main(String[] args) {
		try {
			openConnection();
			statement = connection.createStatement();
			query = "select * from users  where id<4";
			resultSet = statement.executeQuery(query);
			while(resultSet.next()) {
				System.out.print(resultSet.getInt("id") +" ");
				System.out.print(resultSet.getString("name") +" ");
				System.out.print(resultSet.getString("email") + " ");
				System.out.println(resultSet.getString("password")+ " ");
			}
			} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch 
			e.printStackTrace();
		}finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private static void openConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		driver = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(driver);
		connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "Mysql#1432");
		
	}
	private static void closeConnection() throws SQLException {
		if(statement != null) {
			statement.close();
		}
		if(connection != null) {
			connection.close();
		}
		if(driver != null) {
			DriverManager.deregisterDriver(driver);
		}
	}
}


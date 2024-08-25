package com.jspiders.jdbc.operation;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBCSelect2 {
	private static Driver driver;
	private static PreparedStatement preparedStatement;
	private static Connection connection;
	private static String query;
	private static ResultSet resultSet;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter user id: ");
		int id = scanner.nextInt();
		scanner.close();
		
		try {
			openConnection();
			query = "select * from users where id=?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			boolean res = preparedStatement.execute();
			System.out.println(res);
			resultSet = preparedStatement.getResultSet();
			if(resultSet.next()) {
				System.out.print(resultSet.getInt("id") +" ");
				System.out.print(resultSet.getString("name")+" ");
				System.out.print(resultSet.getString("email")+" ");
				System.out.println(resultSet.getString("password"));
			} else 
				System.out.println("User not Found");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
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
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "Mysql#1432");
	}
	
	private static void closeConnection() throws SQLException {
		if(preparedStatement != null) {
			preparedStatement.close();
		}
		if(connection != null ) {
			connection.close();
		}
		if(driver != null) {
			DriverManager.deregisterDriver(driver);
		}
	}
}


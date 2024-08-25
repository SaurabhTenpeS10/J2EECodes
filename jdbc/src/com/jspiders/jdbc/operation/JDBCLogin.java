package com.jspiders.jdbc.operation;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCLogin {
	private static Driver driver;
	private static Connection connection;
	private static Statement statement;
	private static String query;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("====== Login ====== ");
		
		System.out.println("Enter user email: ");
		String email = scanner.nextLine();
		System.out.println("Enter user password: ");
		String password = scanner.nextLine();
		scanner.close();
		try {
			openConnection();
			statement = connection.createStatement();
			query = "select email from users where email='" + email+ "'and password= '" +password+ "'"; 
			boolean res = statement.execute(query);
			System.out.println(res);
			ResultSet resultSet = statement.getResultSet();
//			Logic 1 - Easy One
//			if(resultSet.next()) {
//				System.out.println("Login Successfull!");
//			}
//			else {
//				System.err.println("Invvalid email or password");
//			}
			
//			Logic 2
			if(resultSet.next()) {
			String email1=resultSet.getString(1);
			if(email.equals(email1)) {
				System.out.println("Login Successfull!");
			}
			else {
				System.err.println("Invvalid email or password");
			}
			}else {
				System.out.println("Invalid Email or Password");
			}
			
			} catch (ClassNotFoundException | SQLException e) {
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
		Driver driver = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(driver);
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","Mysql#1432");
		
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

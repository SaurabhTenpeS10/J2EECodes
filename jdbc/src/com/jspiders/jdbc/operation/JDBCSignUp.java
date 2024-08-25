package com.jspiders.jdbc.operation;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCSignUp {
	private static Driver driver;
	private static Connection connection;
	private static Statement statement;
	private static String query;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter user id: ");
		int id = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter user name: ");
		String name = scanner.nextLine();
		System.out.println("Enter user email: ");
		String email = scanner.nextLine();
		System.out.println("Enter user password: ");
		String password = scanner.nextLine();
		scanner.close();
		try {
			openConnection();
			statement = connection.createStatement();
			query = "insert into users values(" +id+ ",'" +name+ "','" + email+ "','" +password+ "')"; 
			boolean res = statement.execute(query);
			System.out.println(res);
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

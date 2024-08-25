package com.jspiders.jdbc.operation;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Delete2 {
	private static Driver driver;
	private static Connection connection;
	private static PreparedStatement preparedStatement;
	private static String query;
	
	public static void main(String[] args) {
		
		try {
			openConnection();
			query = "delete from users where id=?";
			preparedStatement = connection.prepareStatement(query);
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter Number of Rows to be deleted: ");
			int count = scanner.nextInt();
			for(int i=1; i<=count;i++) {
				System.out.println("Enter user id ");
				int id = scanner.nextInt();
				preparedStatement.setInt(1, id);
				preparedStatement.addBatch();
			}
			scanner.close();
			int [] res = preparedStatement.executeBatch();
			int rows=0;
			for(int i=0; i<res.length;i++) {
				if(res[i] != 0) {
					rows++;
				}
			}
			System.out.println(rows+" row(s) affected ");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
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
		if(preparedStatement != null) {
			preparedStatement.close();
		}
		if(connection != null) {
			connection.close();
		}
		if(driver != null) {
			DriverManager.deregisterDriver(driver);
		}
	}
}

package com.jspiders.jdbc.operation;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

public class JDBCSelect3 {
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
			query = "SELECT * FROM users WHERE id=?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			boolean res = preparedStatement.execute();
			System.out.println(res);
			resultSet = preparedStatement.getResultSet();
			if (resultSet.next()) {
				System.out.print(resultSet.getInt("id") + " ");
				System.out.print(resultSet.getString("name") + " ");
				System.out.print(resultSet.getString("email") + " ");
				System.out.println(resultSet.getString("password"));
			} else {
				System.out.println("User not Found");
			}
		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
		} finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	private static void openConnection() throws ClassNotFoundException, SQLException, IOException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		driver = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(driver);
		
		// Debugging: Print the current working directory
		System.out.println("Current working directory: " + new File(".").getAbsolutePath());
		
		File file = new File("db_info.txt");
		if (!file.exists()) {
			throw new IOException("File not found: " + file.getAbsolutePath());
		}
		
		FileReader fileReader = new FileReader(file);
		Properties properties = new Properties();
		properties.load(fileReader);
		
		connection = DriverManager.getConnection(properties.getProperty("url"), properties);
	}
	
	private static void closeConnection() throws SQLException {
		if (preparedStatement != null) {
			preparedStatement.close();
		}
		if (connection != null) {
			connection.close();
		}
		if (driver != null) {
			DriverManager.deregisterDriver(driver);
		}
	}
}

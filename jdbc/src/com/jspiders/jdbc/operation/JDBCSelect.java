package com.jspiders.jdbc.operation;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCSelect {
	private static Driver driver;
	private static Connection connection;
	private static Statement statement;
	private static ResultSet resultSet;
	private static String query;

	public static void main(String[] args) {
		try {

			openConnection();
			statement = connection.createStatement();
			query = "select * from users";
			boolean res = statement.execute(query);
			System.out.println(res);
			resultSet = statement.getResultSet();
			while (resultSet.next()) {
				System.out.print(resultSet.getInt(1) + " ");
				System.out.print(resultSet.getString(2) + " ");
				System.out.print(resultSet.getString(3) + " ");
				System.out.println(resultSet.getString(4));
			}

			System.out.println();
			// This is a Second Select Query with Where Condition
			query = "select * from users where Id<=3";
			res = statement.execute(query);
			System.out.println(res);
			resultSet = statement.getResultSet();
			while (resultSet.next()) {
				System.out.print(resultSet.getInt(1) + " ");
				System.out.print(resultSet.getString(2) + " ");
				System.out.print(resultSet.getString("email") + " ");
				System.out.println(resultSet.getString("password")); // we can use column name also instead of index
			}
			System.out.println();
			
			
			// This is a 3rd Select query for Particular column e.g email and password
			query = "select email, password from users where Id<=3";
			res = statement.execute(query);
			System.out.println(res);
			resultSet = statement.getResultSet();
			while (resultSet.next()) {
				System.out.print(resultSet.getString(1) + " ");
				System.out.println(resultSet.getString(2));
			}

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
		if (statement != null) {
			statement.close();
		}
		if (connection != null) {
			connection.close();
		}
		if (driver != null) {
			DriverManager.deregisterDriver(driver);
		}
	}
}

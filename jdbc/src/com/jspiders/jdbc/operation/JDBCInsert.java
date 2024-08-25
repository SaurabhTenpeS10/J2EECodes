package com.jspiders.jdbc.operation;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCInsert {

	public static void main(String[] args) {

		try {
			// 1. Load and register the Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			Driver driver = new com.mysql.cj.jdbc.Driver();
			DriverManager.registerDriver(driver);

			// 2. Open connection
			Connection connection = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/jdbc?user=root&password=root");

			// 3. Create or prepare the Statement
			Statement statement = connection.createStatement();

			// 4. Execute the statement
			boolean res = statement.execute("INSERT INTO user VALUES(1, 'Ramesh', 'ramesh@gmail.com', 'Ramesh@1234')");

			// 5. Process the result
			System.out.println(res);

			// 6. Close the connection
			statement.close();
			connection.close();

			// 7. De-register the Driver
			DriverManager.deregisterDriver(driver);

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

}
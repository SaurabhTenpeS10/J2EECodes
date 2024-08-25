package com.jspiders.jdbc.operation;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCInsert4 {

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;

        try {
            // 1. Load and register the Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Open connection
            connection = DriverManager.getConnection("jdbc:mysql://192.168.1.234:3306/demo?user=root&password=root");

            // 3. Create or prepare the Statement
            statement = connection.createStatement();

            // 4. Execute the statement
            boolean res = statement.execute("INSERT INTO user VALUES(1, 'Ramesh')");

            // 5. Process the result
            System.out.println("Record Inserted: " + res);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // 6. Close the connection
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

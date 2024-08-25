package com.jspiders.jdbc.operation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCInsert2 {
    private static Connection connection;
    private static Statement statement;
    private static String query;

    public static void main(String[] args) {
        try {
            openConnection();
            statement = connection.createStatement();
            query = "INSERT INTO users VALUES(2, 'Saurabh', 'saurabh@gmail.com', 'saurabh@1234')";
            // query = "delete from users where Id=1";
            // query = "update users set name ='Saurabh Tenpe' where Id=1";
            boolean res = statement.execute(query);
            System.out.println(res); 
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
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
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "Mysql#1432");
    }

    private static void closeConnection() throws SQLException {
        if (statement != null) {
            statement.close();
        }
        if (connection != null) {
            connection.close();
        }
    }
}

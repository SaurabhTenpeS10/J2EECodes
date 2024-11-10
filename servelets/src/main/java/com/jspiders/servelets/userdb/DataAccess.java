package com.jspiders.servelets.userdb;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jspiders.servelets.entity.User;

public class DataAccess {
	private Driver driver;
	private Connection connection;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	private String query;

	public int addUser(String username, String email, long mobile, String password) {
		int res = -1;
		openConnection();
		query = "Insert into users Values(?,?,?,?)";
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, email);
			preparedStatement.setLong(3, mobile);
			preparedStatement.setString(4, password);

			res = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return res;
	}

	public boolean login(String username, String password) {
		boolean isPresent = false;
		openConnection();
		query = "SELECT * FROM users WHERE username=? AND password=?";
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			resultSet = preparedStatement.executeQuery(); // No need to pass the query string here
			if (resultSet.next()) {
				isPresent = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return isPresent;
	}

	public List<User> findAllUsers() {
		openConnection();

		query = "SELECT * FROM users";
		try {
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		List<User> users = new ArrayList<User>();
		try {
			while (resultSet.next()) {
				User user = new User();
				user.setUsername(resultSet.getString(1));
				user.setEmail(resultSet.getString(2));
				user.setMobile(resultSet.getLong(3));
				user.setPassword(resultSet.getString(4));
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;

	}

	public int deleteUser(String email) {
		openConnection();
		int res = -1;
		query = "delete from users where email=?";
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, email);
			res = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return res;
	}

	public User findUserByEmail(String email) {
		User user = new User();
		openConnection();
		query = "select * from users where email = ?";
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, email);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				user.setUsername(resultSet.getString(1));
				user.setEmail(resultSet.getString(2));
				user.setMobile(resultSet.getLong(3));
				user.setPassword(resultSet.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeConnection();
		}
		return user;
	}

	public int updateUser(String username, String email, Long mobile, String password) {
		int res = -1;
		openConnection();
		query = "update users set username=?, email=?, mobile=?, password=? where email=?";
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, email);
			preparedStatement.setLong(3, mobile);
			preparedStatement.setString(4, password);
			preparedStatement.setString(5, email);

			res = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return res;
	}

	private void openConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			driver = new com.mysql.cj.jdbc.Driver();
			DriverManager.registerDriver(driver);
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/user_module", "root", "Mysql#1432");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	private void closeConnection() {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (preparedStatement != null) {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (driver != null) {
			try {
				DriverManager.deregisterDriver(driver);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}

package com.jspiders.springcore1.bean;

public class DataAccessObject {
	private DatabaseConnection connection;
	
	{
		System.out.println("DataAccess Object is Created");
	}

	public DatabaseConnection getConnection() {
		return connection;
	}

	public void setConnection(DatabaseConnection connection) {
		this.connection = connection;
	}

	@Override
	public String toString() {
		return "DataAccessObject [connection=" + connection + "]";
	}
	
}

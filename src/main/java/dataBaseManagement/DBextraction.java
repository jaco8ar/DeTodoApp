package main.java.dataBaseManagement;

import java.sql.Connection;
	
	
public class DBextraction {
	
	Connection connection;
	
	public DBextraction(Connection connection) {
		this.connection = connection;
	}
	
	
	
	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	
	
}

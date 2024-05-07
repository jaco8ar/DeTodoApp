package main.java.dataBaseManagement;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBconnection {
	
	public static Connection getDBConnection(String environment) {
		
		Connection connection = null;
		String url = "jdbc:h2:./data/";
		String root = "sa";
		String password = "";
		
		try {
			
			connection = DriverManager.getConnection(url + environment, root, password);
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return connection;
	}
	
	public void cleanup() {}
}

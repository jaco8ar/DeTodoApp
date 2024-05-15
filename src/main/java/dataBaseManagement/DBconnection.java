package main.java.dataBaseManagement;

import java.sql.Connection;
import main.java.classes.TargetEnvironment;
import java.sql.DriverManager;

public class DBconnection {
	
	public static Connection getDBConnection(TargetEnvironment environment) {
		
		Connection connection = null;
		
		String url = environment.environmentLabel;
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

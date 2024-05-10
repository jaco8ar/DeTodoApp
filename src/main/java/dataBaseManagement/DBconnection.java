package main.java.dataBaseManagement;

import java.sql.Connection;
import main.java.classes.TargetEnvironment;
import java.sql.DriverManager;

public class DBconnection {
	
	public static Connection getDBConnection(TargetEnvironment environment) {
		
		Connection connection = null;
		
		String url = null;
		
		if (environment == TargetEnvironment.APP) {
			url = "jdbc:h2:./src/main/resources/appDataBase";
		} else if (environment == TargetEnvironment.TESTING) {
			url = "jdbc:h2:./src/test/resources/testDataBase" ;
		}
		
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

package test.java.testDB;

import main.java.dataBaseManagement.DBconnection;
import main.java.classes.TargetEnvironment;
import main.java.dataBaseManagement.AppDBBuilder;
import java.sql.Connection;

public class InformalTesting {

	public static void main(String[] args) {
		
		try (Connection connection = DBconnection.getDBConnection(TargetEnvironment.TESTING)){
		
		AppDBBuilder.buildAppDB(connection);}
		
		catch (Exception e) {
			System.out.println(e);
		}
	}

}

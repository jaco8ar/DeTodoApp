package main.java.dataBaseManagement;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;

public class AppDBBuilder {
	
	Connection appConnection;
	
	public AppDBBuilder() {};
	
	public AppDBBuilder(Connection connection) {
		this.appConnection = connection;
	}
	
	public static void buildAppDB(Connection connection) {
		
		AppDBBuilder builder = new AppDBBuilder();
		builder.setAppConnection(connection);
		
		try {
			builder.buildUserTable();
			builder.buildNoteListTable();
			builder.buildNoteTable();
			builder.buildRecQuestionTable();
			builder.buildSavedPasswordTable();
			builder.buildScreenshotTable();
			builder.buildMusicListTable();
			builder.buildGlobalSLTable();
			builder.buildSongTable();
			builder.buildMListXSongTable();
			builder.buildPendingSongListTable();
			builder.buildPendingSongTable();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void buildUserTable() {
		String createUserTable = "CREATE TABLE IF NOT EXISTS appuser ("	+
				"username VARCHAR(30) PRIMARY KEY, "  +
				"password VARCHAR(50) NOT NULL, "		+
				"lastlog DATE);";
		
		try (Statement statement = appConnection.createStatement()){
			statement.executeUpdate(createUserTable);
			System.out.println("User table succesfully created");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void buildNoteListTable() {
		String createTable = "CREATE TABLE IF NOT EXISTS notelist ("	+
							"nlcode INT AUTO_INCREMENT PRIMARY KEY, " 	+
							"owner VARCHAR(30), " 		+
							"nlname VARCHAR(30), " 		+
							"isrootnl BOOLEAN, "			+
							"path VARCHAR(50), " 		+
							"CONSTRAINT FK_appusernl FOREIGN KEY (owner) " +
							"REFERENCES appuser(username))";
		
		String alterTable = "ALTER TABLE noteList ALTER COLUMN nlcode RESTART WITH 101";
				
		try (Statement statement = appConnection.createStatement()){
			statement.executeUpdate(createTable);
			System.out.println("Notes list table succesfully created");
			statement.executeUpdate(alterTable);
			System.out.println("Starting value set for auto-increment column");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void buildNoteTable() {
		String createTable = "CREATE TABLE IF NOT EXISTS note ("	+
							"title VARCHAR(30) PRIMARY KEY, " 	+
							"createdate DATE NOT NULL, " 		+
							"container INT NOT NULL, " 			+
							"body CLOB, " 						+
							"picfilename VARCHAR(30), "		 	+
							"CONSTRAINT FK_notenl FOREIGN KEY (container) " +
							"REFERENCES notelist(nlcode))";
				
		try (Statement statement = appConnection.createStatement()){
			statement.executeUpdate(createTable);
			System.out.println("Note table succesfully created");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void buildRecQuestionTable() {
		String createTable = "CREATE TABLE IF NOT EXISTS recquestion ("	+
							"question VARCHAR(60) NOT NULL, " 		+
							"answer VARCHAR(60) NOT NULL, "				+
							"recuser VARCHAR(30) NOT NULL, " 			+
							"CONSTRAINT FK_userrecquestion FOREIGN KEY (recuser) " +
							"REFERENCES appuser(username), "+
							"PRIMARY KEY(question, recuser));";
				
		try (Statement statement = appConnection.createStatement()){
			statement.executeUpdate(createTable);
			System.out.println("Recovery question table succesfully created");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void buildSavedPasswordTable() {
		String createTable = "CREATE TABLE IF NOT EXISTS savedpassword ("	+
							"username VARCHAR(30) NOT NULL, " 	+
							"site VARCHAR(60) NOT NULL, " 		+
							"savedby VARCHAR(30) NOT NULL, " 		+
							"password VARCHAR(50) NOT NULL, " +
							"PRIMARY KEY(username, site, savedby)," +
							"CONSTRAINT FK_usersavedpw FOREIGN KEY (savedby) " +
							"REFERENCES appuser(username))";
				
		try (Statement statement = appConnection.createStatement()){
			statement.executeUpdate(createTable);
			System.out.println("Saved password table succesfully created");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public void buildScreenshotTable() {
		String createTable = "CREATE TABLE IF NOT EXISTS screenshot ("	+
							"filename VARCHAR(30) PRIMARY KEY, " 	+
							"path VARCHAR(50) NOT NULL, " 			+
							"datetkn DATE, " 						+
							"tookby VARCHAR(30), "					+
							"CONSTRAINT FK_userscs FOREIGN KEY (tookby) " +
							"REFERENCES appuser(username))";
				
		try (Statement statement = appConnection.createStatement()){
			statement.executeUpdate(createTable);
			System.out.println("Screenshot table succesfully created");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void buildMusicListTable() {
		String createTable = "CREATE TABLE IF NOT EXISTS musiclist ("	+
							"name VARCHAR(30) PRIMARY KEY, " 	+
							"creator VARCHAR(30), " 			+
							"size INT NOT NULL, " 				+
							"genre VARCHAR(60), " 				+
							"CONSTRAINT FK_usermuslis FOREIGN KEY (creator) " +
							"REFERENCES appuser(username))";
				
		try (Statement statement = appConnection.createStatement()){
			statement.executeUpdate(createTable);
			System.out.println("Music list table succesfully created");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void buildGlobalSLTable() {
		String createTable = "CREATE TABLE IF NOT EXISTS globalsl ("+
							"id INT AUTO_INCREMENT PRIMARY KEY, " +
							"size INT NOT NULL) "; 
							
		try (Statement statement = appConnection.createStatement()){
			statement.executeUpdate(createTable);
			System.out.println("Global song list table succesfully created");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void buildSongTable() {
		String createTable = "CREATE TABLE IF NOT EXISTS song ("+
							"name VARCHAR(60) NOT NULL, " +
							"author VARCHAR(30), " +
							"album VARCHAR(30), " +
							"colab VARCHAR(60), " +
							"url VARCHAR (80) PRIMARY KEY, "+
							"gsl INT, " +
							"CONSTRAINT FK_gslsong FOREIGN KEY (gsl) "+
							"REFERENCES globalsl(id))";
		try (Statement statement = appConnection.createStatement()){
			statement.executeUpdate(createTable);
			System.out.println("Song table succesfully created");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void buildMListXSongTable() {
		String createTable = "CREATE TABLE IF NOT EXISTS mlistxsong (" +
                "musiclist VARCHAR(30) NOT NULL, " +
                "songurl VARCHAR(80) NOT NULL, " +
                "CONSTRAINT FK_mlistXmlxs FOREIGN KEY (musiclist) REFERENCES musiclist(name), " +
                "CONSTRAINT FK_songurlXmlxs FOREIGN KEY (songurl) REFERENCES song(url), " +
                "PRIMARY KEY (musiclist, songurl) " +
                ");";

		try (Statement statement = appConnection.createStatement()){
			statement.executeUpdate(createTable);
			System.out.println("MListXSong table succesfully created");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void buildPendingSongListTable() {
		String createTable = "CREATE TABLE IF NOT EXISTS pendingsl ("+
							"id INT AUTO_INCREMENT PRIMARY KEY, " +
							"size INT NOT NULL)";
		try (Statement statement = appConnection.createStatement()){
			statement.executeUpdate(createTable);
			System.out.println("Pending song list table succesfully created");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void buildPendingSongTable() {
		String createTable = "CREATE TABLE IF NOT EXISTS pendingsong ("+
							"confisongurl VARCHAR(80) NOT NULL, " +
							"psl INT NOT NULL, " +
							"coincidence BOOLEAN, " +
							"PRIMARY KEY(confisongurl, psl), " +
							"CONSTRAINT FK_pslpendsong FOREIGN KEY (psl) "+
							"REFERENCES pendingsl(id), " +
							"CONSTRAINT FK_songpendsong FOREIGN KEY (confisongurl) "+
							"REFERENCES song(url)); ";
		try (Statement statement = appConnection.createStatement()){
			statement.executeUpdate(createTable);
			System.out.println("Pending song table succesfully created");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	public Connection getAppConnection() {
		return this.appConnection;
	}
	
	public void setAppConnection(Connection connection) {
		this.appConnection = connection;
	}
	
	
}

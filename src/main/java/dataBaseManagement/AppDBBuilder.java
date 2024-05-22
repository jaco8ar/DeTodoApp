package main.java.dataBaseManagement;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;

public class AppDBBuilder {
	
	private final Connection appConnection;
	
	
	public AppDBBuilder(Connection connection) {
		this.appConnection = connection;
	}
	
	public static void buildAppDB(Connection connection) {
		
		AppDBBuilder builder = new AppDBBuilder(connection);
		
		
		try {
			builder.buildScreenshotPathTable();
			builder.buildUserTable();
			builder.buildNoteListTable();
			builder.buildNoteTable();
			builder.buildRecQuestionTable();
			builder.buildSavedPasswordTable();
			builder.buildScreenshotTable();
			builder.buildMusicListTable();
			builder.buildGlobalSLTable();
			builder.buildSongTable();
			builder.buildSongInListTable();
			builder.buildPendingSongListTable();
			builder.buildPendingSongTable();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void buildScreenshotPathTable() {
		String createTable = "CREATE TABLE IF NOT EXISTS ScreenshotPath ("	+
							"screenshotpathid INT AUTO_INCREMENT PRIMARY KEY, " 	+
							"path VARCHAR(70) NOT NULL)";
		
		String alterTable = "ALTER TABLE ScreenshotPath ALTER COLUMN screenshotpathid RESTART WITH 50";
				
		try (Statement statement = appConnection.createStatement()){
			statement.executeUpdate(createTable);
			System.out.println("Screenshot path table succesfully created");
			statement.executeUpdate(alterTable);
			System.out.println("Starting value set for auto-increment column");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void buildUserTable() {
		String createUserTable = "CREATE TABLE IF NOT EXISTS AppUser ("	+
				"username VARCHAR(30) PRIMARY KEY, "  +
				"password VARCHAR(50) NOT NULL, "		+
				"lastlog DATE," +
				"scspath INT, " +
				"CONSTRAINT FK_appuserscspath FOREIGN KEY (scspath) " +
				"REFERENCES ScreenshotPath(screenshotpathid))";
		
		try (Statement statement = appConnection.createStatement()){
			statement.executeUpdate(createUserTable);
			System.out.println("User table succesfully created");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void buildNoteListTable() {
		String createTable = "CREATE TABLE IF NOT EXISTS NoteList ("	+
							"nlcode INT AUTO_INCREMENT PRIMARY KEY, " 	+
							"owner VARCHAR(30), " 		+
							"nlname VARCHAR(30), " 		+
							"isrootnl BOOLEAN, "			+
							"path VARCHAR(50), " 		+
							"CONSTRAINT FK_appusernl FOREIGN KEY (owner) " +
							"REFERENCES AppUser(username))";
		
		String alterTable = "ALTER TABLE NoteList ALTER COLUMN nlcode RESTART WITH 101";
				
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
		String createTable = "CREATE TABLE IF NOT EXISTS Note ("	+
							"title VARCHAR(30) PRIMARY KEY, " 	+
							"createdate DATE NOT NULL, " 		+
							"container INT NOT NULL, " 			+
							"body CLOB, " 						+
							"picfilename VARCHAR(30), "		 	+
							"CONSTRAINT FK_notenl FOREIGN KEY (container) " +
							"REFERENCES NoteList(nlcode))";
				
		try (Statement statement = appConnection.createStatement()){
			statement.executeUpdate(createTable);
			System.out.println("Note table succesfully created");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void buildRecQuestionTable() {
		String createTable = "CREATE TABLE IF NOT EXISTS RecoveryQuestion ("	+
							"question VARCHAR(60) NOT NULL, " 		+
							"answer VARCHAR(60) NOT NULL, "				+
							"recuser VARCHAR(30) NOT NULL, " 			+
							"CONSTRAINT FK_userrecquestion FOREIGN KEY (recuser) " +
							"REFERENCES AppUser(username), "+
							"PRIMARY KEY(question, recuser));";
				
		try (Statement statement = appConnection.createStatement()){
			statement.executeUpdate(createTable);
			System.out.println("Recovery question table succesfully created");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void buildSavedPasswordTable() {
		String createTable = "CREATE TABLE IF NOT EXISTS SavedPassword ("	+
							"username VARCHAR(30) NOT NULL, " 	+
							"site VARCHAR(60) NOT NULL, " 		+
							"savedby VARCHAR(30) NOT NULL, " 		+
							"password VARCHAR(64) NOT NULL, " +
							"PRIMARY KEY(username, site, savedby)," +
							"CONSTRAINT FK_usersavedpw FOREIGN KEY (savedby) " +
							"REFERENCES AppUser(username))";
				
		try (Statement statement = appConnection.createStatement()){
			statement.executeUpdate(createTable);
			System.out.println("Saved password table succesfully created");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public void buildScreenshotTable() {
		String createTable = "CREATE TABLE IF NOT EXISTS Screenshot ("	+
							"filename VARCHAR(30) PRIMARY KEY, " 	+
							"path VARCHAR(50) NOT NULL, " 			+
							"datetkn DATE, " 						+
							"tookby VARCHAR(30), "					+
							"scspath VARCHAR(70) NOT NULL, " 			+
							"CONSTRAINT FK_userscspath FOREIGN KEY (scspath) " 	+
							"REFERENCES ScreenshotPath(screenshotpathid), " 	+
							"CONSTRAINT FK_userscs FOREIGN KEY (tookby) " 		+
							"REFERENCES AppUser(username))";
				
		try (Statement statement = appConnection.createStatement()){
			statement.executeUpdate(createTable);
			System.out.println("Screenshot table succesfully created");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void buildMusicListTable() {
		String createTable = "CREATE TABLE IF NOT EXISTS MusicList ("	+
							"name VARCHAR(30) PRIMARY KEY, " 	+
							"creator VARCHAR(30), " 			+
							"size INT NOT NULL, " 				+
							"genre VARCHAR(60), " 				+
							"CONSTRAINT FK_usermuslis FOREIGN KEY (creator) " +
							"REFERENCES AppUser(username))";
				
		try (Statement statement = appConnection.createStatement()){
			statement.executeUpdate(createTable);
			System.out.println("Music list table succesfully created");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void buildGlobalSLTable() {
		String createTable = "CREATE TABLE IF NOT EXISTS GlobalSL ("+
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
		String createTable = "CREATE TABLE IF NOT EXISTS Song ("+
							"name VARCHAR(60) NOT NULL, " +
							"author VARCHAR(30), " +
							"album VARCHAR(30), " +
							"colab VARCHAR(60), " +
							"url VARCHAR (80) PRIMARY KEY, "+
							"gsl INT, " +
							"CONSTRAINT FK_gslsong FOREIGN KEY (gsl) "+
							"REFERENCES GlobalSL(id))";
		try (Statement statement = appConnection.createStatement()){
			statement.executeUpdate(createTable);
			System.out.println("Song table succesfully created");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void buildSongInListTable() {
		String createTable = "CREATE TABLE IF NOT EXISTS SongInList (" +
                "musiclist VARCHAR(30) NOT NULL, " +
                "songurl VARCHAR(80) NOT NULL, " +
                "CONSTRAINT FK_mlistXmlxs FOREIGN KEY (musiclist) REFERENCES MusicList(name), " +
                "CONSTRAINT FK_songurlXmlxs FOREIGN KEY (songurl) REFERENCES Song(url), " +
                "PRIMARY KEY (musiclist, songurl) " +
                ");";

		try (Statement statement = appConnection.createStatement()){
			statement.executeUpdate(createTable);
			System.out.println("SongInList table succesfully created");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void buildPendingSongListTable() {
		String createTable = "CREATE TABLE IF NOT EXISTS PendingSL ("+
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
		String createTable = "CREATE TABLE IF NOT EXISTS PendingSong ("+
							"confisongurl VARCHAR(80) NOT NULL, " +
							"psl INT NOT NULL, " +
							"coincidence BOOLEAN, " +
							"PRIMARY KEY(confisongurl, psl), " +
							"CONSTRAINT FK_pslpendsong FOREIGN KEY (psl) "+
							"REFERENCES PendingSL(id), " +
							"CONSTRAINT FK_songpendsong FOREIGN KEY (confisongurl) "+
							"REFERENCES Song(url)); ";
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
	
	
	
}

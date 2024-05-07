package main.java.classes;

//import java.util.Date;
import java.sql.Date;

public class User {
	String username;
	String password;
	Date lastlog;
	
	public User(String username, String password, Date lastlog) {
		this.username = username;
		this.password = password;
		this.lastlog = lastlog;
	}
	
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	
	
	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getLastlog() {
		return lastlog;
	}

	public void setLastlog(Date lastlog) {
		this.lastlog = lastlog;
	}
	
	
	
}

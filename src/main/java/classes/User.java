package main.java.classes;

//import java.util.Date;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="AppUser")

public class User {
	@Id 
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	
	@Column(name="lastlog")
	private Date lastlog;
	
	@ManyToOne
	@JoinColumn (name = "scspath", referencedColumnName = "screenshotpathid")
	private ScreenshotPath screenshotsPath;
	
	public User(String username, String password, Date lastlog) {
		this.username = username;
		this.password = password;
		this.lastlog = lastlog;
	}
	
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public User() {}
	
	
	
	

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

	public ScreenshotPath getScreenshotsPath() {
		return screenshotsPath;
	}

	public void setScreenshotsPath(ScreenshotPath screenshotsPath) {
		this.screenshotsPath = screenshotsPath;
	}
	
	
	
}

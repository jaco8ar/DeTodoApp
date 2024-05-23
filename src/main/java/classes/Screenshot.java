package main.java.classes;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import java.sql.Date;
import jakarta.persistence.Column;

@Entity
@Table (name = "Screenshot")
public class Screenshot extends Picture {
	
	@Column (name = "datetkn")
	private Date dateTaken;
	
	@ManyToOne
	@JoinColumn (name = "tookby", referencedColumnName = "username")
	private User tookBy;

	@ManyToOne
	@JoinColumn (name = "scspath", referencedColumnName = "screenshotpathid")
	private ScreenshotPath path;

	public ScreenshotPath getPath() {
		return path;
	}

	public void setPath(ScreenshotPath path) {
		this.path = path;
	}

	public Date getDateTaken() {
		return dateTaken;
	}

	public void setDateTaken(Date dateTaken) {
		this.dateTaken = dateTaken;
	}

	public User getTookBy() {
		return tookBy;
	}

	public void setTookBy(User tookBy) {
		this.tookBy = tookBy;
	}
	
	
}

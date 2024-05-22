package main.java.classes;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import java.sql.Date;
import jakarta.persistence.Column;

@Entity
@Table (name = "Screenshot")
public class Screenshot {
	@Id 
	private String filename;

	@Column (name = "path")
	private String path;
	
	@Column (name = "datetkn")
	private Date dateTaken;
	
	@ManyToOne
	@JoinColumn (name = "tookby", referencedColumnName = "username")
	private User tookBy;

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
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

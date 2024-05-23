package main.java.classes;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table (name = "ScreenshotPath")
public class ScreenshotPath implements PictureFolder{
	
	@Id
	@Column (name = "nlcode")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int scPathId;
	
	@Column (name = "path")
	private String path;
	
	@OneToMany (mappedBy = "Screenshot")
	private List<Screenshot> scsStored;

	public int getScPathId() {
		return scPathId;
	}

	public void setScPathId(int scPathId) {
		this.scPathId = scPathId;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public List<Screenshot> getScsStored() {
		return scsStored;
	}

	public void setScsStored(List<Screenshot> scsStored) {
		this.scsStored = scsStored;
	}
	
	
}

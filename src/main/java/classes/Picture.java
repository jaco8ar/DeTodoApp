package main.java.classes;

import java.awt.image.BufferedImage;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Picture {
	
	@Id
    @Column(name = "picfilename")
    private String picFilename;
	
	private BufferedImage picture;

	public String getPicFilename() {
		return picFilename;
	}

	public void setPicFilename(String picFilename) {
		this.picFilename = picFilename;
	}

	public BufferedImage getPicture() {
		return picture;
	}

	public void setPicture(BufferedImage picture) {
		this.picture = picture;
	}
	
	
}

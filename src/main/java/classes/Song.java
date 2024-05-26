package main.java.classes;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Column;

@Entity
@Table(name = "Song")
public class Song {
	@Id 
	@Column (name = "url")
	private String url;
	
	@Column (name = "name")
	private String name;
	
	@Column (name = "author")
	private String author;
	
	@Column (name = "album")
	private String album;
	
	@Column (name = "colab")
	private String colab;
	
	@ManyToOne 
	@JoinColumn (name = "gsl", referencedColumnName = "id")
	private int gslId;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public String getColab() {
		return colab;
	}

	public void setColab(String colab) {
		this.colab = colab;
	}

	public int getGslId() {
		return gslId;
	}

	public void setGslId(int gslId) {
		this.gslId = gslId;
	}
	
	
	
	
}

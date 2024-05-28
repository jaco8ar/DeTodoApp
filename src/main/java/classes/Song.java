package main.java.classes;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

import java.util.Objects;

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
	private GlobalSL gslId;

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

	public GlobalSL getGslId() {
		return gslId;
	}

	public void setGslId(GlobalSL gslId) {
		this.gslId = gslId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(album, author, colab, gslId, name, url);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Song other = (Song) obj;
		return Objects.equals(album, other.album) && Objects.equals(author, other.author)
				&& Objects.equals(colab, other.colab) && Objects.equals(gslId, other.gslId)
				&& Objects.equals(name, other.name) && Objects.equals(url, other.url);
	}
	
	
	
	
}

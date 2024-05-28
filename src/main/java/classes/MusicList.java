package main.java.classes;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table (name = "MusicList")
public class MusicList implements SongList {
	
	@Id 
	@Column (name = "id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column (name = "name")
	private String name;
	
	@ManyToOne
	@JoinColumn (name = "creator", referencedColumnName = "username")
	private User creator;

	@Column (name = "size")
	private int size;	

	@Column (name = "genre")
	private String genre;
	
	@ManyToMany
	@JoinTable(name = "SongInList", 
				joinColumns = @JoinColumn(name = "musiclist"),
				inverseJoinColumns = @JoinColumn(name = "songurl"))
	private List<Song> songs ;

	@Override
	public void addSong(Song song) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeSong(Song song) {
		// TODO Auto-generated method stub

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	
	
}

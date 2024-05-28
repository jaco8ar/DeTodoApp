package main.java.classes;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table (name = "GlobalSL")
public class GlobalSL implements SongList {
	
	@Id
	@Column(name = "id")
	private int id;
	
	@Column (name = "size")
	private int size;
	
	@OneToMany (mappedBy = "Song")
	private List<Song> EverySong;
	

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

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public List<Song> getEverySong() {
		return EverySong;
	}

	public void setEverySong(List<Song> everySong) {
		EverySong = everySong;
	}

	@Override
	public int hashCode() {
		return Objects.hash(EverySong, id, size);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GlobalSL other = (GlobalSL) obj;
		return Objects.equals(EverySong, other.EverySong) && id == other.id && size == other.size;
	}

	
}

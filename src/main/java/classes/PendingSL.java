package main.java.classes;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table (name = "PendingSL")
public class PendingSL implements SongList{
	
	@Id 
	@Column (name = "id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column (name = "size")
	private int size;
	
	@OneToMany(mappedBy = "PendingSong")
	private List<PendingSong> pendingSongList;
	

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

	public List<PendingSong> getPendingSongList() {
		return pendingSongList;
	}

	public void setPendingSongList(List<PendingSong> pendingSongList) {
		this.pendingSongList = pendingSongList;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, pendingSongList, size);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PendingSL other = (PendingSL) obj;
		return id == other.id && Objects.equals(pendingSongList, other.pendingSongList) && size == other.size;
	}

	
	
	
	

}

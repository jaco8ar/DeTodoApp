package main.java.classes;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "notelist")
public class NoteList {
	@Id
	@Column (name = "nlcode")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int noteListCode;
	
	@ManyToOne
	@JoinColumn (name = "owner", referencedColumnName = "username")
	private User owner;
	
	@Column (name = "nlname")
	private String noteListName;
	
	@Column (name = "isrootnl")
	private Boolean isRootNoteList;
	
	@Column (name = "path")
	private String picPath;
	
	@OneToMany(mappedBy = "note")
	private List<Note> Notes;
	
	
	
	
	public int getNoteListCode() {
		return noteListCode;
	}
	public void setNoteListCode(int noteListCode) {
		this.noteListCode = noteListCode;
	}
	public User getOwner() {
		return owner;
	}
	public void setOwner(User owner) {
		this.owner = owner;
	}
	public String getNoteListName() {
		return noteListName;
	}
	public void setNoteListName(String noteListName) {
		this.noteListName = noteListName;
	}
	public Boolean getIsRootNoteList() {
		return isRootNoteList;
	}
	public void setIsRootNoteList(Boolean isRootNoteList) {
		this.isRootNoteList = isRootNoteList;
	}
	public String getPicPath() {
		return picPath;
	}
	public void setPicPath(String picPath) {
		this.picPath = picPath;
	}
	public List<Note> getNotes() {
		return Notes;
	}
	public void setNotes(List<Note> notes) {
		Notes = notes;
	}
	
	
}

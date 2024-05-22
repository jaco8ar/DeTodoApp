package main.java.classes;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Note")
class Note {
	
	@Id
	@Column (name = "title")
	private String title;
	
	@Column (name = "createdate")
	private Date creationDate;
	
	@ManyToOne
	@JoinColumn (name = "container", referencedColumnName = "nlcode")
	private NoteList noteList;
	
	@Column (name = "body")
	private String body;
	
	@Column (name = "picfilename")
	private String picFileName;

	
	
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public NoteList getNoteList() {
		return noteList;
	}

	public void setNoteList(NoteList noteList) {
		this.noteList = noteList;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getPicFileName() {
		return picFileName;
	}

	public void setPicFileName(String picFileName) {
		this.picFileName = picFileName;
	}
	
	
	
	
}

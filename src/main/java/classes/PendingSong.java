package main.java.classes;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.JoinColumn;
import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;

@Entity
@Table (name = "PendingSong")
public class PendingSong{
	
	@EmbeddedId
	private SongUrlPslPK confiSongUrlPslPK;
	
	@Column (name = "coincidence")
	private Boolean coincidence;
	
	
	
	public SongUrlPslPK getConfiSongUrlPslPK() {
		return confiSongUrlPslPK;
	}

	public void setConfiSongUrlPslPK(SongUrlPslPK confiSongUrlPslPK) {
		this.confiSongUrlPslPK = confiSongUrlPslPK;
	}

	public Boolean getCoincidence() {
		return coincidence;
	}

	public void setCoincidence(Boolean coincidence) {
		this.coincidence = coincidence;
	}
	
	
	

	@Override
	public int hashCode() {
		return Objects.hash(coincidence, confiSongUrlPslPK);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PendingSong other = (PendingSong) obj;
		return Objects.equals(coincidence, other.coincidence)
				&& Objects.equals(confiSongUrlPslPK, other.confiSongUrlPslPK);
	}




@Embeddable	
class SongUrlPslPK implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@OneToOne (cascade = CascadeType.ALL)
	@JoinColumn (name = "confisongurl", referencedColumnName = "url")
	private Song confiSongUrl;
	
	@ManyToOne
	@JoinColumn (name = "psl", referencedColumnName = "id")
	private PendingSL psl;

	public Song getConfiSongUrl() {
		return confiSongUrl;
	}

	public void setConfiSongUrl(Song confiSongUrl) {
		this.confiSongUrl = confiSongUrl;
	}

	public PendingSL getPsl() {
		return psl;
	}

	public void setPsl(PendingSL psl) {
		this.psl = psl;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + getEnclosingInstance().hashCode();
		result = prime * result + Objects.hash(confiSongUrl, psl);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SongUrlPslPK other = (SongUrlPslPK) obj;
		if (!getEnclosingInstance().equals(other.getEnclosingInstance()))
			return false;
		return Objects.equals(confiSongUrl, other.confiSongUrl) && Objects.equals(psl, other.psl);
	}

	private PendingSong getEnclosingInstance() {
		return PendingSong.this;
	}
	
	
	
}

}

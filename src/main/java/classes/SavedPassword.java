package main.java.classes;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import main.java.crypto.Cryptography;
import jakarta.persistence.EmbeddedId;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;


@Entity 
@Table (name = "SavedPassword")
public class SavedPassword {
	@EmbeddedId
	private UserSiteSavedbyPK usernameSiteSavedByPK;
	
	@Column (name = "password")
	private String password;
	
	protected SavedPassword() {}
	
	public SavedPassword(String username, String site, User savedBy, String password, String userPassword) throws Exception {
		usernameSiteSavedByPK.setUsername(username);
		usernameSiteSavedByPK.setSite(site);
		usernameSiteSavedByPK.setSavedBy(savedBy);
		setPassword(password, userPassword);
	}
	
	public UserSiteSavedbyPK getUsernameSiteSavedByPK() {
		return usernameSiteSavedByPK;
	}
	//change
	public void setUsername(String username) {
		this.usernameSiteSavedByPK.setUsername(username);
	}
	
	public void setSite(String site) {
		this.usernameSiteSavedByPK.setUsername(site);
	}
	
	public void setSavedBy(User sabedByUser) {
		this.usernameSiteSavedByPK.setSavedBy(sabedByUser);
	}
	
	public String getPassword(String userPassword) throws Exception{
		return Cryptography.decrypt(this.password, userPassword);
	}

	public void setPassword(String password, String userPassword) throws Exception {
		this.password = Cryptography.encrypt(password, userPassword);
	}

	@Override
	public int hashCode() {
		return Objects.hash(password, usernameSiteSavedByPK);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SavedPassword other = (SavedPassword) obj;
		return Objects.equals(password, other.password)
				&& Objects.equals(usernameSiteSavedByPK, other.usernameSiteSavedByPK);
	}





@Embeddable	
class UserSiteSavedbyPK implements Serializable{
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		@Column (name= "username")
		private String username;
		
		@Column (name = "site")
		private String site;
		
		@ManyToOne
		@JoinColumn (name = "savedby", referencedColumnName = "username")
		private User savedBy;

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getSite() {
			return site;
		}

		public void setSite(String site) {
			this.site = site;
		}

		public User getSavedBy() {
			return savedBy;
		}

		public void setSavedBy(User savedBy) {
			this.savedBy = savedBy;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getEnclosingInstance().hashCode();
			result = prime * result + Objects.hash(savedBy, site, username);
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
			UserSiteSavedbyPK other = (UserSiteSavedbyPK) obj;
			if (!getEnclosingInstance().equals(other.getEnclosingInstance()))
				return false;
			return Objects.equals(savedBy, other.savedBy) && Objects.equals(site, other.site)
					&& Objects.equals(username, other.username);
		}

		private SavedPassword getEnclosingInstance() {
			return SavedPassword.this;
		}

		
		
		
		
	}
	
}

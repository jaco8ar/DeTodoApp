package main.java.classes;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import main.java.crypto.Cryptography;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;


@Entity 
@Table (name = "savedpassword")
public class SavedPassword {
	@EmbeddedId
	private PrimaryKey usernameSiteSavedByPK;
	
	@Column (name = "password")
	private String password;
	
	protected SavedPassword() {}
	
	public SavedPassword(String username, String site, User savedBy, String password, String userPassword) throws Exception {
		usernameSiteSavedByPK.setUsername(username);
		usernameSiteSavedByPK.setSite(site);
		usernameSiteSavedByPK.setSavedBy(savedBy);
		setPassword(password, userPassword);
	}
	
	public PrimaryKey getUsernameSiteSavedByPK() {
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



@Embeddable	
class PrimaryKey{
		@Column (name= "username")
		private String username;
		
		@Column (name = "site")
		private String site;
		
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
		
		
	}
	
}

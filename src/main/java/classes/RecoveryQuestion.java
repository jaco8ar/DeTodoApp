package main.java.classes;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table (name = "RecoveryQuestion")
public class RecoveryQuestion {
	@EmbeddedId
	private PrimaryKey questionAndUser;
	
	@Column (name = "answer")
	private String answer;
	
	protected RecoveryQuestion () {}
	
	public RecoveryQuestion (String question, String answer, User recoveryUser) {
		this.questionAndUser.setQuestion(question);
		this.questionAndUser.setRecoveryUser(recoveryUser);
		this.answer = answer;
	}
		
	
	public PrimaryKey getQuestionAndUser() {
		return questionAndUser;
	}
	public void setQuestionAndUser(PrimaryKey questionAndUser) {
		this.questionAndUser = questionAndUser;
	}

	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	
	

@Embeddable
static class PrimaryKey implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column (name = "question")
	private String question;
	
	@ManyToOne 
	@JoinColumn (name = "recuser", referencedColumnName = "username")
	private User recoveryUser;

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public User getRecoveryUser() {
		return recoveryUser;
	}

	public void setRecoveryUser(User recoveryUser) {
		this.recoveryUser = recoveryUser;
	}

	@Override
	public int hashCode() {
		return Objects.hash(question, recoveryUser);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PrimaryKey other = (PrimaryKey) obj;
		return Objects.equals(question, other.question) && Objects.equals(recoveryUser, other.recoveryUser);
	}
	
	
}

}


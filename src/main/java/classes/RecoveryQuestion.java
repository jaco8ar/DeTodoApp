package main.java.classes;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table (name = "recquestion")
public class RecoveryQuestion {
	@EmbeddedId
	private PrimaryKey questionAndUser;
	
	@Column (name = "answer")
	private String answer;
		
	
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
static class PrimaryKey {
	@Column (name = "question")
	private String question;
	
	@Column (name = "recuser")
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
	
	
}

}


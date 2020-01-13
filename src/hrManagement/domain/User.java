package hrManagement.domain;

public class User {
	
	private String id;
	private String userName;
	private String password;
	private String role;
	private String question;
	private String answer;
	
	public User(String id, String userName, String password, String role,String question, String answer) {
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.role = role;
		this.question = question;
		this.answer = answer;
	}
	

	public String getQuestion() {
		return question;
	}


	public void setQuestion(String question) {
		this.question = question;
	}


	public String getAnswer() {
		return answer;
	}


	public void setAnswer(String answer) {
		this.answer = answer;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	

}

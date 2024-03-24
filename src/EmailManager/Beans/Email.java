package EmailManager.Beans;

public class Email {
	
	private int Number;
	private int userId;
	private String Subject;
	private String reciever;
	private String content;
	private String AttachementPath;
	private String dateEnvoie;
	
	

	public Email() {
		// recieverDO Aureciever-generated construcrecieverr stub
	}
	
	
	@Override
	public String toString() {
		return "Email [Number=" + Number + ", userId=" + userId + ", Subject=" + Subject + ", reciever=" + reciever
				+ ", content=" + content + ", AttachementPath=" + AttachementPath + ", dateEnvoie=" + dateEnvoie + "]";
	}


	public Email( int id, String subject, String reciever, String content, String path) {
		super();

		Subject = subject;
		this.userId = id;
		this.reciever = reciever;
		this.content = content;
		this.AttachementPath = path;
	}
	


	

	public void setNumber(int number) {
		Number = number;
	}


	public int getNumber() {
		return Number;
	}



	public String getSubject() {
		return Subject;
	}

	public void setSubject(String subject) {
		Subject = subject;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int id) {
		this.userId = id;
	}

	public String getReciever() {
		return reciever;
	}

	public void setReciever(String reciever) {
		this.reciever = reciever;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getdateEnvoie() {
		return dateEnvoie;
	}

	public void setdateEnvoie(String dateEnvoie) {
		this.dateEnvoie = dateEnvoie;
	}


	public String getAttachementPath() {
		return AttachementPath;
	}


	public void setAttachementPath(String attachementPath) {
		AttachementPath = attachementPath;
	}
	
		

}

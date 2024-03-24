package EmailManager.Beans;

public class Archive {
	
	private int  number;
	private int userId;
	private String Subject;
	private String sender;
	private String content;
	private String dateReception;
	

	public Archive() {
		// TODO Auto-generated constructor stub
		
	}


	public Archive( int userId, String subject, String sender, String content) {
		super();

		this.userId = userId;
		Subject = subject;
		this.sender = sender;
		this.content = content;
	}


	public Archive(int number, int userId, String subject, String sender, String content) {
		super();
		this.number = number;
		this.userId = userId;
		Subject = subject;
		this.sender = sender;
		this.content = content;
	}


	public int getNumber() {
		return number;
	}


	public int getUserId() {
		return userId;
	}


	public String getSubject() {
		return Subject;
	}


	public String getSender() {
		return sender;
	}


	public String getContent() {
		return content;
	}


	public String getDateReception() {
		return dateReception;
	}


	public void setNumber(int number) {
		this.number = number;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public void setSubject(String subject) {
		Subject = subject;
	}


	public void setSender(String sender) {
		this.sender = sender;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public void setDateReception(String dateReception) {
		this.dateReception = dateReception;
	}


	@Override
	public String toString() {
		return "Archive [number=" + number + ", userId=" + userId + ", Subject=" + Subject + ", sender=" + sender
				+ ", content=" + content + ", dateReception=" + dateReception + "]";
	}
	
	

}

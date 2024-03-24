package EmailManager.Beans;

public class MessageEmail {
	
	private int Number;
	private String Subject;
	private String From;
	private String content;
	private String dateReception;
	private boolean archived = false;
	private boolean deleted= false ;
	
	

	public boolean isArchived() {
		return archived;
	}


	public boolean isDeleted() {
		return deleted;
	}


	public void setArchived(boolean archived) {
		this.archived = archived;
	}


	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}


	public MessageEmail() {
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "MessageEmail [Number=" + Number + ", Subject=" + Subject + ", From=" + From + ", dateReception="
				+ dateReception + "]";
	}


	public MessageEmail(int number, String subject, String from, String dateReception) {
		super();
		Number = number;
		Subject = subject;
		From = from;
		this.dateReception = dateReception;
	}


	public int getNumber() {
		return Number;
	}


	public String getSubject() {
		return Subject;
	}


	public String getFrom() {
		return From;
	}


	public String getDateReception() {
		return dateReception;
	}


	public void setNumber(int number) {
		Number = number;
	}


	public void setSubject(String subject) {
		Subject = subject;
	}


	public void setFrom(String from) {
		From = from;
	}


	public void setDateReception(String dateReception) {
		this.dateReception = dateReception;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}
	
	
	

}

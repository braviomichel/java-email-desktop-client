package EmailManager.service;

import java.util.ArrayList;

import EmailManager.Beans.MessageEmail;




public interface InboxControler {
	
	public ArrayList<MessageEmail> check(String username , String pass);
	public boolean ReadEmail();
	public boolean ArchiveEmail(MessageEmail e);
	public void deleteEmail();

}

package EmailManager.service;

import java.util.ArrayList;

import EmailManager.Beans.Email;
import EmailManager.Beans.ListUser;
import EmailManager.Beans.User;

public interface SentControler {
	
	
	public void Send(Email e);
	public void SendToList(Email e, ListUser l);
	public ArrayList<Email> getHistorique(User u);
	public boolean deleteEmail(int num);

}

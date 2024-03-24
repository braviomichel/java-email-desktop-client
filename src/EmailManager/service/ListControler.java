package EmailManager.service;

import java.util.ArrayList;

import EmailManager.Beans.ListUser;
import EmailManager.Beans.User;

public interface ListControler {
	
	
	public void createList(User u, ListUser l);
	public ListUser getList(String key);
	public ArrayList<ListUser> getLists(User u);
	public ListUser addUser(User admin , User u, ListUser l);
	public ListUser deleteUser(User admin, User u, ListUser l);	
	public boolean deleteList(User u, String key);
	

}

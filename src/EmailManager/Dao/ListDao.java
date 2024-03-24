package EmailManager.Dao;

import java.util.ArrayList;


import EmailManager.Beans.ListUser;
import EmailManager.Beans.User;


public interface ListDao {
	
	public void insertList(User u, ListUser l1);
	public ListUser selectListByKey(String key);
	public ArrayList<ListUser> selectList(User u);
	public ListUser addUser(User admin, User u ,ListUser l1);
	public ListUser deleteUser(User admin, User u ,ListUser l1);
	public boolean deleteList(User u, String key);

}

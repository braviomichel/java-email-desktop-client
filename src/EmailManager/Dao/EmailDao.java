package EmailManager.Dao;

import java.util.ArrayList;

import EmailManager.Beans.Email;
import EmailManager.Beans.User;

public interface EmailDao {
	
	
	public Email insertEmail(Email e);
	public Email selectById(int id);
	public ArrayList<Email> selectEmail(User u);
	public boolean deleteEmail(int num);

}

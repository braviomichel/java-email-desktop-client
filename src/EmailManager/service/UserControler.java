package EmailManager.service;

import EmailManager.Beans.User;
import EmailManager.Dao.UserDaoImp;

public class UserControler {
	
	private UserDaoImp dao;

	public UserControler() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	public UserControler(UserDaoImp dao) {
		super();
		this.dao = dao;
	}


	public User login(User u) {
		
		return dao.selectUser(u);
	}

}

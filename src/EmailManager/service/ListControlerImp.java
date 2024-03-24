package EmailManager.service;

import java.util.ArrayList;

import EmailManager.Beans.ListUser;
import EmailManager.Beans.User;
import EmailManager.Dao.ListDaoImpl;


public class ListControlerImp implements ListControler {
	
	private ListDaoImpl dao;
	

	public ListControlerImp(ListDaoImpl dao) {
		// TODO Auto-generated constructor stub
		System.out.println("entree en listecontroler");
		this.dao = dao;
	}

	@Override
	public void createList(User u, ListUser l) {
		// TODO Auto-generated method stub
		dao.insertList(u, l);
		
	}

	@Override
	public ListUser getList(String key) {
		// TODO Auto-generated method stub
		return dao.selectListByKey(key);
	}

	@Override
	public ArrayList<ListUser> getLists(User u) {
		// TODO Auto-generated method stub
		return dao.selectList(u);
	}

	
	@Override
	public boolean deleteList(User u, String key) {
		// TODO Auto-generated method stub
		return dao.deleteList(u, key);
	}

	@Override
	public ListUser addUser(User admin, User u, ListUser l) {
		// TODO Auto-generated method stub
		return dao.addUser(admin,u,l);
	}

	@Override
	public ListUser deleteUser(User admin, User u, ListUser l) {
		// TODO Auto-generated method stub
		return dao.deleteUser(admin,u,l);
	}

}

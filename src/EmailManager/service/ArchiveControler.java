package EmailManager.service;

import EmailManager.Beans.Archive;
import EmailManager.Beans.User;
import EmailManager.Dao.ArchiveDao;

import java.util.ArrayList;

public class ArchiveControler {
	
	private ArchiveDao dao;

	public ArchiveControler() {
		// TODO Auto-generated constructor stub
	}

	public ArchiveControler(ArchiveDao dao) {
		super();
		this.dao = dao;
	}
	
	
	public Archive archiver( User u, Archive a) {
		
		return dao.insertArchive(u,a);
		
	}
	
	public ArrayList <Archive> getArchive(User u){
		
		return dao.select(u) ;
	}
	
	public Archive unarchive(Archive a) {
		
		return dao.retrieve(a);
	}
	
	public boolean delete(Archive a) {
		return dao.delete(a);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public ArchiveDao getDao() {
		return dao;
	}

	public void setDao(ArchiveDao dao) {
		this.dao = dao;
	}
	
	
	

}

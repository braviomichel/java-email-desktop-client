package EmailManager.Dao;

import java.util.ArrayList;

import EmailManager.Beans.Archive;
import EmailManager.Beans.User;

public interface ArchiveDao {
	
	
	public Archive insertArchive(User u, Archive a);
	public ArrayList<Archive> selectArchiveByKey(String key);
	public ArrayList<Archive> select(User u);
	public Archive retrieve(Archive a);
	public boolean delete(Archive a);

}

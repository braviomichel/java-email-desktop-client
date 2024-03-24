package EmailManager.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import EmailManager.Beans.Archive;

import EmailManager.Beans.User;

public class ArchiveDaoImp implements ArchiveDao {

	public ArchiveDaoImp() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Archive insertArchive(User u, Archive a) {
		// TODO Auto-generated method stub
		
		try {
			Connection cnx = SingletonConnection.getConnection();
			PreparedStatement ps = cnx.prepareStatement("insert into archive(userId, subject, sender, content) values (?, ?, ?,?)");
			ps.setInt(1,a.getUserId());
			ps.setString(2, a.getSubject());
			ps.setString(3, a.getSender());
			ps.setString(4, a.getContent());
			ps.executeUpdate();
			ps.close();
			
			ps = cnx.prepareStatement("select *  from email order by number desc limit 1 offset 0;");
			ResultSet res = ps.executeQuery();
			if(res.next()) {
				a.setNumber(res.getInt(1));				
				a.setDateReception(res.getDate(6).toString());
				//a.setDateReception(res.getString(6));
			}

			return a;
			
		} catch (Exception e1) {
			System.out.println("Erreur : " + e1.getMessage());
		}
		return null;
	}
		
		

	@Override
	public ArrayList<Archive> selectArchiveByKey(String key) {
		// TODO Auto-generated method stub
		try {
			Connection cnx = SingletonConnection.getConnection();
			PreparedStatement ps = cnx.prepareStatement("select * from archive where subject = ?");
			ps.setString(1, key);
			ResultSet rs = ps.executeQuery();
			ArrayList<Archive> l = new ArrayList<Archive>();
			while(rs.next()) {				
				Archive a  = new Archive();
				a.setNumber(rs.getInt(1));
				a.setUserId(rs.getInt(2));
				a.setSubject(rs.getString(3));
				a.setSender(rs.getString(4));
				a.setContent(rs.getString(5));
				a.setDateReception(rs.getDate(6).toString());
				l.add(a);
			} 
			return l;
		} catch (Exception e) {
			System.out.println("Erreur : " + e.getMessage());
		}
		
		return null;
	}

	@Override
	public ArrayList<Archive> select(User u) {
		// TODO Auto-generated method stub
		
		try {
			Connection cnx = SingletonConnection.getConnection();
			PreparedStatement ps = cnx.prepareStatement("select * from archive join user on archive.userId = user.Id where userId = ?");
			ps.setInt(1, u.getId());
			ResultSet rs = ps.executeQuery();
			ArrayList<Archive> l = new ArrayList<Archive>();
			while(rs.next()) {				
				Archive a = new Archive();
				a.setNumber(rs.getInt(1));
				a.setUserId(rs.getInt(2));
				a.setSubject(rs.getString(3));
				a.setSender(rs.getString(4));
				a.setContent(rs.getString(5));		
				a.setDateReception(rs.getDate(6).toString());
				l.add(a);
			} 
			return l;
		} catch (Exception e) {
			System.out.println("Erreur : " + e.getMessage());
		}
		
		return null;
		
	}

	@Override
	public Archive retrieve(Archive a) {
		// TODO Auto-generated method stub
		
try {
			
		Connection cnx = SingletonConnection.getConnection();
		PreparedStatement ps = cnx.prepareStatement("DELETE FROM email WHERE  number = ?");
		ps.setInt(1, a.getNumber());
		ps.executeQuery();
		ps.close();			
		
		return a;
			

		} catch (Exception e) {
			System.out.println("Erreur : " + e.getMessage());
		}
		return null;

	}

	@Override
	public boolean delete(Archive a) {
		// TODO Auto-generated method stub
		
		try {
			Connection cnx = SingletonConnection.getConnection();
			PreparedStatement ps = cnx.prepareStatement("DELETE FROM email WHERE  number = ?");
			ps.setInt(1, a.getNumber());
			ps.executeQuery();
			ps.close();
			
			return true;
		} catch (Exception e) {
			System.out.println("Erreur : " + e.getMessage());
		}
		return false;

	}

}

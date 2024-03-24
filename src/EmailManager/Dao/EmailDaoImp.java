package EmailManager.Dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;

import EmailManager.Beans.Email;
import EmailManager.Beans.User;

public class EmailDaoImp implements  EmailDao {

	public EmailDaoImp()  {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Email insertEmail(Email e) {
		// TODO Auto-generated method stub
		try {
			Connection cnx = SingletonConnection.getConnection();
			PreparedStatement ps = cnx.prepareStatement("insert into email"
					+ "(userId, subject, reciever, content, path) values (?, ?, ?,?,?)");
			ps.setInt(1,e.getUserId());
			ps.setString(2, e.getSubject());
			ps.setString(3, e.getReciever());
			ps.setString(4, e.getContent());
			ps.setString(5, e.getAttachementPath());
			ps.executeUpdate();
			ps.close();
			
			ps = cnx.prepareStatement("select *  from email order by number desc limit 1 offset 0;");
			ResultSet res = ps.executeQuery();
			if(res.next()) {
				e.setNumber(res.getInt(1));				
				e.setdateEnvoie(res.getDate(7).toString());
			}
			return e;
			
		} catch (Exception e1) {
			System.out.println("Erreur : " + e1.getMessage());
		}
		return null;
	}
		
	public Email selectById(int id) {
		
		try {
			
			Connection cnx = SingletonConnection.getConnection();
			PreparedStatement ps = cnx.prepareStatement("select * from email where number = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				Email e = new Email();
				e.setNumber(rs.getInt(1));
				e.setUserId(rs.getInt(2));
				e.setSubject(rs.getString(3));
				e.setReciever(rs.getString(4));
				e.setContent(rs.getString(5));
				e.setAttachementPath(rs.getString(6));
				e.setdateEnvoie(rs.getDate(7).toString());
				return e;
			} else
				return null;

		} catch (Exception e) {
			System.out.println("Erreur : " + e.getMessage());
		}
		return null;
	}
	

	@Override
	public ArrayList<Email> selectEmail(User u) {						
		// TODO Auto-generated method stub
		try {
			Connection cnx = SingletonConnection.getConnection();
			PreparedStatement ps = cnx.prepareStatement("select * from email join user on email.userId = user.Id where userId = ?");
			ps.setInt(1, u.getId());
			ResultSet rs = ps.executeQuery();
			ArrayList<Email> l = new ArrayList<Email>();
			while(rs.next()) {				
				Email e = new Email();
				e.setNumber(rs.getInt(1));
				e.setUserId(rs.getInt(2));
				e.setSubject(rs.getString(3));
				e.setReciever(rs.getString(4));
				e.setContent(rs.getString(5));
				e.setAttachementPath(rs.getString(6));
				e.setdateEnvoie(rs.getDate(7).toString());
				l.add(e);
			} 
			
			return l;
		} catch (Exception e) {
			System.out.println("Erreur : " + e.getMessage());
		}
		
		return null;
	}


	@Override
	public boolean deleteEmail(int num) {
		// TODO Auto-generated method stub
		try {
			Connection cnx = SingletonConnection.getConnection();
			PreparedStatement ps = cnx.prepareStatement("DELETE FROM email WHERE  number = ?");
			ps.setInt(1, num);
			ps.executeQuery();
			ps.close();
			
			return true;
		} catch (Exception e) {
			System.out.println("Erreur : " + e.getMessage());
		}
		return false;
	}

}

package EmailManager.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import EmailManager.Beans.User;

public class UserDaoImp {
	
	

	
	public UserDaoImp() {
		// TODO Auto-generated constructor stub
	}

	
	public User selectUser(User u) {
		
	try {
			
			Connection cnx = SingletonConnection.getConnection();
			PreparedStatement ps = cnx.prepareStatement("select * from user where adresse like ? and password like ?");
			ps.setString(1, u.getAdresse());
			ps.setString(2, u.getPassword());
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				User u1 = new User();
				u1.setId(rs.getInt(1));
				u1.setFirstName(rs.getString(2));
				u1.setLastName(rs.getString(3));
				u1.setDepartement(rs.getString(4));
				u1.setAdresse(rs.getString(5));
				//u1.setdateEnvoie(rs.getDate(6).toString());
				return u1;
			} else
				return null;

		} catch (Exception e) {
			System.out.println("Erreur : " + e.getMessage());
		}
		return null;		
		
	};

}

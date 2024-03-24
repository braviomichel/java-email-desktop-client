package EmailManager.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


import EmailManager.Beans.ListUser;
import EmailManager.Beans.User;

public class ListDaoImpl  implements ListDao{

	public ListDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void insertList(User u, ListUser l1) {
		// TODO Auto-generated method stub
		
		try {
			Connection cnx = SingletonConnection.getConnection();
			PreparedStatement ps = cnx.prepareStatement("insert into listuser"
					+ "(label , user_id, members ) values (?, ?, ?,?)");
			ps.setString(1,l1.getLabel());
			ps.setInt(2, u.getId());
			
			//stocker les id en tant que string 
			
			String m = "" ;
			for(int i = 0 ;  i < l1.getMembers().size(); i++) {
				m += l1.getMembers().get(i).getId() + ",";				
			}			
			ps.setString(3, m);
			ps.executeUpdate();
			ps.close();									
			
		} catch (Exception e1) {
			System.out.println("Erreur : " + e1.getMessage());
		}
	}

	@Override
	public ListUser selectListByKey(String key) {
		// TODO Auto-generated method stub
		try {
			
			Connection cnx = SingletonConnection.getConnection();
			PreparedStatement ps = cnx.prepareStatement("select * from listuser where label = ?");
			ps.setString(1, key);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				ListUser lu = new ListUser();
				lu.setId(rs.getInt(1));
				lu.setLabel(rs.getString(2));
				lu.setUserId(rs.getInt(3));
				String m = rs.getString(4);
					
				
				//recuperer les ids du string m
				
				ArrayList<Integer> ids = new ArrayList<Integer>();			
				for(int i = 0; i<m.length(); i += 2) {
					ids.add((int)(m.charAt(i)));
				}
				
				// list des users existants dans la liste 
				
				ArrayList <User> l = new ArrayList<User>();
				
				for(int i =0; i<ids.size(); i++ ) {
					PreparedStatement ps1 = cnx.prepareStatement("select * from user id = " + ids.get(i));
					ResultSet res1 = ps1.executeQuery();				
					if(res1.next()) {
						User tmp = new User(res1.getString(2), res1.getString(3),res1.getString(4),res1.getString(5));
						l.add(tmp);
						
					}
				}
				
				lu.setMembers(l);								
				return lu;
			} else
				return null;

		} catch (Exception e) {
			System.out.println("Erreur : " + e.getMessage());
		}

		return null;
	}

	@Override
	public ArrayList<ListUser> selectList(User u) {
		// TODO Auto-generated method stub
		try {
			
			Connection cnx = SingletonConnection.getConnection();
			PreparedStatement ps = cnx.prepareStatement("select * from listuser join user  on listuser.Id = user.Id  where listuser.Id = ? ");
			ps.setInt(1, u.getId());
			ResultSet rs = ps.executeQuery();
			
			ArrayList<ListUser> result = new ArrayList<ListUser>();
			
			while(rs.next()) {
				ListUser lu = new ListUser();
				lu.setId(rs.getInt(1));
				lu.setLabel(rs.getString(2));
				lu.setUserId(rs.getInt(3));
				String m = rs.getString(4);
					
				
				//recuperer les ids du string m
				
				ArrayList<Integer> ids = new ArrayList<Integer>();			
				for(int i = 0; i<m.length(); i += 2) {
					ids.add((int)(m.charAt(i)));
				}
				
				// list des users existants dans la liste 
				
				ArrayList <User> l = new ArrayList<User>();
				
				for(int i =0; i<ids.size(); i++ ) {
					PreparedStatement ps1 = cnx.prepareStatement("select * from user id = " + ids.get(i));
					ResultSet res1 = ps1.executeQuery();				
					if(res1.next()) {
						User tmp = new User(res1.getString(2), res1.getString(3),res1.getString(4),res1.getString(5));
						l.add(tmp);
						
					}
					
					lu.setMembers(l);
					result.add(lu);
				}
				
			}
								
				return result;									
			
		} catch (Exception e) {
			System.out.println("Erreur : " + e.getMessage());
		}					
		
		return null;
	}
	
	
	@Override
	public boolean deleteList(User u, String key) {
		// TODO Auto-generated method stub
		try {
			Connection cnx = SingletonConnection.getConnection();
			PreparedStatement ps = cnx.prepareStatement("DELETE FROM listuser WHERE  label = ?");
			ps.setString(1, key);
			ps.executeQuery();
			ps.close();
			
			return true;
		} catch (Exception e) {
			System.out.println("Erreur : " + e.getMessage());
		}
		return false;

	}
	

	@Override
	public ListUser addUser(User admin, User u, ListUser l1) {
		// TODO Auto-generated method stub			
		deleteList(admin, l1.getLabel());
		l1.getMembers().add(u);
		insertList(admin,l1);							
		
		return l1;
	}

	@Override
	public ListUser deleteUser(User admin, User u, ListUser l1) {
		// TODO Auto-generated method stub
		deleteList(admin, l1.getLabel());
		l1.getMembers().remove(u);
		insertList(admin,l1);
		
		return l1;
	}

	

	
	

}

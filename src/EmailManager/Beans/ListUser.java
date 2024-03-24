package EmailManager.Beans;

import java.util.ArrayList;

public class ListUser {
	
	private int Id;
	private String label;
	private int userId;
	private ArrayList<User> members = new ArrayList<User>();

	public ListUser() {
		// TODO Auto-generated constructor stub
	}

	
	public ListUser(int id, String label,int userId, ArrayList<User> l) {
		super();
		Id = id;
		this.label = label;
		this.userId = userId;
		this.members = l;
	}



	public ListUser(int id, String label, ArrayList<User> members) {
		super();
		Id = id;
		this.label = label;
		this.members = members;
	}


	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public ArrayList<User> getMembers() {
		return members;
	}


	public void setMembers(ArrayList<User> l) {
		this.members = l;
	}

	

}

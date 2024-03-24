package EmailManager.Beans;

public class User {
	
	


	private int Id;
	private String firstName;
	private String lastName;
	private String departement;
	private String adresse;
	private String password;
	
	

	public User() {
		// TODO Auto-generated constructor stub
	}



	public User( String firstName, String lastName,  String dept, String adresse) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.departement = dept;
		this.adresse = adresse;
		//this.password = password;
	}



	public User(String adresse, String password) {
		this.adresse = adresse;
		this.password = password;
	}



	public int getId() {
		return Id;
	}



	public void setId(int id) {
		Id = id;
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public String getDepartement() {
		return departement;
	}



	public void setDepartement(String departement) {
		this.departement = departement;
	}



	public String getAdresse() {
		return adresse;
	}



	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}



	public String getPassword() {
		return password;
	}

	
	
	@Override
	public String toString() {
		return "User [Id=" + Id + ", firstName=" + firstName + ", lastName=" + lastName + ", departement=" + departement
				+ ", adresse=" + adresse + ", password=" + password + "]";
	}


	

}

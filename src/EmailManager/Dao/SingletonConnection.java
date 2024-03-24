package EmailManager.Dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingletonConnection {
	
	private static Connection connection;

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection( "jdbc:mysql://localhost:3307/emailmanager", "root", "root");
		} catch (Exception e) {
			System.out.println("Erreur : " + e.getMessage());
		}
	}

	public static Connection getConnection() {
		return connection;
	}

	
}

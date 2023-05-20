package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnexion {
	private static final String URL = "jdbc:mysql://localhost:3306/db_gestionbibliotheque?useSSL=FALSE&serverTimezone=UTC&allowPublicKeyRetrieval=true";
	private static final String LOGIN = "app_AdminTest";
	private static final String PSW = "app_AdminTest";
	
	private static Connection connection;
	
	public static Connection getConnection() {
		
		if(connection == null) {
			
			try {
				connection = DriverManager.getConnection(URL, "app_AdminTest", "app_AdminTest");
			} catch (SQLException e) {
				System.out.println("Erreur : "+ e.getMessage());
				System.out.println("echec");
			}	
		}
		System.out.println("Ok");
		return connection;
	}
}

package utils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.Utilisateur;

public class UtilisateurDao implements Dao<Utilisateur> {

	private final static String QUERY1 = "INSERT INTO utilisateur  (Nom_utilisateur, Prenom_utilisateur, Login, Mdp_authentifcation, Bibliothecaire)\r\n"
			+ "VALUES(?,?,?,?,?)";
	private final static String QUERY2 = "SELECT Id_utilisateur,Nom_utilisateur , Prenom_utilisateur , Login ,Mdp_authentifcation \r\n"
			+ "	FROM utilisateur WHERE Id_utilisateur = ?";
	private final static String QUERY3 = "SELECT * From Utilisateur";
	private final static String QUERY4 = "UPDATE Utilisateur SET Nom_utilisateur = ?, Prenom_utilisateur = ?, Login = ?, Mdp_authentifcation = ?, Bibliothecaire = ? \r\n"
			+ "		WHERE Id_utilisateur = ?";
	private final static String QUERY5 = "DELETE FROM Utilisateur WHERE Id_utilisateur = ?";
	
	@Override
	public void create(Utilisateur utilisateur) {
		try {
			PreparedStatement preparedStatement = DbConnexion.getConnection().prepareStatement(QUERY1);
			preparedStatement.setString(1, utilisateur.getNom());
			preparedStatement.setString(2, utilisateur.getPrenom());
			preparedStatement.setString(3, utilisateur.getLogin());
			preparedStatement.setString(4, utilisateur.getMdp());
			preparedStatement.setBoolean(5, utilisateur.getBibliothecaire());

			int rowsInserted = preparedStatement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("L'abonné a été inséré avec succès.");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Utilisateur> findAll() {
		try {
			PreparedStatement pStatement = DbConnexion.getConnection().prepareStatement(QUERY3);
			ResultSet resultatSet = pStatement.executeQuery();
			var users = new ArrayList<Utilisateur>();
			while (resultatSet.next()) {
				Utilisateur utilisateur = new Utilisateur();
				utilisateur.setIdUser(resultatSet.getInt("Id_utilisateur"));
				utilisateur.setNom(resultatSet.getString("Nom_utilisateur"));
				utilisateur.setPrenom(resultatSet.getString("Prenom_utilisateur"));
				utilisateur.setLogin(resultatSet.getString("Login"));
				utilisateur.setMdp(resultatSet.getString("Mdp_authentifcation"));
				utilisateur.setBibliothecaire(true);
				users.add(utilisateur);
			}
			System.out.println(users.size());

			return users;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Utilisateur findById(int id) {

		Utilisateur utilisateur = new Utilisateur();

		try {
			PreparedStatement preparedStatement = DbConnexion.getConnection().prepareStatement(QUERY2);
			preparedStatement.setInt(1, id);
			ResultSet resultatSet = preparedStatement.executeQuery();
			// Initialise l'affectation des colones
			while (resultatSet.next()) {
				utilisateur.setIdUser(resultatSet.getInt("Id_utilisateur"));
				utilisateur.setNom(resultatSet.getString("Nom_utilisateur"));
				utilisateur.setPrenom(resultatSet.getString("Prenom_utilisateur"));
				utilisateur.setLogin(resultatSet.getString("Mdp_authentifcation"));
				utilisateur.setMdp(resultatSet.getString("Login"));
				utilisateur.setBibliothecaire(true);
			}
			System.out.println("Le nom de l'utilisateur :" + utilisateur.getNom() + " " + utilisateur.getPrenom() + " "
					+ utilisateur.getLogin() + " " + utilisateur.getMdp() + " " + utilisateur.getBibliothecaire());

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return utilisateur;
	}

	@Override
	public Utilisateur update(Utilisateur utilisateur) {
		try {
			PreparedStatement preparedStatement = DbConnexion.getConnection().prepareStatement(QUERY4);
			// Initialise l'affectation des colones
			preparedStatement.setString(1, utilisateur.getNom());
			preparedStatement.setString(2, utilisateur.getPrenom());
			preparedStatement.setString(3, utilisateur.getLogin());
			preparedStatement.setString(4, utilisateur.getMdp());
			preparedStatement.setBoolean(5, utilisateur.getBibliothecaire());
			preparedStatement.setInt(6, utilisateur.getIdUser());
			preparedStatement.executeUpdate();

			System.out.println("Le nom de l'utilisateur :" + utilisateur.getNom() + " " + utilisateur.getPrenom() + " "
					+ utilisateur.getLogin() + " " + utilisateur.getMdp() + " " + utilisateur.getBibliothecaire());

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Utilisateur deleteById(int id) {
		try {
			PreparedStatement preparedStatement = DbConnexion.getConnection().prepareStatement(QUERY5);

			preparedStatement.setInt(1, id);

			int rowsInserted = preparedStatement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("Engeristrement avec succès.");

			} else {
				System.out.println("Pas de user trouvé");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

}

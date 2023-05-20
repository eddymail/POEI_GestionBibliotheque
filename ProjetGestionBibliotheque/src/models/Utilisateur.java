package models;

public class Utilisateur {
	private int  IdUser;
	private String nom;  
	private String prenom;
	private String login;
	private String mdp;
	private Boolean bibliothecaire;
	
	// Constructor

	public Utilisateur(int idUser, String nom, String prenom, String login, String mdp, Boolean bibliothecaire) {
		IdUser = idUser;
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.mdp = mdp;
		this.bibliothecaire = bibliothecaire;
	}

	public Utilisateur(String nom, String prenom, String login, String mdp, Boolean bibliothecaire) {
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.mdp = mdp;
		this.bibliothecaire = bibliothecaire;
	}
	
	public Utilisateur() {
		
	}
	
	// Getter & Setter
	
	public int getIdUser() {
		return IdUser;
	}

	public void setIdUser(int idUser) {
		IdUser = idUser;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public Boolean getBibliothecaire() {
		return bibliothecaire;
	}

	public void setBibliothecaire(Boolean bibliothecaire) {
		this.bibliothecaire = bibliothecaire;
	}

	@Override
	public String toString() {
		return "Utilisateur [IdUser=" + IdUser + ", nom=" + nom + ", prenom=" + prenom + ", login=" + login + ", mdp="
				+ mdp + ", bibliothecaire=" + bibliothecaire + "]";
	}
	
	
}

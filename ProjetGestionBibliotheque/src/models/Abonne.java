package models;

	import java.util.Date;

	public class Abonne extends Utilisateur {
	  
	    	private int idAbonne;
	    	private String adresse;
	    	private Date dateNaissance;
	    	private String mail;
	    	private	Date dateDebutSanction;
	    	private	Date dateFintSanction;
	    	private int idUser;
		
	    	// Constructor
			public Abonne(int idUser, String nom, String prenom, String login, String mdp, Boolean bibliothecaire,
					int idAbonne, String adresse, Date dateNaissance, String mail, Date dateDebutSanction,
					Date dateFintSanction) {
				super(idUser, nom, prenom, login, mdp, bibliothecaire);
				this.idAbonne = idAbonne;
				this.adresse = adresse;
				this.dateNaissance = dateNaissance;
				this.mail = mail;
				this.dateDebutSanction = dateDebutSanction;
				this.dateFintSanction = dateFintSanction;
			}

			// Getter & Setter
			public int getIdAbonne() {
				return idAbonne;
			}

			public void setIdAbonne(int idAbonne) {
				this.idAbonne = idAbonne;
			}

			public String getAdresse() {
				return adresse;
			}

			public void setAdresse(String adresse) {
				this.adresse = adresse;
			}

			public Date getDateNaissance() {
				return dateNaissance;
			}

			public void setDateNaissance(Date dateNaissance) {
				this.dateNaissance = dateNaissance;
			}

			public String getMail() {
				return mail;
			}

			public void setMail(String mail) {
				this.mail = mail;
			}

			public Date getDateDebutSanction() {
				return dateDebutSanction;
			}

			public void setDateDebutSanction(Date dateDebutSanction) {
				this.dateDebutSanction = dateDebutSanction;
			}

			public Date getDateFintSanction() {
				return dateFintSanction;
			}

			public void setDateFintSanction(Date dateFintSanction) {
				this.dateFintSanction = dateFintSanction;
			}

			public int getIdUtilisateur() {
				return idUser;
			}

			public void setIdUtilisateur(int idUtilisateur) {
				this.idUser = idUtilisateur;
			}

			@Override
			public String toString() {
				return "Abonne [idAbonne=" + idAbonne + ", adresse=" + adresse + ", dateNaissance=" + dateNaissance
						+ ", mail=" + mail + ", dateDebutSanction=" + dateDebutSanction + ", dateFintSanction="
						+ dateFintSanction + ", idUser=" + idUser + "]";
			}
	    			
	}

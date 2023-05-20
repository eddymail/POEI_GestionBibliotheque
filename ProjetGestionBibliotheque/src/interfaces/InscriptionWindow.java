package interfaces;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import models.Utilisateur;
import utils.UtilisateurDao;

public class InscriptionWindow {

	public JFrame frame;
	// Déclaration des variables de type TextFiel (saisie de texte)
	private JTextField txtNom;
	private JTextField txtPrenom;
	private JTextField txtLogin;
	private JTextField txtMotDePasse;
	private JTextField txtMail;
	private JTextField txtAdresse;
	private JFormattedTextField frmtdtxtDateDeNaissance;
	// Déclaration des variables de type Label (affiche texte)
	private JLabel lblNewLabel, lbl1, lbl2, lbl3;
	// Déclaration des variables de type Button
	private JRadioButton rdbtnAbonne;
	private JRadioButton rdbtnBiblio;
	private JButton btnInscription;
	// Déclaration des variables utilisées pour créer un Utilisateur
	private String nom, prenom, login, mdp;
	private Boolean isBibliothecaire = true;
	private JLabel lblInscriptionOk;

	/**
	 * Launch the application.
	 */
	// Méthode "main" appelée au clic du bouton "run" dans eclipse
	public static void main(String[] args) {

		// Code nécessaire à l'ouverture de la fenêtre InscriptionWindow
		EventQueue.invokeLater(new Runnable() {
			// Méthode "run" qui créée une instance de la classe Inscription Window
			public void run() {
				try {
					// instanciation de la classe Inscription Window
					InscriptionWindow window = new InscriptionWindow();
					// methode setVisibile avec comme paramètre true pour afficher la fenêtre à
					// l'écran
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InscriptionWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();

		frame.getContentPane().setBackground(new Color(240, 240, 240));
		frame.setBounds(100, 100, 450, 585);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Label

		lbl1 = new JLabel("Bibliothèque municipale");

		lbl1.setBounds(0, 10, 436, 23);
		lbl1.setFont(new Font("Dialog", Font.PLAIN, 15));
		lbl1.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(lbl1);

		lbl2 = new JLabel("ESPACE INSCRIPTION");

		lbl2.setBounds(0, 37, 436, 23);
		lbl2.setFont(new Font("Dialog", Font.BOLD, 17));
		lbl2.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lbl2);

		lbl3 = new JLabel("S'inscrire en tant que :");

		lbl3.setFont(new Font("Dialog", Font.PLAIN, 15));
		lbl3.setBounds(10, 63, 416, 23);
		lbl3.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lbl3);

		lblNewLabel = new JLabel("Chaque champs est obligatoires");

		lblNewLabel.setVisible(false);
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblNewLabel.setBounds(75, 399, 302, 23);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblNewLabel);

		lblInscriptionOk = new JLabel("");

		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblInscriptionOk.setBounds(10, 485, 416, 23);
		lblInscriptionOk.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblInscriptionOk);

		//Button

		ButtonGroup groupe = new ButtonGroup();

		rdbtnAbonne = new JRadioButton("Abonné");

		rdbtnAbonne.setFont(new Font("Dialog", Font.PLAIN, 15));
		rdbtnAbonne.setBounds(74, 92, 146, 21);
		rdbtnAbonne.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(rdbtnAbonne);
		groupe.add(rdbtnAbonne);

		rdbtnBiblio = new JRadioButton("Bibliothécaire");

		rdbtnBiblio.setFont(new Font("Dialog", Font.PLAIN, 15));
		rdbtnBiblio.setBounds(222, 92, 151, 21);
		rdbtnBiblio.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(rdbtnBiblio);
		groupe.add(rdbtnBiblio);

		btnInscription = new JButton("Validez inscription");

		btnInscription.setVisible(false);
		btnInscription.setFont(new Font("Dialog", Font.PLAIN, 15));
		btnInscription.setBackground(new Color(29, 191, 226));
		btnInscription.setForeground(new Color(0, 0, 0));
		btnInscription.setBounds(143, 432, 164, 21);
		frame.getContentPane().add(btnInscription);

		//TextField

		txtNom = new JTextField();

		txtNom.setVisible(false);
		txtNom.setFont(new Font("Dialog", Font.PLAIN, 14));
		txtNom.setText("Nom");
		txtNom.setBounds(75, 133, 302, 25);
		frame.getContentPane().add(txtNom);
		txtNom.setColumns(10);

		txtPrenom = new JTextField();

		txtPrenom.setVisible(false);
		txtPrenom.setText("Prénom");
		txtPrenom.setFont(new Font("Dialog", Font.PLAIN, 15));
		txtPrenom.setBounds(75, 168, 302, 25);
		frame.getContentPane().add(txtPrenom);
		txtPrenom.setColumns(10);

		txtLogin = new JTextField();

		txtLogin.setVisible(false);
		txtLogin.setText("Login");
		txtLogin.setFont(new Font("Dialog", Font.PLAIN, 15));
		txtLogin.setBounds(75, 203, 302, 25);
		frame.getContentPane().add(txtLogin);
		txtLogin.setColumns(10);

		txtMotDePasse = new JTextField();

		txtMotDePasse.setVisible(false);
		txtMotDePasse.setFont(new Font("Dialog", Font.PLAIN, 15));
		txtMotDePasse.setText("Mot de passe");
		txtMotDePasse.setBounds(75, 238, 302, 25);
		frame.getContentPane().add(txtMotDePasse);
		txtMotDePasse.setColumns(10);

		txtMail = new JTextField();

		txtMail.setVisible(false);
		txtMail.setText("Mail");
		txtMail.setFont(new Font("Dialog", Font.PLAIN, 15));
		txtMail.setBounds(75, 308, 302, 25);
		frame.getContentPane().add(txtMail);
		txtMail.setColumns(10);

		txtAdresse = new JTextField();

		txtAdresse.setVisible(false);
		txtAdresse.setText("Adresse");
		txtAdresse.setFont(new Font("Dialog", Font.PLAIN, 15));
		txtAdresse.setBounds(75, 343, 302, 50);
		frame.getContentPane().add(txtAdresse);
		txtAdresse.setColumns(10);

		DateFormat format = new SimpleDateFormat("dd-MM-yyyy");

		frmtdtxtDateDeNaissance = new JFormattedTextField();
		frmtdtxtDateDeNaissance.setVisible(false);
		frmtdtxtDateDeNaissance.setFont(new Font("Dialog", Font.PLAIN, 15));
		frmtdtxtDateDeNaissance.setText("Date de naissance (jj/mm/aaaa)");
		frmtdtxtDateDeNaissance.setBounds(75, 273, 302, 25);
		frame.getContentPane().add(frmtdtxtDateDeNaissance);

		//Listener
		// Au clic du bouton Abonne Affiche les éléments à remplir
		rdbtnAbonne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnAbonne.isSelected()) {
					txtNom.setVisible(true);
					txtPrenom.setVisible(true);
					txtLogin.setVisible(true);
					txtMotDePasse.setVisible(true);
					txtMail.setVisible(true);
					frmtdtxtDateDeNaissance.setVisible(true);
					txtAdresse.setVisible(true);
					lblNewLabel.setVisible(true);
					btnInscription.setVisible(true);
				}
			}
		});
		//Au clic du bouton Bibliothécaire Affiche les éléments à remplir
		rdbtnBiblio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnBiblio.isSelected()) {
					txtNom.setVisible(true);
					txtPrenom.setVisible(true);
					txtLogin.setVisible(true);
					txtMotDePasse.setVisible(true);
					lblNewLabel.setVisible(true);
					btnInscription.setVisible(true);
					txtMail.setVisible(false);
					frmtdtxtDateDeNaissance.setVisible(false);
					txtAdresse.setVisible(false);
				}
			}
		});
		
		// Gestoin du clic sur btn Validez inscription
				btnInscription.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						// créer une instance de la classe Utilisateur
						Utilisateur user = new Utilisateur();
						// on lui passe en paramètre les valeurs récupérées
						// valeur nécessaire si user (bibliothécaire)
						if (rdbtnBiblio.isSelected()) {
							if (txtNom.getText() != null) {
								user.setNom(txtNom.getText());
							}
							if (txtPrenom.getText() != null) {
								user.setPrenom(txtPrenom.getText());
							}
							if (txtLogin.getText() != null) {
								user.setLogin(txtLogin.getText());
							}
							if (txtMotDePasse.getText() != null) {
								user.setMdp(txtMotDePasse.getText());
							}

							user.setBibliothecaire(isBibliothecaire);
							// envoyer dans la bd
							UtilisateurDao userDao = new UtilisateurDao();
							if (user != null) {
								userDao.create(user);
							}
							// message confirmation
							lblInscriptionOk.setText("Bonjour " + user.getPrenom() + " votre inscription est confirmée");
							frame.setVisible(false);
							ConnectionWindow window = new ConnectionWindow();
							window.frmConnection.setVisible(true);

						} else {
							// Condition si isBibliotecaire = false
							// TODO créer un abonne de type Abonne et lui attribué toute les valeurs
							// nécessaires
						}
					}
				});
	}
}

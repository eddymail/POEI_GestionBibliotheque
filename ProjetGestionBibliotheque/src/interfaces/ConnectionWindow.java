package interfaces;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JSpinner.ListEditor;
import javax.swing.JTextField;

import models.Utilisateur;
import utils.UtilisateurDao;

public class ConnectionWindow {

	public JFrame frmConnection;
	private JTextField txtLogin;
	private JPasswordField passwordField;
	private JTextField txtPwd;
	private String login, pwd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConnectionWindow window = new ConnectionWindow();
					window.frmConnection.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ConnectionWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frmConnection = new JFrame();

		frmConnection.getContentPane().setForeground(Color.LIGHT_GRAY);
		frmConnection.getContentPane().setBackground(Color.WHITE);
		frmConnection.setFont(new Font("Dialog", Font.PLAIN, 15));
		frmConnection.setTitle("Connection");
		frmConnection.setBounds(100, 100, 450, 300);
		frmConnection.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmConnection.getContentPane().setLayout(null);

		// Récupère la liste avec findAll
		// Crée une liste avec la liste récupérer
		// boucle qui parcoure tout le tablo
		// JTable
		// for(User users : user){
		// tableModel.addRow(new Object[] { user.getNom, user.getPrenom});

		JLabel lblNewLabel = new JLabel("Saisir Login");

		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNewLabel.setBounds(157, 50, 105, 28);
		frmConnection.getContentPane().add(lblNewLabel);

		txtLogin = new JTextField();

		txtLogin.setBounds(132, 85, 141, 34);
		frmConnection.getContentPane().add(txtLogin);
		txtLogin.setColumns(10);

		txtPwd = new JTextField();

		txtPwd.setBounds(132, 177, 141, 28);
		frmConnection.getContentPane().add(txtPwd);
		txtPwd.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Saisir Mot De Passe");

		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNewLabel_1.setBounds(132, 139, 156, 14);
		frmConnection.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Bibliothèque Municipale");

		lblNewLabel_2.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel_2.setBounds(90, 11, 233, 28);
		frmConnection.getContentPane().add(lblNewLabel_2);

		// passwordField = new JPasswordField();

		// passwordField.setBounds(132, 164, 141, 34);
		// frmConnection.getContentPane().add(passwordField);

		JButton btnConnecter = new JButton("Se Connecter");

		btnConnecter.setBackground(new Color(29, 191, 226));
		btnConnecter.setFont(new Font("Dialog", Font.BOLD, 15));
		btnConnecter.setBounds(132, 227, 141, 23);
		frmConnection.getContentPane().add(btnConnecter);

		// Listener

		txtLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login = txtLogin.getText();
				System.out.println();
			}
		});

		txtPwd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pwd = txtPwd.getText();
			}
		});

		btnConnecter.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				UtilisateurDao utilisateurDao = new UtilisateurDao();
				// Appel de la méthode findAll() de la classe Utilisateur Dao. La méthode
				// renvoie une liste de type Utilisateurs
				utilisateurDao.findAll();
				// Stocke le retour dans une nouvelle liste pour la parcourir
				List<Utilisateur> usersFromDatabse = new ArrayList<>();
				usersFromDatabse = utilisateurDao.findAll();
				// Boucle for each ==> Pour chaque user de type Ulisateur de la liste
				// usersFromDatabase faire l'action ent {}
				for (Utilisateur user : usersFromDatabse) {
					if (user.getLogin().equals(txtLogin.getText()) && user.getMdp().equals(txtPwd.getText())) {
						// TODO Ouvrir GestionWindow
						System.out.println("Le bibliothécaire : " + user.getNom() + " est connecté à l'application");
					}

				}
				frmConnection.setVisible(false);
				GestionUserWindow gestionUserWindow = new GestionUserWindow();
				gestionUserWindow.frame.setVisible(true);
			}
		});

	}
}
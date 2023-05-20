package interfaces;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.desktop.QuitEvent;
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import models.Utilisateur;
import utils.UtilisateurDao;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GestionUserWindow {

	public JFrame frame;
	private JTextField txtBibliothqueMunicipale;
	private JTextField txtGestionDesUtilisateurs;
	private JScrollPane scrollPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionUserWindow window = new GestionUserWindow();
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

	public GestionUserWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 645, 382);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		List<Utilisateur> userFromDatabseList = new ArrayList<>();

		UtilisateurDao userDao = new UtilisateurDao();
		userFromDatabseList = userDao.findAll();

		JButton btnSupprimer = new JButton("Supprimer");

		btnSupprimer.setForeground(Color.RED);
		btnSupprimer.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnSupprimer.setBounds(241, 292, 157, 43);
		frame.getContentPane().add(btnSupprimer);

		txtBibliothqueMunicipale = new JTextField();
		txtBibliothqueMunicipale.setHorizontalAlignment(SwingConstants.CENTER);
		txtBibliothqueMunicipale.setFont(new Font("Times New Roman", Font.BOLD, 24));
		txtBibliothqueMunicipale.setText("Bibliothèque Municipale");
		txtBibliothqueMunicipale.setBounds(114, 10, 374, 31);
		frame.getContentPane().add(txtBibliothqueMunicipale);
		txtBibliothqueMunicipale.setColumns(10);

		txtGestionDesUtilisateurs = new JTextField();
		txtGestionDesUtilisateurs.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		txtGestionDesUtilisateurs.setHorizontalAlignment(SwingConstants.CENTER);
		txtGestionDesUtilisateurs.setForeground(Color.BLUE);
		txtGestionDesUtilisateurs.setText("Gestion des utilisateurs");
		txtGestionDesUtilisateurs.setBounds(101, 51, 402, 47);
		frame.getContentPane().add(txtGestionDesUtilisateurs);
		txtGestionDesUtilisateurs.setColumns(10);

		// Etape 1
		final DefaultTableModel tableModel = new DefaultTableModel();
		// Etape 2
		table = new JTable(tableModel);

		tableModel.addColumn("Id");
		tableModel.addColumn("Nom");
		tableModel.addColumn("Prenom");
		tableModel.addColumn("Login");
		tableModel.addColumn("Mot de passe");
		
		// Remplissage des rangs
		for (Utilisateur user : userFromDatabseList) {
			tableModel.addRow(
					new Object[] { user.getIdUser(), user.getNom(), user.getPrenom(), user.getLogin(), user.getMdp() });
		}

		// Etape 3
		scrollPane = new JScrollPane(table);

		scrollPane.setViewportView(table);
		scrollPane.setBounds(29, 108, 562, 174);
		frame.getContentPane().add(scrollPane);
		frame.setVisible(true);

		// Listner
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int[] selectedRows = table.getSelectedRows();
				for (int i = selectedRows.length - 1; i >= 0; i--) {

					int rowIndex = table.convertRowIndexToModel(selectedRows[i]);

					userDao.deleteById(((int) tableModel.getValueAt(rowIndex, 0)));
					// System.out.println("valeur index" + (int) tableModel.getValueAt(rowIndex,
					// 0));
					tableModel.removeRow(selectedRows[i]);

				}
			} 
		});
	}
}

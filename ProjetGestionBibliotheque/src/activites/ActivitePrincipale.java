package activites;

import java.awt.EventQueue;
import java.awt.Window;
import java.util.Scanner;

import javax.swing.JFrame;

import interfaces.ConnectionWindow;
import interfaces.GestionUserWindow;
import interfaces.InscriptionWindow;
import models.Utilisateur;
import utils.DbConnexion;
import utils.UtilisateurDao;

public class ActivitePrincipale {

	public static void main(String[] args) {
		// Code nécessaire à l'ouverture de la fenêtre InscriptionWindow
				EventQueue.invokeLater(new Runnable() {
					// Méthode "run" qui créée une instance de  la classe Inscription Window
					public void run() {
						try {
							InscriptionWindow window = new InscriptionWindow();
							window.frame.setVisible(true);
						//TODO fermeture InscriptionWindow et ouverture ConnectionWindow	
						} catch (Exception e) {
							e.printStackTrace();
						}	
					}
				});	
	}

}

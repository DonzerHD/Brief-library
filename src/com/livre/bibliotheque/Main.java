package com.livre.bibliotheque;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
				
		Scanner sc = new Scanner(System.in);	
		
		Bibliotheque bibliotheque1 = new Bibliotheque(); // Création de la bibliothèque .

		// Début du programme.
		//Menu et choix.
		try {
			menu();
			int selection = sc.nextInt();
			switch (selection) {
			case 1:
				System.out.println("Option 1 sélectionnée. : ");
				bibliotheque1.ajouterUnLivre();
				main(null);
				break;
			case 2:
				System.out.println("Option 2 sélectionnée.");
				break;
			case 3:
				System.out.println("Option 3 sélectionnée.");
				bibliotheque1.afficherListeLivre();
				main(null);
				break;
			case 4:
				System.out.println("Option 4 sélectionnée.");
				break;
			default:
				throw new IllegalArgumentException("L'option sélectionnée n'est pas valable : " + selection);
			}
		} catch (IllegalArgumentException e) {
			System.out.println("Ce nombre correspond à aucun du menu !");
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			main(null);
		} catch (InputMismatchException e) {
			System.out.println("saisie invalide");
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			main(null);
		}finally {
			sc.close();
		}
		
		
		
		
		

	}
	

	/**
	 * Fonction qui affiche le menu.
	 */
	public static void menu() {

		/***************************************************/
		System.out.println("-------------------------");
		System.out.println("    |Bibliothèque|");
		System.out.println("-------------------------");
		System.out.println("1 - Saisir un livre");
		System.out.println("2 - Modifier un livre");
		System.out.println("3 - Afficher la liste des livres ");
		System.out.println("4 - Rechercher un livre");
		System.out.println("-------------------------");
		System.out.print("Veuillez sélectionner une option : ");
	}
}

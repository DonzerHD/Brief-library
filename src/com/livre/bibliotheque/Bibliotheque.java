package com.livre.bibliotheque;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * class qui permet de gérer la bibliothèque.
 * 
 * @author Thomas.L
 *
 */
public class Bibliotheque extends Main {
	List<Livre> livreList = new ArrayList<>();

	/**
	 * Méthode qui permet d'ajouter des livres dans la bibliothèque
	 */
	public Bibliotheque() {
		livreList.add(new Livre("L'art de la guerre", "Thomas", "Histoire", 450, 8));
		livreList.add(new Livre("Superman", "Jean", "BD", 50, 3));
	}

	/**
	 * Méthode qui permet d'ajouter des livres dans la bibliothèque saisie par
	 * l'utilisateur.
	 */
	public void ajouterUnLivre() {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Pour retourner au menu tapez 'r' ");
			System.out.print("Titre du livre : ");
			String titre = sc.nextLine();
			// Retour menu
			switch (titre) {
			case "r":
				main(null);
				// Ajouter livre
			default:
				System.out.print("Auteur du livre :");
				String auteur = sc.nextLine();
				System.out.print("Genre du livre :");
				String genre = sc.nextLine();
				System.out.print("Nombre de pages :");
				int nombrePage = sc.nextInt();
				System.out.print("Nombre d'exemplaires :");
				int nombreEx = sc.nextInt();
				StringBuilder livreBuilder = new StringBuilder();
				System.out.print("📙 Le livre a bien était ajouté . 📙 \n");

				try {
					Thread.sleep(1600);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				livreBuilder.append("------------------------ \n");
				livreBuilder.append("Voici ses infos :  \n");
				livreBuilder.append("Titre : ");
				livreBuilder.append(titre + "\n");
				livreBuilder.append("Auteur : ");
				livreBuilder.append(auteur + "\n");
				livreBuilder.append("Genre : ");
				livreBuilder.append(genre + "\n");
				livreBuilder.append("Nombre de pages : ");
				livreBuilder.append(nombrePage + "\n");
				livreBuilder.append("Nombre d'exemplaires : ");
				livreBuilder.append(nombreEx + "\n");
				livreBuilder.append("------------------------ \n");
				System.out.println(livreBuilder);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				System.out.println(" ⚠️⚠️ Retour dans le menu dans quelques secondes. ⚠️⚠️");
				livreList.add(new Livre(titre, auteur, genre, nombrePage, nombreEx));
				try {
					Thread.sleep(5500);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				break;
			}
		} catch (Exception e) {
			System.out.println("saisie invalide");
			try {
				Thread.sleep(4500);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			ajouterUnLivre();
		}
	}

	public void afficherListeLivre() {
		System.out.println("Voici la liste de tous les livres de la bibliothèque : ");
		for (Livre livreS : livreList) {
			StringBuilder livreBuilder = new StringBuilder();
			livreBuilder.append("------------------------ \n");
			livreBuilder.append("Voici ses infos :  \n");
			livreBuilder.append("Titre : ");
			livreBuilder.append(livreS.getTitre() + "\n");
			livreBuilder.append("Auteur : ");
			livreBuilder.append(livreS.getTitre() + "\n");
			livreBuilder.append("Genre : ");
			livreBuilder.append(livreS.getGenre() + "\n");
			livreBuilder.append("Nombre de pages : ");
			livreBuilder.append(livreS.getNombrePage() + "\n");
			livreBuilder.append("Nombre d'exemplaires : ");
			livreBuilder.append(livreS.getNombreExemplaire() + "\n");
			livreBuilder.append("------------------------ \n");
			System.out.println(livreBuilder);
		}
		try {
			Thread.sleep(7500);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}
}

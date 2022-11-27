package com.livre.bibliotheque;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
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
	 * Méthode qui permet d'ajouter des livres dans la bibliothèque saisie par
	 * l'utilisateur.
	 */
	public void ajouterUnLivre() {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Pour retourner au menu tapez 'r' ");
			System.out.print("Titre du livre : ");
			String titre = sc.nextLine();
			switch (titre) {
			case "r":
				main(null);// Retour menu
			default:// Ajouter livre
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
				try {
					Thread.sleep(5500);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				livreList.add(new Livre(titre, auteur, genre, nombrePage, nombreEx));
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
			livreBuilder.append(livreS.getAuteur() + "\n");
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

	public void ecrireFichier() {
		String DELIMITER = ",";
		File file = new File("data\\Livre.csv");

		try {
			FileWriter fstream = new FileWriter(file, true);
			BufferedWriter out = new BufferedWriter(fstream);
			for (Livre livreS : livreList) {
				out.append(livreS.getTitre());
				out.append(DELIMITER);
				out.append(livreS.getAuteur());
				out.append(DELIMITER);
				out.write(livreS.getGenre());
				out.append(DELIMITER);
				out.append(livreS.getNombrePage() + ",");
				out.append(livreS.getNombreExemplaire() + "," + "\n");
			}
			out.close();
			System.out.println("Successfully wrote to the file.");
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	public void recupDataFichier() {
		File file = new File("data\\Livre.csv");
		BufferedReader bufferedReader = null;

		try {
			FileReader fileReader = new FileReader(file);
			bufferedReader = new BufferedReader(fileReader);

			String line;
			while ((line = bufferedReader.readLine()) != null) {
				System.out.println(line);
			}

		} catch (FileNotFoundException e) {
			System.err.println("Le fichier n'a pas été trouve.");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Impossible de lire le contenu du fichier");
		}
		try {
			bufferedReader.close();
		} catch (IOException e) {
			System.out.println("Impossible de fermer le ficiher");
			e.printStackTrace();
		} catch (NullPointerException e) {
			System.err.println("Impossible d'ouvrir le fichier");
		}
	}
}

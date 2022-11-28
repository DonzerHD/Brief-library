package com.livre.bibliotheque;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
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
	private List<Livre> livreList = new ArrayList<>();
	private File file = new File("data\\Livre.csv");

	/**
	 * Méthode qui permet d'ajouter des livres dans la bibliothèque saisie par
	 * l'utilisateur.
	 */
	public void ajouterUnLivre() {
		try {
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			System.out.print("Titre du livre : ");
			String titre = sc.nextLine();
			switch (titre) {
			default:// Ajouter livre
				System.out.print("Auteur du livre : ");
				String auteur = sc.nextLine();
				System.out.print("Genre du livre : ");
				String genre = sc.nextLine();
				System.out.print("Nombre de pages : ");
				int nombrePage = sc.nextInt();
				System.out.print("Nombre d'exemplaires : ");
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

	/**
	 * Méthode qui affiche les livres et qui les récupère dans le fichier csv.
	 */
	public void afficherListeLivreEtRecup() {
		String line = "";
		String splitBy = ",";
		try (BufferedReader bf = new BufferedReader(new FileReader(file))) {
			bf.readLine();
			while ((line = bf.readLine()) != null) {
				String[] livreSplit = line.split(splitBy);
				StringBuilder livreInfos = new StringBuilder();
				livreInfos.append("|Titre : ");
				livreInfos.append(livreSplit[0] + "|\n");
				livreInfos.append("__________________________\n");
				livreInfos.append("Auteur : ");
				livreInfos.append(livreSplit[1] + "\n");
				livreInfos.append("Genre : ");
				livreInfos.append(livreSplit[2] + "\n");
				livreInfos.append("Nombre de pages : ");
				livreInfos.append(livreSplit[3] + "\n");
				livreInfos.append("Nombre d'exemplaires : ");
				livreInfos.append(livreSplit[4] + "\n");
				livreInfos.append("——————————————————————————");
				System.out.println(livreInfos);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			Thread.sleep(4500);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}

	/**
	 * Méthode qui enregistre les livres dans un fichier csv.
	 */
	public void ecrireFichier() {
		String DELIMITER = ",";

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
				out.append(livreS.getNombreExemplaire() + "\n");
			}
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void modifier() {

	}

	/**
	 * Méthode qui va permettre à l'utilisateur de rechercher un livre .
	 */
	public void recherche() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String line = "";
		String splitBy = ",";
		System.out.print("Recherche Livre : ");
		String recherche = sc.nextLine();
		try (BufferedReader bf = new BufferedReader(new FileReader(file))) {
			bf.readLine();
			while ((line = bf.readLine()) != null) {
				String[] livreSplit = line.split(splitBy);
				if (recherche.equalsIgnoreCase(livreSplit[0])) {
					System.out.println("Voici les infos du livre recherché : ");
					System.out.println("__________________________");
					StringBuilder livreInfos = new StringBuilder();
					livreInfos.append("|Titre : ");
					livreInfos.append(livreSplit[0] + "|\n");
					livreInfos.append("__________________________\n");
					livreInfos.append("Auteur : ");
					livreInfos.append(livreSplit[1] + "\n");
					livreInfos.append("Genre : ");
					livreInfos.append(livreSplit[2] + "\n");
					livreInfos.append("Nombre de pages : ");
					livreInfos.append(livreSplit[3] + "\n");
					livreInfos.append("Nombre d'exemplaires : ");
					livreInfos.append(livreSplit[4] + "\n");
					livreInfos.append("——————————————————————————");
					System.out.println(livreInfos);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			Thread.sleep(4500);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}

	}

	public List<Livre> getLivreList() {
		return livreList;
	}

	public void setLivreList(List<Livre> livreList) {
		this.livreList = livreList;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

}

package com.livre.bibliotheque;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
				out.append(livreS.getGenre());
				out.append(DELIMITER);
				out.append(livreS.getNombrePage() + ",");
				out.append(livreS.getNombreExemplaire() + "\n");
			}
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Méthode qui va permettre à l'utilisateur de modifier un livre .
	 * 
	 * @throws IOException
	 */
	@SuppressWarnings("resource")
	public void modifier() throws IOException {
		try {
			Scanner x;
			Scanner sc = new Scanner(System.in);
			System.out.print("Quel livre voulez-vous modifier : ");
			String recherche = sc.nextLine();
			RechercheModif(recherche);
			System.out.println("-------------------------");
			System.out.println("Vous avez choisi de modifier le livre : " + recherche);
			System.out.println("-------------------------");
			System.out.println("    |Modifier|");
			System.out.println("-------------------------");
			System.out.println("1 - Titre");
			System.out.println("2 - Auteur");
			System.out.println("3 - Genre");
			System.out.println("4 - Nombre de pages");
			System.out.println("5 - Nombre d'exemplaires");
			System.out.println("-------------------------");
			System.out.print("Veuillez sélectionner une option : ");
			int choixMenu = sc.nextInt();
			sc.nextLine();
			String filepath = "data\\Livre.csv";
			String tempFile = "data\\Temp.csv";
			File oldFile = new File(filepath);
			File newFile = new File(tempFile);
			String titre = "";
			String auteur = "";
			String genre = "";
			String np = "";
			String ne = "";
			FileWriter fw;
			fw = new FileWriter(tempFile, true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			x = new Scanner(new File(filepath));
			x.useDelimiter("[,\n]");
			File dump = new File(filepath);
			switch (choixMenu) {
			case 1: // Modifier titre
				System.out.print("Nouveau titre :");
				String titreM = sc.nextLine();
				try {
					Thread.sleep(1500);
				} catch (InterruptedException e1) {
				}
				while (x.hasNext()) {
					titre = x.next();
					auteur = x.next();
					genre = x.next();
					np = x.next();
					ne = x.next();
					if (titre.equalsIgnoreCase(recherche)) {
						pw.print(titreM + "," + auteur + "," + genre + "," + np + "," + ne + "\n");
					} else {
						pw.print(titre + "," + auteur + "," + genre + "," + np + "," + ne + "\n");
					}
				}
				x.close();
				pw.flush();
				pw.close();
				System.out.println("Attendez quelques secondes le Livre va être modifier");
				oldFile.delete();
				newFile.renameTo(dump);
				try {
					Thread.sleep(3500);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				main(null);
				break;
			case 2:
				System.out.print("Nouveau Auteur :");
				String auteurM = sc.nextLine();
				try {
					Thread.sleep(1500);
				} catch (InterruptedException e1) {
				}
				while (x.hasNext()) {
					titre = x.next();
					auteur = x.next();
					genre = x.next();
					np = x.next();
					ne = x.next();
					if (titre.equalsIgnoreCase(recherche)) {
						pw.print(titre + "," + auteurM + "," + genre + "," + np + "," + ne + "\n");
					} else {
						pw.print(titre + "," + auteur + "," + genre + "," + np + "," + ne + "\n");
					}
				}
				x.close();
				pw.flush();
				pw.close();
				System.out.println("Attendez quelques secondes le Livre va être modifier");
				oldFile.delete();
				newFile.renameTo(dump);
				try {
					Thread.sleep(3500);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				main(null);
				break;
			case 3:
				System.out.print("Nouveau Genre :");
				String genreM = sc.nextLine();
				try {
					Thread.sleep(1500);
				} catch (InterruptedException e1) {
				}
				while (x.hasNext()) {
					titre = x.next();
					auteur = x.next();
					genre = x.next();
					np = x.next();
					ne = x.next();
					if (titre.equalsIgnoreCase(recherche)) {
						pw.print(titre + "," + auteur + "," + genreM + "," + np + "," + ne + "\n");
					} else {
						pw.print(titre + "," + auteur + "," + genre + "," + np + "," + ne + "\n");
					}
				}
				x.close();
				pw.flush();
				pw.close();
				System.out.println("Attendez quelques secondes le Livre va être modifier");
				oldFile.delete();
				newFile.renameTo(dump);
				try {
					Thread.sleep(3500);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				main(null);
				break;
			case 4:
				System.out.print("Nouveau nombre de pages:");
				int nombrePN = sc.nextInt();
				try {
					Thread.sleep(1500);
				} catch (InterruptedException e1) {
				}
				sc.nextLine();
				while (x.hasNext()) {
					titre = x.next();
					auteur = x.next();
					genre = x.next();
					np = x.next();
					ne = x.next();
					if (titre.equalsIgnoreCase(recherche)) {
						pw.print(titre + "," + auteur + "," + genre + "," + nombrePN + "," + ne + "\n");
					} else {
						pw.print(titre + "," + auteur + "," + genre + "," + np + "," + ne + "\n");
					}
				}
				x.close();
				pw.flush();
				pw.close();
				System.out.println("Attendez quelques secondes le Livre va être modifier");
				oldFile.delete();
				newFile.renameTo(dump);
				try {
					Thread.sleep(3500);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				main(null);
				break;
			case 5:
				System.out.print("Nouveau nombre d'exemplaires : ");
				int nombreExN = sc.nextInt();
				try {
					Thread.sleep(1500);
				} catch (InterruptedException e1) {
				}
				sc.nextLine();
				while (x.hasNext()) {
					titre = x.next();
					auteur = x.next();
					genre = x.next();
					np = x.next();
					ne = x.next();
					if (titre.equalsIgnoreCase(recherche)) {
						pw.print(titre + "," + auteur + "," + genre + "," + np + "," + nombreExN + "\n");
					} else {
						pw.print(titre + "," + auteur + "," + genre + "," + np + "," + ne + "\n");
					}
				}
				try {
					Thread.sleep(1500);
				} catch (InterruptedException e1) {
				}
				x.close();
				pw.flush();
				pw.close();
				System.out.println("Attendez quelques secondes le Livre va être modifier");
				oldFile.delete();
				newFile.renameTo(dump);
				main(null);
				break;
			default:
				throw new IllegalArgumentException("L'option sélectionnée n'est pas valable : " + choixMenu);
			}
		} catch (IllegalArgumentException e) {
			System.out.println("Ce nombre correspond à aucun du menu !");
			main(null);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void RechercheModif(String recherche) {
		String line = "";
		String splitBy = ",";
		try (BufferedReader bf = new BufferedReader(new FileReader(file))) {
			bf.readLine();
			boolean valid = false;
			while ((line = bf.readLine()) != null) {
				String[] livreSplit = line.split(splitBy);
				if (recherche.equalsIgnoreCase(livreSplit[0])) {
					valid = true;
				}
			}
			if (valid == false) {
				System.out.println("Ce livre n'est pas dans notre bibliothèque ou il n'existe pas");
				main(null);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Méthode qui va permettre à l'utilisateur de rechercher un livre .
	 */
	public void recherche() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String line = "";
		String splitBy = ",";
		// Fichier Split recherche
		String Split = "";
		String 	first = "";
		System.out.print("Recherche Livre : ");
		String recherche = sc.nextLine();
		try (BufferedReader bf = new BufferedReader(new FileReader(file))) {
			bf.readLine();
			boolean valid = false;
			while ((line = bf.readLine()) != null) {
				String[] livreSplit = line.split(splitBy);
				String[] livreSplit1 = line.split(Split);
				for (int i = 0 ;  i < livreSplit.length; i ++) {
				String finalS =  livreSplit1[0] + livreSplit1[1] +livreSplit1[2];
				if (recherche.equalsIgnoreCase(finalS)) {
					valid = true;
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
			}}
			if (valid == false) {
				System.out.println("Ce livre n'est pas dans notre bibliothèque ou il n'existe pas");
				main(null);
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

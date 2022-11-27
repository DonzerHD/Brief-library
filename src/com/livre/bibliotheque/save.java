package com.livre.bibliotheque;

import java.util.ArrayList;
import java.util.List;

public class save {
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
			BufferedWriter w = null;

			try {
				FileWriter myWriter = new FileWriter(file);
				myWriter.write("Titre   ");
				myWriter.write(DELIMITER);
				myWriter.write("Auteur   ");
				myWriter.write(DELIMITER);
				myWriter.write("Genre   ");
				myWriter.write(DELIMITER);
				myWriter.write("Nombre de pages   ");
				myWriter.write(DELIMITER);
				myWriter.write("Nombre d'exemplaires   \n");
				w = new BufferedWriter(new FileWriter(file, true));	
				for (Livre livreS : livreList) {;
					w.append(livreS.getTitre());
					w.append(DELIMITER);
					w.append(livreS.getAuteur());
					w.append(DELIMITER);
					w.write(livreS.getGenre());
					w.append(DELIMITER);
					w.append(livreS.getNombrePage() + ",");
					w.append(livreS.getNombreExemplaire() + "\n");
				}
				myWriter.close();
				w.close();
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
				final String SEPARATEUR = ",";
			
				String line;
				while((line = bufferedReader.readLine()) != null) {
					String mots[]= line.split(SEPARATEUR);
			        for (int i = 0 ; i < mots.length ; i++) {
			        	System.out.println(mots[i]);
			        }
					
				}
				
			} catch (FileNotFoundException e) {
				System.err.println("Le fichier n'a pas été trouve.");
				e.printStackTrace();
			}  catch (IOException e) {
				System.err.println("Impossible de lire le contenu du fichier");
			}
			try {
				bufferedReader.close();
			} catch (IOException e) {
				System.out.println("Impossible de fermer le ficiher");
				e.printStackTrace();
			}catch (NullPointerException e) {
				System.err.println("Impossible d'ouvrir le fichier");
			}
		}
		}


}

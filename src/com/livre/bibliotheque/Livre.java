package com.livre.bibliotheque;

/**
 * class qui permet de créer un livre.
 * @author thomas.L
 *
 */
public class Livre{
       private String titre, auteur, genre;
       private int nombrePage, nombreExemplaire;
       
       /**
        * La création de l'objet livre.
     * @param titre Titre du livre.
     * @param auteur Auteur du livre.
     * @param genre Genre du livre.
     * @param nombrePage Les nombres de pages du livre.
     * @param nombreExemplaire Les nombres d'exemplaires du livre.
     */
    public Livre(final String titre,final String auteur,final String genre,final int nombrePage,final int nombreExemplaire) {
    	   this.titre = titre;
    	   this.auteur = auteur;
    	   this.genre = genre;
    	   this.nombrePage = nombrePage;
    	   this.nombreExemplaire = nombreExemplaire;
       }

    
    // Getters et Setters

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getNombrePage() {
		return nombrePage;
	}

	public void setNombrePage(int nombrePage) {
		this.nombrePage = nombrePage;
	}

	public int getNombreExemplaire() {
		return nombreExemplaire;
	}

	public void setNombreExemplaire(int nombreExemplaire) {
		this.nombreExemplaire = nombreExemplaire;
	}
    
}

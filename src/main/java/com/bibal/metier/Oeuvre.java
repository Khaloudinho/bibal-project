package com.bibal.metier;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Oeuvre implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idOeuvre;
	private String titre;
	private String auteur;
	private String genre;

	public Oeuvre(String titre, String auteur, String genre) {
		this.titre = titre;
		this.auteur = auteur;
		this.genre = genre;
	}

	public Long getIdOeuvre() {
		return idOeuvre;
	}

	public void setIdOeuvre(Long idOeuvre) {
		this.idOeuvre = idOeuvre;
	}

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
}

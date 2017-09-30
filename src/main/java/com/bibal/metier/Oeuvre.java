package com.bibal.metier;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
public class Oeuvre implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idOeuvre;
	private String titre;
	private String auteur;
	private String genre;

	@OneToMany
	@JoinColumn(name = "idOeuvre", referencedColumnName = "idOeuvre")
	private Set<Reservation> setReservations;


	public Oeuvre() {}

	public Oeuvre(String titre, String auteur, String genre, Set<Reservation> setReservations) {
		this.titre = titre;
		this.auteur = auteur;
		this.genre = genre;
		this.setReservations = setReservations;
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

	public Set<Reservation> getSetReservations() {
		return setReservations;
	}

	public void setSetReservations(Set<Reservation> setReservations) {
		this.setReservations = setReservations;
	}
}

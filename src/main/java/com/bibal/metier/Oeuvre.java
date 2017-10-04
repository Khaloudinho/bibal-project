package com.bibal.metier;

import com.bibal.util.GenreOeuvre;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Oeuvre implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idOeuvre;
	private String titre;
	private String auteur;

	@Enumerated(EnumType.STRING)
	private GenreOeuvre genre;

	@OneToMany
	@JoinColumn(name = "idOeuvre")
	private Set<Reservation> listeReservations;

	@OneToMany
	@JoinColumn(name = "idExemplaire")
	private Set<Exemplaire> listeExemplaires;

	public Oeuvre() {}

	public Oeuvre(String titre, String auteur, GenreOeuvre genre) {
		this.titre = titre;
		this.auteur = auteur;
		this.genre = genre;
		this.listeReservations = new HashSet<Reservation>();
		this.listeExemplaires = new HashSet<Exemplaire>();
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

	public GenreOeuvre getGenre() {
		return genre;
	}

	public void setGenre(GenreOeuvre genre) {
		this.genre = genre;
	}

	public Set<Reservation> getSetReservations() {
		return listeReservations;
	}

	public void setReservations(Set<Reservation> listeReservations) {
		this.listeReservations = listeReservations;
	}
}

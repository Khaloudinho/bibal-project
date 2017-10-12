package com.bibal.metier;

import com.bibal.util.TypeOeuvre;

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
	private TypeOeuvre type;

	@OneToMany
	@JoinColumn(name = "idOeuvre")
	private Set<Reservation> listeReservations;

	@OneToMany(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "idOeuvre")
	private Set<Exemplaire> listeExemplaires;

	public Oeuvre() {}

	public Oeuvre(String titre, String auteur, TypeOeuvre type) {
		this.titre = titre;
		this.auteur = auteur;
		this.type = type;
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

	public TypeOeuvre getType() {
		return type;
	}

	public void setType(TypeOeuvre type) {
		this.type = type;
	}

	public Set<Reservation> getSetReservations() {
		return listeReservations;
	}

	public void setReservations(Set<Reservation> listeReservations) {
		this.listeReservations = listeReservations;
	}
}

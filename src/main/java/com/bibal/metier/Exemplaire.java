package com.bibal.metier;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Exemplaire implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idExemplaire;

	@ManyToOne
	@JoinColumn(name = "idOeuvre")
	private Oeuvre oeuvre;

	//@ManyToMany
	//@JoinColumn(name = "idEmprunt")
	//private Set<Emprunt> listeEmprunts;

	private String etat;

	public Exemplaire() {}

	public Exemplaire(Oeuvre oeuvre, String etat) {
		this.oeuvre = oeuvre;
		//this.listeEmprunts = new HashSet<Emprunt>();
		this.etat = etat;
	}

	public Long getIdExemplaire() {
		return idExemplaire;
	}

	public void setIdExemplaire(Long idExemplaire) {
		this.idExemplaire = idExemplaire;
	}

	public Oeuvre getOeuvre() {
		return oeuvre;
	}

	public void setOeuvre(Oeuvre oeuvre) {
		this.oeuvre = oeuvre;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}
}
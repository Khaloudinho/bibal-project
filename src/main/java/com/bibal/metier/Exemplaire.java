package com.bibal.metier;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Exemplaire implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idExemplaire;
	private Long idOeuvre;
	private String etat;
	private Long idEmprunt;


	public Exemplaire() {}

	public Exemplaire(Long idOeuvre, String etat) {
		this.idOeuvre = idOeuvre;
		this.etat = etat;
	}

	public Exemplaire(Long idOeuvre, String etat, Long idEmprunt) {
		this.idOeuvre = idOeuvre;
		this.etat = etat;
		this.idEmprunt = idEmprunt;
	}

	public Long getIdExemplaire() {
		return idExemplaire;
	}

	public void setIdExemplaire(Long idExemplaire) {
		this.idExemplaire = idExemplaire;
	}

	public Long getIdOeuvre() {
		return idOeuvre;
	}

	public void setIdOeuvre(Long idOeuvre) {
		this.idOeuvre = idOeuvre;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public Long getIdEmprunt() {
		return idEmprunt;
	}

	public void setIdEmprunt(Long idEmprunt) {
		this.idEmprunt = idEmprunt;
	}
}

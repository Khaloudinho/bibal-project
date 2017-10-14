package com.bibal.metier;

import javax.persistence.*;
import java.io.Serializable;

import com.bibal.util.EtatExemplaire;

/**
 * classe metier Exemplaire
 * les annotations permettent le mappage avec la base de donnees par le biais d'hibernate
 */
@Entity
public class Exemplaire implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JoinColumn(name = "idExemplaire")
	private Long idExemplaire;

	@ManyToOne
	@JoinColumn(name = "idOeuvre")
	private Oeuvre oeuvre;

	@OneToOne
	@JoinColumn(name = "idEmprunt")
	private Emprunt emprunt;

	@Enumerated(EnumType.STRING)
	private EtatExemplaire etat;

	public Exemplaire() {}

	public Exemplaire(Oeuvre oeuvre, EtatExemplaire etat) {
		this.oeuvre = oeuvre;
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

	public EtatExemplaire getEtat() {
		return etat;
	}

	public void setEtat(EtatExemplaire etat) {
		this.etat = etat;
	}
}
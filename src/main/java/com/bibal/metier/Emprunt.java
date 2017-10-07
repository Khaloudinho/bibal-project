package com.bibal.metier;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
public class Emprunt implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idEmprunt;
	private Date date;

	@OneToOne
	@JoinColumn(name = "idExemplaire")
	private Exemplaire exemplaire;

	@ManyToOne
	@JoinColumn(name = "idUsager", nullable = false)
	private Usager usager;

	private boolean statut;

	public Emprunt() { }

	public Emprunt(Date date, Usager usager, Exemplaire exemplaire) {
		this.date = date;
		this.usager = usager;
		this.exemplaire = exemplaire;
		this.statut=false;
	}

	public Long getIdEmprunt() {
		return idEmprunt;
	}

	public void setIdEmprunt(Long idEmprunt) {
		this.idEmprunt = idEmprunt;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Exemplaire getExemplaire() {
		return exemplaire;
	}

	public void setExemplaire(Exemplaire exemplaire) {
		this.exemplaire = exemplaire;
	}

	public Usager getUsager() {
		return usager;
	}

	public void setUsager(Usager usager) {
		this.usager = usager;
	}

	public boolean isStatut() {
		return statut;
	}

	public void setStatut(boolean statut) {
		this.statut = statut;
	}
}

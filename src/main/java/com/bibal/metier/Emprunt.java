package com.bibal.metier;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

/**
 * classe metier EMprunt
 * les annotations permettent le mappage avec la base de donnees par le biais d'hibernate
 */
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
	@JoinColumn(name = "idUsager")
	private Usager usager;

	private boolean archive;

	public Emprunt() { }

	public Emprunt(Date date, Usager usager, Exemplaire exemplaire) {
		this.date = date;
		this.usager = usager;
		this.exemplaire = exemplaire;
		this.archive = false;
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

	public boolean isArchive() {
		return archive;
	}

	public void setArchive(boolean archive) {
		this.archive = archive;
	}
}

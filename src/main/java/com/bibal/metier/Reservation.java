package com.bibal.metier;

import java.io.Serializable;
import javax.persistence.*;
import com.bibal.util.StatutReservation;

import java.sql.Date;

/**
 * classe metier usager
 * les annotations permettent le mappage avec la base de donnees par le biais d'hibernate
 */
@Entity
public class Reservation implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idReservation;
	private Date date;

	@Enumerated(EnumType.STRING)
	private StatutReservation statut;

	@ManyToOne
	@JoinColumn(name = "idUsager")
	private Usager usager;

	@ManyToOne
	@JoinColumn(name = "idOeuvre")
	private Oeuvre oeuvre;

	public Reservation() {}

	public Reservation(Date date, Usager usager, Oeuvre oeuvre) {
		this.date = date;
		this.usager = usager;
		this.oeuvre = oeuvre;
		this.statut = StatutReservation.Encours;
	}

	public StatutReservation getStatut() {
		return statut;
	}

	public void setStatut(StatutReservation statut) {
		this.statut = statut;
	}

	public Long getIdReservation() {
		return idReservation;
	}

	public void setIdReservation(Long idReservation) {
		this.idReservation = idReservation;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Usager getUsager() {
		return usager;
	}

	public void setUsager(Usager usager) {
		this.usager = usager;
	}

	public Oeuvre getOeuvre() {
		return oeuvre;
	}

	public void setOeuvre(Oeuvre oeuvre) {
		this.oeuvre = oeuvre;
	}
}

package com.bibal.metier;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.*;

import com.bibal.util.EtatUsager;
import com.bibal.util.StatutReservation;

@Entity
public class Reservation implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idReservation;
	private Date date;

	@ManyToOne
	@JoinColumn(name = "idUsager")
	private Usager usager;

	@ManyToOne
	@JoinColumn(name = "idOeuvre")
	private Oeuvre oeuvre;

	@Enumerated(EnumType.STRING)
	private StatutReservation statut;

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

package com.bibal.service.interfaces;

import java.sql.Date;
import java.util.List;

import com.bibal.metier.Oeuvre;
import com.bibal.metier.Reservation;
import com.bibal.metier.Usager;
import com.bibal.util.StatutReservation;

public interface ReservationService {
	//POST
	void ajouterReservation(Date date, Usager usager, Oeuvre oeuvre);

	//DELETE
	void archiverReservationSelonEmprunt(Long idEmprunt);

	//PUT
	Reservation modifierReservation(Long idReservation, Date date, StatutReservation statut);

	//GET
	List<Reservation> recupererToutesLesReservations();
	Reservation recupererReservationViaID(Long idReservation);
}

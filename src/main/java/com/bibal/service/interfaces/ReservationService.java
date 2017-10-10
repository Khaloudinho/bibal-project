package com.bibal.service.interfaces;

import java.sql.Date;
import java.util.List;

import com.bibal.metier.Oeuvre;
import com.bibal.metier.Reservation;
import com.bibal.metier.Usager;
import com.bibal.util.StatutReservation;

public interface ReservationService {

	void ajouterReservation(Date date, Usager usager, Oeuvre oeuvre);
	List<Reservation> recupererToutesLesReservations();
	Reservation recupererReservationViaID(Long idReservation);
	Reservation modifierReservation(Long idReservation, Date date, StatutReservation statut);

}

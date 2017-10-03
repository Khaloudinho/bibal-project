package com.bibal.service.interfaces;

import com.bibal.metier.Emprunt;
import com.bibal.metier.Oeuvre;
import com.bibal.metier.Reservation;
import com.bibal.metier.Usager;
import com.bibal.util.StatutReservation;

import java.sql.Date;
import java.util.List;

public interface EmpruntService {

	//void ajouterReservation(Date date, Usager usager, Oeuvre oeuvre, String statut);
	List<Emprunt> recupererTousLesEmprunts();
	//Reservation recupererReservationViaID(Long idUsager);
	//Reservation modifierReservation(Long idReservation, Date date, Usager usager, Oeuvre oeuvre, StatutReservation statut);

}

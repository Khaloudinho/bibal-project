package com.bibal.service.interfaces;

import com.bibal.metier.*;
import com.bibal.util.StatutReservation;

import java.sql.Date;
import java.util.List;

public interface EmpruntService {

	//void ajouterReservation(Date date, Usager usager, Oeuvre oeuvre, String statut);
	List<Emprunt> recupererTousLesEmprunts();
	void ajouterEmprunt(Date date, Usager usager, Exemplaire exemplaire);
	Emprunt recupererEmpruntViaID(Long idEmprunt);
	//Reservation modifierReservation(Long idReservation, Date date, Usager usager, Oeuvre oeuvre, StatutReservation statut);

}

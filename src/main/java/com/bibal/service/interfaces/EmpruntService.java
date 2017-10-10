package com.bibal.service.interfaces;

import com.bibal.metier.*;
import com.bibal.util.StatutReservation;

import java.sql.Date;
import java.util.List;

public interface EmpruntService {

	// GET
	List<Emprunt> recupererTousLesEmprunts();
	Emprunt recupererEmpruntViaID(Long idEmprunt);

	//GET
	Emprunt recupererDernierEmprunt();

	// POST
	void ajouterEmprunt(Date date, Usager usager, Exemplaire exemplaire);

	// DELETE
	void archiverEmprunt(Long idEmprunt);
}

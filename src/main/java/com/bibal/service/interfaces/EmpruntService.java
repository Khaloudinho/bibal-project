package com.bibal.service.interfaces;

import com.bibal.metier.*;

import java.sql.Date;
import java.util.List;

public interface EmpruntService {
	// POST
	void ajouterEmprunt(Date date, Usager usager, Exemplaire exemplaire);

	// DELETE
	void archiverEmprunt(Long idEmprunt);

	// GET
	Emprunt recupererEmpruntViaID(Long idEmprunt);
	List<Emprunt> recupererTousLesEmprunts();
	Emprunt recupererDernierEmprunt();

}

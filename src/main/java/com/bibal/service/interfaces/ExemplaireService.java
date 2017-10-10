package com.bibal.service.interfaces;

import com.bibal.metier.Exemplaire;
import com.bibal.util.EtatExemplaire;

import java.util.List;

public interface ExemplaireService {

	// GET
	List<Exemplaire> recupererTousLesExemplaires();

	//GET
	List<Exemplaire> recupererTousLesExemplairesNonEmpruntes();

	Exemplaire recupererExemplaireViaID(Long idExemplaire);

	// POST
	void ajouterExemplaire(Long idOeuvre, EtatExemplaire etat);

	// PUT
	Exemplaire modifierExemplaire(Long idExemplaire, EtatExemplaire etat);

	// DELETE
	void supprimerExemplaire(Long idExemplaire);

}

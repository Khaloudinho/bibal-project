package com.bibal.service.interfaces;

import com.bibal.metier.Exemplaire;
import com.bibal.util.EtatExemplaire;

import java.util.List;

public interface ExemplaireService {
	// POST
	void ajouterExemplaire(Long idOeuvre, EtatExemplaire etat);

	// DELETE
	void supprimerExemplaire(Long idExemplaire);

	// PUT
	Exemplaire modifierExemplaire(Long idExemplaire, EtatExemplaire etat);

	//GET
	Exemplaire recupererExemplaireViaID(Long idExemplaire);
	List<Exemplaire> recupererTousLesExemplaires();
	List<Exemplaire> recupererTousLesExemplairesNonEmpruntes();

}

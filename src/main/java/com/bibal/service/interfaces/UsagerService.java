package com.bibal.service.interfaces;

import com.bibal.metier.Usager;

import java.util.List;

public interface UsagerService {

	// POST
	void ajouterUsager(String nom, String prenom, String adresse, String mail, String telephone);
	// void activer(Long idUsager);

	// DELETE
	void supprimerUsager(Long idUsager);

	// GET
	List<Usager> recupererTousLesUsagers();
	Usager recupererUsagerViaID(Long idUsager);
	List<Usager> recupererUsagersViaNom(String nom);

	// PUT
	Usager modifierUsager(Long idUsager, String adresse, String mail, String telephone);

}

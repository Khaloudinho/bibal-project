package com.bibal.service.interfaces;

import com.bibal.metier.Oeuvre;
import com.bibal.util.TypeOeuvre;

import java.util.List;

public interface OeuvreService {

	// GET
	List<Oeuvre> recupererToutesLesOeuvres();
	Oeuvre recupererOeuvreViaID(Long idOeuvre);

	// POST
	void ajouterOeuvre(String titre, String auteur, TypeOeuvre type);

	// PUT
	Oeuvre modifierOeuvre(Long idOeuvre, String titre, String auteur, TypeOeuvre type);

	// DELETE
	void supprimerOeuvre(Long idOeuvre);

}
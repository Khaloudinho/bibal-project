package com.bibal.service.interfaces;

import java.util.List;

import com.bibal.metier.Oeuvre;
import com.bibal.util.TypeOeuvre;

public interface OeuvreService {
	// POST
	void ajouterOeuvre(String titre, String auteur, TypeOeuvre type);

	// DELETE
	void supprimerOeuvre(Long idOeuvre);
	// SECURISE LE DELETE
	Oeuvre recupererOeuvreSiExemplaires(Long idOeuvre);

	// PUT
	Oeuvre modifierOeuvre(Long idOeuvre, String titre, String auteur, TypeOeuvre type);

	// GET
	List<Oeuvre> recupererToutesLesOeuvres();
	Oeuvre recupererOeuvreViaID(Long idOeuvre);

}
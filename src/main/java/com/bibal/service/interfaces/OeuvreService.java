package com.bibal.service.interfaces;

import com.bibal.metier.Oeuvre;
import com.bibal.util.GenreOeuvre;

import java.util.List;

public interface OeuvreService {

	// GET
	List<Oeuvre> recupererToutesLesOeuvres();
	Oeuvre recupererOeuvreViaID(Long idOeuvre);
	List<Oeuvre> recupererOeuvresViaTitre(String titre);

	// POST
	void ajouterOeuvre(String titre, String auteur, GenreOeuvre genre);

	// PUT
	Oeuvre modifierOeuvre(Long idOeuvre, String titre, String auteur, GenreOeuvre genre);

	// DELETE
	void supprimerOeuvre(Long idOeuvre);

}
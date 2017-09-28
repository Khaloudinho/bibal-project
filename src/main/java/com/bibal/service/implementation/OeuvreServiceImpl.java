package com.bibal.service.implementation;

import com.bibal.dao.OeuvreRepository;
import com.bibal.metier.Oeuvre;
import com.bibal.service.interfaces.OeuvreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class OeuvreServiceImpl implements OeuvreService {

	@Autowired
	private OeuvreRepository oeuvreRepository;

	@Override
	public List<Oeuvre> recupererToutesLesOeuvres() {
	    return oeuvreRepository.findAll();
        //recupererToutesLesOeuvres();
	}

	@Override
	public Oeuvre recupererOeuvreViaID(Long idOeuvre) {
		return oeuvreRepository.getOne(idOeuvre);
        //recupererOeuvreViaID(idOeuvre);
	}

	@Override
	public List<Oeuvre> recupererOeuvreViaTitre(String titre) {
	    return oeuvreRepository.recupererOeuvreViaTitre(titre);
	}

	@Override
	public void ajouterOeuvre(String titre, String auteur, String genre) {
		Oeuvre oeuvre = new Oeuvre(titre, auteur, genre);
		oeuvreRepository.save(oeuvre);
	}

	@Override
	public void supprimerOeuvre(Long idOeuvre) {
	    oeuvreRepository.delete(idOeuvre);
        //supprimerOeuvreViaID(idOeuvre);
	}

	@Override
	public Oeuvre modifierOeuvre(Long idOeuvre, String titre, String auteur, String genre) {
		Oeuvre oeuvre = recupererOeuvreViaID(idOeuvre);
		oeuvre.setTitre(titre);
		oeuvre.setAuteur(auteur);
		oeuvre.setGenre(genre);
		return oeuvre;
	}

}

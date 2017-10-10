package com.bibal.service.implementation;

import com.bibal.dao.OeuvreRepository;
import com.bibal.metier.Oeuvre;
import com.bibal.service.interfaces.OeuvreService;
import com.bibal.util.TypeOeuvre;
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
	}

	@Override
	public Oeuvre recupererOeuvreViaID(Long idOeuvre) {
		return oeuvreRepository.findOne(idOeuvre);
	}

	@Override
	public void ajouterOeuvre(String titre, String auteur, TypeOeuvre type) {
		Oeuvre oeuvre = new Oeuvre(titre, auteur, type);
		oeuvreRepository.save(oeuvre);
	}

	@Override
	public void supprimerOeuvre(Long idOeuvre) {
	    oeuvreRepository.delete(idOeuvre);
	}

	@Override
	public Oeuvre modifierOeuvre(Long idOeuvre, String titre, String auteur, TypeOeuvre type) {
		Oeuvre oeuvre = recupererOeuvreViaID(idOeuvre);
		oeuvre.setTitre(titre);
		oeuvre.setAuteur(auteur);
		oeuvre.setType(type);
		return oeuvre;
	}

}

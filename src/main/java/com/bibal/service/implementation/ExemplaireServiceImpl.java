package com.bibal.service.implementation;

import com.bibal.dao.ExemplaireRepository;
import com.bibal.metier.Exemplaire;
import com.bibal.service.interfaces.ExemplaireService;
import com.bibal.service.interfaces.OeuvreService;
import com.bibal.util.EtatExemplaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ExemplaireServiceImpl implements ExemplaireService {

	@Autowired
	private ExemplaireRepository exemplaireRepository;

	@Autowired
	private OeuvreService oeuvreService;

	@Override
	public List<Exemplaire> recupererTousLesExemplaires() {
	    return exemplaireRepository.findAll();
	}

	@Override
	public Exemplaire recupererExemplaireViaID(Long idExemplaire) {
		return exemplaireRepository.findOne(idExemplaire);
	}

	@Override
	public void ajouterExemplaire(Long idOeuvre, String etat) {
		Exemplaire exemplaire = new Exemplaire(oeuvreService.recupererOeuvreViaID(idOeuvre), etat);
		exemplaireRepository.save(exemplaire);
	}

	@Override
	public void supprimerExemplaire(Long idExemplaire) {
	    exemplaireRepository.delete(idExemplaire);
	}

	@Override
	public Exemplaire modifierExemplaire(Long idExemplaire, EtatExemplaire etat) {
		Exemplaire exemplaire = recupererExemplaireViaID(idExemplaire);
		exemplaire.setEtat(String.valueOf(etat));
		return exemplaire;
	}

}

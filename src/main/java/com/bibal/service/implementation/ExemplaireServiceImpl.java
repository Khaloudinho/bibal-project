package com.bibal.service.implementation;

import com.bibal.metier.Exemplaire;
import com.bibal.util.EtatExemplaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

import java.util.List;

import com.bibal.service.interfaces.ExemplaireService;
import com.bibal.service.interfaces.OeuvreService;

import com.bibal.dao.ExemplaireRepository;

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
	public List<Exemplaire> recupererTousLesExemplairesNonEmpruntes() {
		return exemplaireRepository.recupererTousLesExemplairesNonEmpruntes();
	}

	@Override
	public Exemplaire recupererExemplaireViaID(Long idExemplaire) {
		return exemplaireRepository.findOne(idExemplaire);
	}

	@Override
	public void ajouterExemplaire(Long idOeuvre, EtatExemplaire etat) {
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
		exemplaire.setEtat(etat);
		return exemplaire;
	}

}

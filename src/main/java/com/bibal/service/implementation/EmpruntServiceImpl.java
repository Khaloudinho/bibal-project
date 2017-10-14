package com.bibal.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

import java.sql.Date;
import java.util.List;

import com.bibal.service.interfaces.EmpruntService;
import com.bibal.dao.EmpruntRepository;

import com.bibal.metier.Exemplaire;
import com.bibal.metier.Emprunt;
import com.bibal.metier.Usager;
@Service
@Transactional
public class EmpruntServiceImpl implements EmpruntService {

	@Autowired
	private EmpruntRepository empruntRepository;

	@Override
	public List<Emprunt> recupererTousLesEmprunts() {
		return empruntRepository.findAll();
	}

	@Override
	public Emprunt recupererEmpruntViaID(Long idEmprunt) {
		return empruntRepository.findOne(idEmprunt);
	}

	@Override
	public Emprunt recupererDernierEmprunt() {
		return empruntRepository.recupererDernierEmprunt();
	}

	@Override
	public void ajouterEmprunt(Date date, Usager usager, Exemplaire exemplaire) {
		Emprunt emprunt = new Emprunt(date, usager, exemplaire);
		empruntRepository.save(emprunt);
	}

	//L'emprunt est seulement arhive et non supprimme
	@Override
	public void archiverEmprunt(Long idEmprunt){
		empruntRepository.archiverEmprunt(idEmprunt);
	}
}

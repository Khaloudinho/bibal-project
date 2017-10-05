package com.bibal.service.implementation;

import com.bibal.dao.EmpruntRepository;
import com.bibal.metier.Exemplaire;
import com.bibal.metier.Oeuvre;
import com.bibal.metier.Emprunt;
import com.bibal.metier.Usager;
import com.bibal.service.interfaces.EmpruntService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

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
	public void ajouterEmprunt(Date date, Usager usager, Exemplaire exemplaire) {
		Emprunt emprunt = new Emprunt(date, usager, exemplaire);
		empruntRepository.save(emprunt);
	}

	@Override
	public void archiverEmprunt(Long idEmprunt){
		empruntRepository.archiverEmprunt(idEmprunt);
	}
/*
	@Override
	public Emprunt modifierEmprunt(Long idEmprunt, Date date, Usager usager, Exemplaire exemplaire) {
		Emprunt emprunt = recupererEmpruntViaID(idEmprunt);
		emprunt.setDate(date);
		emprunt.setUsager(usager);
		emprunt.setOeuvre(oeuvre);
		return emprunt;
	}
	*/
}

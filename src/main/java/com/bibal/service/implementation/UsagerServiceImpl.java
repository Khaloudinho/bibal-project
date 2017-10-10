package com.bibal.service.implementation;

import com.bibal.dao.UsagerRepository;
import com.bibal.metier.Usager;
import com.bibal.service.interfaces.UsagerService;
import com.bibal.util.EtatUsager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UsagerServiceImpl implements UsagerService {

	@Autowired
	private UsagerRepository usagerRepository;

	@Override
	public List<Usager> recupererTousLesUsagers() {
		return usagerRepository.findAll();
	}

	@Override
	public Usager recupererUsagerViaID(Long idUsager) {
		return usagerRepository.findOne(idUsager);
	}

	@Override
	public List<Usager> recupererUsagersViaNom(String nom) {
		return usagerRepository.recupererUsagersViaNom(nom);
	}

	@Override
	public void ajouterUsager(String nom, String prenom, String adresse, String mail, String telephone) {
		Usager usager = new Usager(nom, prenom, adresse, mail, telephone);
		usagerRepository.save(usager);
	}

	@Override
	public void supprimerUsager(Long idUsager) {
		usagerRepository.delete(idUsager);
	}

	@Override
	public Usager modifierUsager(Long idUsager, String adresse, String mail, String telephone) {
		Usager usager = recupererUsagerViaID(idUsager);
		usager.setAdresse(adresse);
		usager.setMail(mail);
		usager.setTelephone(telephone);
		return usager;
	}
}

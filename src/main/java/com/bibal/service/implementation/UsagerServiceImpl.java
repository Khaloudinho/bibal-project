package com.bibal.service.implementation;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bibal.dao.UsagerRepository;
import com.bibal.metier.Usager;
import com.bibal.service.interfaces.UsagerService;
import com.bibal.util.EtatUsager;

@Service
@Transactional
public class UsagerServiceImpl implements UsagerService {

	@Autowired
	private UsagerRepository usagerRepository;

	@Override
	public List<Usager> findAll() {
		return usagerRepository.findAll();
	}

	@Override
	public Usager getById(Long idUsager) {
		return usagerRepository.findOne(idUsager);
	}

	@Override
	public List<Usager> searchByName(String nom) {
		return usagerRepository.searchUsagersByName(nom);
	}

	@Override
	public void activer(Long idUsager) {
		Usager usager = getById(idUsager);
		usager.setEtat(EtatUsager.Client.toString());
	}

	@Override
	public void addUsager(String nom, String prenom, String adresse, String mail, String tel) {
		Usager usager = new Usager(nom, prenom, adresse, mail, tel, 0, "OK", null);
		usagerRepository.save(usager);
	}

	@Override
	public void supprimmerUsager(Long idUsager) {
		usagerRepository.deleteUsagerById(idUsager);
	}

	@Override
	public Usager update(Long idUsager, String nom, String prenom, String adresse, String tel, String mail) {
		Usager usager = getById(idUsager);
		usager.setNom(nom);
		usager.setPrenom(prenom);
		usager.setAdresse(adresse);
		usager.setTel(tel);
		usager.setMail(mail);
		return usager;
	}

}

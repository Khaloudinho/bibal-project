package com.bibal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.bibal.service.interfaces.UsagerService;
import com.bibal.metier.Usager;

@Configuration
@Controller
@EnableAutoConfiguration
@ComponentScan
public class UsagersController {

	@Autowired
	private UsagerService usagerService;

	/**
	 * Permet de recuperer la la liste des usagers
	 * @param model
	 * @return vue listant les usagers
	 */
	@GetMapping(value = "usagers")
	public String recupererTousLesUsagers(Model model) {
		List<Usager> usagers = usagerService.recupererTousLesUsagers();
		model.addAttribute("usagers", usagers);
		return "usagers";
	}

	/**
	 * Permet d'obtenir le formulaire d'ajout usager
	 * @return vue permettant de creer un usager
	 */
	@GetMapping(value = "usagers/create")
	public String getFormAjouterUsager() {
		return "formAjouterUsager";
	}

	/**
	 * Permet l'enregistrement de l'usager que l'on souhaite ajouter
	 * @param prenom
	 * @param nom
	 * @param adresse
	 * @param mail
	 * @param telephone
	 * @return vue listant les usagers
	 */
	@PostMapping(value = "usagers")
	public String ajouterUsager(String prenom, String nom, String adresse, String mail, String telephone) {
		usagerService.ajouterUsager(nom, prenom, adresse, mail, telephone);
		return "redirect:usagers";
	}

	/**
	 * Permet d'obtenir le formulaire de modification de l'usager
	 * @param idUsager
	 * @param model
	 * @return vue pemettant de modifier un usager
	 */
	@GetMapping(value = "usagers/{idUsager}/edit")
	public String getFormModifierUsager(@PathVariable Long idUsager, Model model) {
		Usager usager = usagerService.recupererUsagerViaID(idUsager);
		model.addAttribute("usager", usager);
		return "formModifierUsager";
	}

	/**
	 * Permet de modifier l'usager
	 * @param idUsager
	 * @param adresse
	 * @param mail
	 * @param telephone
	 * @return vue listant les usagers
	 */
	@PutMapping(value = "usagers/{idUsager}")
	public String modifierUsager(@PathVariable String idUsager, String adresse, String mail, String telephone) {
		usagerService.modifierUsager(Long.valueOf(idUsager), adresse, mail, telephone);
		return "redirect:/usagers";
	}

	/**
	 * Permet de suprimmer un usager
	 * @param idUsager
	 * @return
	 */
	@DeleteMapping(value = "usagers/{idUsager}")
	public String supprimerUsager(@PathVariable Long idUsager) {
		usagerService.supprimerUsager(idUsager);
		return "redirect:/usagers";
	}
}

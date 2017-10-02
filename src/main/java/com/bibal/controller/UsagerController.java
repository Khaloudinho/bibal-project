package com.bibal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.bibal.metier.Usager;
import com.bibal.service.interfaces.UsagerService;

@Configuration
@Controller
@EnableAutoConfiguration
@ComponentScan
public class UsagerController {

	@Autowired
	private UsagerService usagerService;

	@GetMapping(value = "usagers")
	public String recupererTousLesUsagers(Model model) {
		List<Usager> usagers = usagerService.recupererTousLesUsagers();
		model.addAttribute("usagers", usagers);
		return "usagers";
	}

	@GetMapping(value = "usagers/create")
	public String getFormAjouterUsager() {
		return "formAjouterUsager";
	}

	@PostMapping(value = "usagers")
	public String ajouterUsager(String prenom, String nom, String adresse, String mail, String telephone) {
		usagerService.ajouterUsager(nom, prenom, adresse, mail, telephone);
		return "redirect:usagers";
	}

	@GetMapping(value = "usagers/{idUsager}/edit")
	public String getFormModifierUsager(@PathVariable Long idUsager, Model model) {
		Usager usager = usagerService.recupererUsagerViaID(idUsager);
		model.addAttribute("usager", usager);
		return "formModifierUsager";
	}

	@PutMapping(value = "usagers/{idUsager}")
	public String modifierUsager(@PathVariable String idUsager, String adresse, String mail, String telephone) {
		usagerService.modifierUsager(Long.valueOf(idUsager), adresse, mail, telephone);
		return "redirect:/usagers";
	}

	@DeleteMapping(value = "usagers/{idUsager}")
	public String supprimerUsager(@PathVariable Long idUsager) {
		usagerService.supprimerUsager(idUsager);
		return "redirect:/usagers";
	}
}

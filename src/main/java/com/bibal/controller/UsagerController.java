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

	@GetMapping("/usagers")
	public String recupererToutesLesUsagers(Model model) {
		List<Usager> usagers = usagerService.findAll();
		model.addAttribute("allUsagers", usagers);
		return "usagers";
	}

	@GetMapping("/usagers.json")
	public String recupererToutesLesUsagersJSON(Model model) {
		this.recupererToutesLesUsagers(model);
		return "usagers";
	}
	@GetMapping(value = "/addUsagerForm")
	public String getFormCreationUsager() {
		return "createUserForm";
	}

	@PostMapping(value = "/addUsager")
	public String ajouterUsager(@RequestParam("prenom") String prenom, @RequestParam("nom") String nom,
			@RequestParam("adresse") String adresse, @RequestParam("mail") String mail,
			@RequestParam("tel") String tel) {
		usagerService.addUsager(nom, prenom, adresse, mail, tel);
		return "redirect:usagers";
	}

	@GetMapping(value = "/usagers/{id}/edit")
	public String getFormModifierUsager(@PathVariable(value = "id") Long idUsager, Model model) {
		Usager usager = usagerService.getById(idUsager);
		model.addAttribute("usager", usager);
		return "updateUserForm";
	}

	@PutMapping(value = "/usager")
	public String modifierUsager(@RequestParam("id") String id, @RequestParam("prenom") String prenom,
			@RequestParam("nom") String nom, @RequestParam("adresse") String adresse,
			@RequestParam("mail") String mail, @RequestParam("tel") String tel) {
		usagerService.update(Long.valueOf(id), nom, prenom, adresse, tel, mail);
		return "redirect:usagers";
	}

	@DeleteMapping(value = "/usager")
	public String supprimerUsager(Long idUsager) {
		usagerService.supprimmerUsager(idUsager);
		return "redirect:usagers";
	}
}

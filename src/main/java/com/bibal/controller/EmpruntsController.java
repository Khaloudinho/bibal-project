package com.bibal.controller;

import com.bibal.metier.*;
import com.bibal.service.interfaces.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.JoinColumn;
import java.sql.Date;
import java.util.List;

@Configuration
@Controller
@EnableAutoConfiguration
@ComponentScan
public class EmpruntsController {

	@Autowired
	private EmpruntService empruntService;

	@Autowired
	private UsagerService usagerService;

	@Autowired
	private OeuvreService oeuvreService;

	@Autowired
	private ExemplaireService exemplaireService;

	@GetMapping("emprunts")
	public String recupererTousLesEmprunts(Model model) {
		List<Emprunt> emprunts = empruntService.recupererTousLesEmprunts();
		model.addAttribute("emprunts", emprunts);
		return "emprunts";
	}

	@GetMapping("emprunts/create")
	public String getFormCreationEmprunt(Model model) {
		List<Usager> usagers = usagerService.recupererTousLesUsagers();
		List<Oeuvre> oeuvres = oeuvreService.recupererToutesLesOeuvres();
		List<Exemplaire> exemplaires = exemplaireService.recupererTousLesExemplaires();
		model.addAttribute("usagers", usagers);
		model.addAttribute("oeuvres", oeuvres);
		model.addAttribute("exemplaires", exemplaires);
		return "formAjouterEmprunt";
	}

	@PostMapping(value = "/emprunts")
	public String ajouterEmprunt(Date date, Long idUsager, Long idExemplaire) {
		Usager usager = usagerService.recupererUsagerViaID(idUsager);
		Exemplaire exemplaire = exemplaireService.recupererExemplaireViaID(idExemplaire);

		empruntService.ajouterEmprunt(date, usager, exemplaire);
		//usagerService.ajouterEmprunt()
		return "redirect:/emprunts";
	}

	@DeleteMapping(value = "emprunts/{idEmprunt}")
	public String archiverEmprunt(@PathVariable Long idEmprunt) {
		empruntService.archiverEmprunt(idEmprunt);
		return "redirect:/emprunts";
	}

}

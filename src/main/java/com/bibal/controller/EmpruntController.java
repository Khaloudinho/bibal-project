package com.bibal.controller;

import com.bibal.metier.*;
import com.bibal.service.interfaces.*;
import com.bibal.util.StatutReservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@Configuration
@Controller
@EnableAutoConfiguration
@ComponentScan
public class EmpruntController {

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
		return "redirect:/reservations";
	}
/*

	@GetMapping(value = "/reservations/{idUsager}/edit")
	public String getFormModifierUsager(@PathVariable Long idUsager, Model model) {
		List<Usager> usagers = usagerService.recupererTousLesUsagers();
		List<Oeuvre> oeuvres = oeuvreService.recupererToutesLesOeuvres();
		Reservation reservation = reservationService.recupererReservationViaID(idUsager);
		model.addAttribute("usagers", usagers);
		model.addAttribute("oeuvres", oeuvres);
		model.addAttribute("reservation", reservation);
		return "formModifierReservation";
	}

	@PutMapping(value = "/reservations")
	public String modifierUsager(Long idReservation, Date date, Long idUsager, Long idOeuvre, StatutReservation statut) {
		Usager usager = usagerService.recupererUsagerViaID(idUsager);
		Oeuvre oeuvre = oeuvreService.recupererOeuvreViaID(idOeuvre);
		reservationService.modifierReservation(Long.valueOf(idReservation), date, usager, oeuvre, statut);
		return "redirect:/reservations";
	}
	*/
}

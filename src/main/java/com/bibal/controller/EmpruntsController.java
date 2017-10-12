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

	@Autowired
	private ReservationService reservationService;

	/*
	* On utilise la méthode du service emprunt pour afficher tous
	* les emprunts puis on retourne ce résultat sur la vue emprunts.html
	* */
	@GetMapping("emprunts")
	public String recupererTousLesEmprunts(Model model) {
		List<Emprunt> emprunts = empruntService.recupererTousLesEmprunts();
		model.addAttribute("emprunts", emprunts);
		return "emprunts";
	}

	/*
	* On affiche le formulaire d'ajout d'un emprunt, pour ce faire on a
	* besoin d'afficher les usagers, les oeuvres ainsi que les exemplaires
	* dans les listes déroulantes c'est pourquoi nous utilisons les fonctions
	* adéquates avant de retourner le formulaire via formAjouterEmprunt.html
	* */
	@GetMapping("emprunts/create")
	public String getFormAjouterEmprunt(Model model) {
		List<Usager> usagers = usagerService.recupererTousLesUsagers();
		List<Oeuvre> oeuvres = oeuvreService.recupererToutesLesOeuvres();
		//List<Exemplaire> exemplaires = exemplaireService.recupererTousLesExemplaires();
		List<Exemplaire> exemplaires = exemplaireService.recupererTousLesExemplairesNonEmpruntes();
		model.addAttribute("usagers", usagers);
		model.addAttribute("oeuvres", oeuvres);
		model.addAttribute("exemplaires", exemplaires);
		return "formAjouterEmprunt";
	}

	/*
	* On ajoute un emprunt via cette fonction, on doit lier un emprunt à un usager et
	* un exemplaire donc on récupère ces informations via les services adéquats et on
	* ajoute un emprunt avec ces paramètres
	* */
	@PostMapping(value = "/emprunts")
	public String ajouterEmprunt(Date date, Long idUsager, Long idExemplaire) {
		Usager usager = usagerService.recupererUsagerViaID(idUsager);
		Exemplaire exemplaire = exemplaireService.recupererExemplaireViaID(idExemplaire);
		empruntService.ajouterEmprunt(date, usager, exemplaire);
		Emprunt dernierEmprunt = empruntService.recupererDernierEmprunt();
		// On archive la réservation qui correspond à l'emprunt que l'on crée tout de suite
		if (dernierEmprunt != null)
			reservationService.archiverReservationSelonEmprunt(dernierEmprunt.getIdEmprunt());
		return "redirect:/emprunts";
	}

	/*
	* On archive l'emprunt via cette fonction, lorsque l'on utilise le bouton "archiver"
	* de la vue emprunts.html, cela signifie que l'emprunt est terminé et que le livre a
	* été rendu
	* */
	@DeleteMapping(value = "emprunts/{idEmprunt}")
	public String archiverEmprunt(@PathVariable Long idEmprunt) {
		empruntService.archiverEmprunt(idEmprunt);
		return "redirect:/emprunts";
	}

}

package com.bibal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

import com.bibal.service.interfaces.ReservationService;
import com.bibal.service.interfaces.OeuvreService;
import com.bibal.service.interfaces.UsagerService;

import com.bibal.util.StatutReservation;
import com.bibal.metier.Oeuvre;
import com.bibal.metier.Usager;
import com.bibal.metier.Reservation;

@Configuration
@Controller
@EnableAutoConfiguration
@ComponentScan
public class ReservationsController {

	@Autowired
	private ReservationService reservationService;

	@Autowired
	private UsagerService usagerService;

	@Autowired
	private OeuvreService oeuvreService;

	/*
	* On récupère toutes les réservations que l'on affiche sur la page reservations.html
	* */
	@GetMapping("reservations")
	public String recupererToutesLesReservations(Model model) {
		List<Reservation> reservations = reservationService.recupererToutesLesReservations();
		model.addAttribute("reservations", reservations);
		return "reservations";
	}

	/*
	* On affiche le formulaire d'ajout de réservation, on charge la liste d'usagers et d'oeuvres pour alimenter
	* les deux listes déroulantes du formulaire de la page formAjouteReservation.html
	* */
	@GetMapping("reservations/create")
	public String getFormAjouterReservation(Model model) {
		List<Usager> usagers = usagerService.recupererTousLesUsagers();
		List<Oeuvre> oeuvres = oeuvreService.recupererToutesLesOeuvres();
		model.addAttribute("usagers", usagers);
		model.addAttribute("oeuvres", oeuvres);
		return "formAjouterReservation";
	}

	/*
	* On ajoute une réservation grâce à un usager, une oeuvre et une date,
	* le statut est automatiquement paramétré à "en cours" puis on redirige vers la page reservations.html
	* */
	@PostMapping(value = "/reservations")
	public String ajouterReservation(Date date, Long idUsager, Long idOeuvre) {
		Usager usager = usagerService.recupererUsagerViaID(idUsager);
		Oeuvre oeuvre = oeuvreService.recupererOeuvreViaID(idOeuvre);
		reservationService.ajouterReservation(date, usager, oeuvre);
		return "redirect:/reservations";
	}

	/*
	* On charge le formulaire de modification d'une réservation
	* */
	@GetMapping(value = "reservations/{idReservation}/edit")
	public String getFormModifierReservation(@PathVariable Long idReservation, Model model) {
		List<Usager> usagers = usagerService.recupererTousLesUsagers();
		List<Oeuvre> oeuvres = oeuvreService.recupererToutesLesOeuvres();
		Reservation reservation = reservationService.recupererReservationViaID(idReservation);
		model.addAttribute("usagers", usagers);
		model.addAttribute("oeuvres", oeuvres);
		model.addAttribute("reservation", reservation);
		return "formModifierReservation";
	}

	/*
	* On ajoute une réservation grâce à un usager, une oeuvre et une date,
	* le statut est automatiquement paramétré à "en cours" puis on redirige vers la page reservations.html
	* */
	@PutMapping(value = "reservations/{idReservation}")
	public String modifierReservation(@PathVariable Long idReservation, Date date, StatutReservation statut) {
		reservationService.modifierReservation(Long.valueOf(idReservation), date, statut);
		return "redirect:/reservations";
	}
}
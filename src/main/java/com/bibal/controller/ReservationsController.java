package com.bibal.controller;

import java.sql.Date;
import java.util.List;
import java.util.Set;

import com.bibal.metier.Oeuvre;
import com.bibal.metier.Usager;
import com.bibal.service.interfaces.OeuvreService;
import com.bibal.service.interfaces.UsagerService;
import com.bibal.util.StatutReservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.bibal.metier.Reservation;
import com.bibal.service.interfaces.ReservationService;

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

	@GetMapping("reservations")
	public String recupererToutesLesReservations(Model model) {
		List<Reservation> reservations = reservationService.recupererToutesLesReservations();
		model.addAttribute("reservations", reservations);
		return "reservations";
	}

	@GetMapping("reservations/create")
	public String getFormCreationReservation(Model model) {
		List<Usager> usagers = usagerService.recupererTousLesUsagers();
		List<Oeuvre> oeuvres = oeuvreService.recupererToutesLesOeuvres();
		model.addAttribute("usagers", usagers);
		model.addAttribute("oeuvres", oeuvres);
		return "formAjouterReservation";
	}

	@PostMapping(value = "/reservations")
	public String ajouterReservation(Date date, Long idUsager, Long idOeuvre) {
		Usager usager = usagerService.recupererUsagerViaID(idUsager);
		Oeuvre oeuvre = oeuvreService.recupererOeuvreViaID(idOeuvre);
		reservationService.ajouterReservation(date, usager, oeuvre);
		return "redirect:/reservations";
	}

	@GetMapping(value = "reservations/{idUsager}/edit")
	public String getFormModifierReservation(@PathVariable Long idUsager, Model model) {
		List<Usager> usagers = usagerService.recupererTousLesUsagers();
		List<Oeuvre> oeuvres = oeuvreService.recupererToutesLesOeuvres();
		Reservation reservation = reservationService.recupererReservationViaID(idUsager);
		model.addAttribute("usagers", usagers);
		model.addAttribute("oeuvres", oeuvres);
		model.addAttribute("reservation", reservation);
		return "formModifierReservation";
	}

	@PutMapping(value = "reservations/{idReservation}")
	public String modifierReservation(@PathVariable Long idReservation, Date date, StatutReservation statut) {
		reservationService.modifierReservation(Long.valueOf(idReservation), date, statut);
		return "redirect:/reservations";
	}
}
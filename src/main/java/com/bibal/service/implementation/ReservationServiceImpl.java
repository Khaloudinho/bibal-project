package com.bibal.service.implementation;

import java.sql.Date;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import com.bibal.dao.ReservationRepository;
import com.bibal.metier.Oeuvre;
import com.bibal.metier.Reservation;
import com.bibal.service.interfaces.ReservationService;
import com.bibal.util.StatutReservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bibal.dao.ReservationRepository;
import com.bibal.metier.Usager;
import com.bibal.service.interfaces.UsagerService;
import com.bibal.util.EtatUsager;

@Service
@Transactional
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	private ReservationRepository reservationRepository;

	@Override
	public List<Reservation> recupererToutesLesReservations() {
		return reservationRepository.findAll();
	}

	@Override
	public Reservation recupererReservationViaID(Long idReservation) {
		return reservationRepository.findOne(idReservation);
	}

	@Override
	public void ajouterReservation(Date date, Usager usager, Oeuvre oeuvre) {
		Reservation reservation = new Reservation(date, usager, oeuvre);
		reservationRepository.save(reservation);
	}

	@Override
	public Reservation modifierReservation(Long idReservation, Date date, StatutReservation statut) {
		Reservation reservation = recupererReservationViaID(idReservation);
		reservation.setDate(date);
		reservation.setStatut(statut);
		return reservation;
	}

}

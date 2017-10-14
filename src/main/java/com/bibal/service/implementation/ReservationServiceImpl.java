package com.bibal.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

import java.sql.Date;
import java.util.List;

import com.bibal.service.interfaces.ReservationService;
import com.bibal.dao.ReservationRepository;

import com.bibal.util.StatutReservation;
import com.bibal.metier.Oeuvre;
import com.bibal.metier.Reservation;
import com.bibal.metier.Usager;

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

	@Override
	public void archiverReservationSelonEmprunt(Long idEmprunt) {
		Reservation reservation = reservationRepository.getReservationSelonEmprunt(idEmprunt);
		//Permet de modifier le statut de la resevation automatiquement lors de l'emprunt
		if(reservation!=null)
			this.modifierReservation(reservation.getIdReservation(), reservation.getDate(), StatutReservation.Annulée);
	}

}

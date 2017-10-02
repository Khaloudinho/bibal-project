package com.bibal.service.interfaces;

import java.sql.Date;
import java.util.List;

import com.bibal.metier.Oeuvre;
import com.bibal.metier.Reservation;
import com.bibal.metier.Usager;

public interface ReservationService {

	public void ajouterReservation(Date date, Usager usager, Oeuvre oeuvre);
	public List<Reservation> findAll();
	public Reservation getById(Long idUsager);
	public Reservation modifierReservation(Long idReservation, Date date, Usager usager, Oeuvre oeuvre);

}

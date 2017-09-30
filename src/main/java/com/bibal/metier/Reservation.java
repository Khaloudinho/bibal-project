package com.bibal.metier;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.bibal.util.EtatUsager;

@Entity
public class Reservation implements Serializable{

	/**
	 * 
	 */
	//private static final long serialVersionUID = -8071716128487923877L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idReservation;

	@ManyToOne
	@Join


	

	
}

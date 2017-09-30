package com.bibal.metier;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

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
public class Usager implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idUsager;
	private String nom;
	private String prenom;	
	private String adresse;
	private String mail;
	private String tel;
	private int nombreSuspensions;
	private String etat;

	@OneToMany
	@JoinColumn(name="idUsager", referencedColumnName="idUsager")
	private Set<Reservation> listeReservations;

	public Usager() {
	}

	public Usager(String nom, String prenom, String adresse, String mail, String tel, int nombreSuspensions, String etat, Set<Reservation> listeReservations) {
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.mail = mail;
		this.tel = tel;
		this.nombreSuspensions = nombreSuspensions;
		this.etat = etat;
		this.listeReservations = listeReservations;
	}

	public Long getIdUsager() {
		return idUsager;
	}

	public void setIdUsager(Long idUsager) {
		this.idUsager = idUsager;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public int getNombreSuspensions() {
		return nombreSuspensions;
	}

	public void setNombreSuspensions(int nombreSuspensions) {
		this.nombreSuspensions = nombreSuspensions;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public Set<Reservation> getListeReservations() {
		return listeReservations;
	}

	public void setListeReservations(Set<Reservation> listeReservations) {
		this.listeReservations = listeReservations;
	}
}

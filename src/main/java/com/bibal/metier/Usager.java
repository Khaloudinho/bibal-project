package com.bibal.metier;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Usager implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idUsager;
	private String nom;
	private String prenom;	
	private String adresse;
	private String mail;
	private String telephone;

	@OneToMany(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "idUsager")
	private List<Reservation> listeReservations;

	@OneToMany(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "idUsager")
	private List<Emprunt> listeEmprunts;

	public Usager() {
	}
	
	public Usager(String nom, String prenom, String adresse, String mail, String telephone) {
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.telephone = telephone;
		this.adresse = adresse;
	}

	public Long getIdUsager() {
		return idUsager;
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

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	public String getAdresse() {
		return adresse;
	}
	
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public void setIdUsager(Long idUsager) {
		this.idUsager = idUsager;
	}

	public List<Reservation> getListeReservations() {
		return listeReservations;
	}

	public void setListeReservations(List<Reservation> listeReservations) {
		this.listeReservations = listeReservations;
	}

	public List<Emprunt> getListeEmprunts() {
		return listeEmprunts;
	}

	public void setListeEmprunts(List<Emprunt> listeEmprunts) {
		this.listeEmprunts = listeEmprunts;
	}
}

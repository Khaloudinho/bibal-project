package com.bibal.metier;

import com.bibal.util.EtatUsager;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

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
	// private int nombreSuspensions;
	// private String etat;
	
	public Usager() {
		super();
		// etat = EtatUsager.Client.toString();
		// nombreSuspensions = 0;
	}
	
	public Usager(String nom, String prenom, String adresse, String mail, String telephone) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.telephone = telephone;
		this.adresse=adresse;
		// this.etat = EtatUsager.Client.toString();
		// this.nombreSuspensions = 0;
	}
	
	/* public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	} */

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
	
	/* public int getNombreSuspensions() {
		return nombreSuspensions;
	}

	public void setNombreSuspensions(int nombreSuspensions) {
		this.nombreSuspensions = nombreSuspensions;
	}

	public void suspendre(){
		setEtat(EtatUsager.Suspendu.toString());
		incrementNombreSuspensions();
	}
	public void incrementNombreSuspensions(){
		if(nombreSuspensions<2)
			nombreSuspensions++;
		else{
			setEtat(EtatUsager.Desactive.toString());
			nombreSuspensions = 0;
		}
	} */

}

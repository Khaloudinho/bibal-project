package com.bibal.util;

public enum StatutReservation {
    EN_COURS("En cours"), ANNULEE("Annulée"), ARCHIVEE("Archivée");

    private String nom;

    StatutReservation(String nom){
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}

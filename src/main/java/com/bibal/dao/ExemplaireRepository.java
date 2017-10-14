package com.bibal.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bibal.metier.Exemplaire;

/**
 * Repository utilise pour les requetes particulieres relative a l'exemplaire
 */
public interface ExemplaireRepository extends JpaRepository<Exemplaire, Long> {

    @Query(value = "SELECT * FROM exemplaire e WHERE e.id_exemplaire NOT IN (SELECT emp.id_exemplaire FROM emprunt emp) AND etat<>'Périmé'", nativeQuery = true)
    List<Exemplaire> recupererTousLesExemplairesNonEmpruntes();
}

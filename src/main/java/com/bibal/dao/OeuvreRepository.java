package com.bibal.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bibal.metier.Oeuvre;

/**
 * Repository utilise pour les requetes particulieres relative a l'oeuvre
 */
public interface OeuvreRepository extends JpaRepository<Oeuvre, Long> {

    @Query(value = "SELECT * FROM oeuvre where id_oeuvre IN (SELECT id_oeuvre FROM exemplaire) AND id_oeuvre= :idOeuvre ", nativeQuery = true)
    Oeuvre recupererOeuvreSiExemplaires(@Param("idOeuvre") Long id);
}

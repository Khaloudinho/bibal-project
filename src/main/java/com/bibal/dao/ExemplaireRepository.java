package com.bibal.dao;

import com.bibal.metier.Exemplaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ExemplaireRepository extends JpaRepository<Exemplaire, Long> {

    @Query(value = "SELECT * FROM exemplaire e WHERE e.id_exemplaire NOT IN (SELECT emp.id_exemplaire FROM emprunt emp) AND etat<>'Périmé'", nativeQuery = true)
    List<Exemplaire> recupererTousLesExemplairesNonEmpruntes();
}

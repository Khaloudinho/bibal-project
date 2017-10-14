package com.bibal.dao;

import com.bibal.metier.Oeuvre;
import com.bibal.metier.Usager;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface OeuvreRepository extends JpaRepository<Oeuvre, Long> {

    @Query(value = "SELECT * FROM oeuvre where id_oeuvre IN (SELECT id_oeuvre FROM exemplaire) AND id_oeuvre= :idOeuvre ", nativeQuery = true)
    Oeuvre recupererOeuvreSiExemplaires(@Param("idOeuvre") Long id);
}

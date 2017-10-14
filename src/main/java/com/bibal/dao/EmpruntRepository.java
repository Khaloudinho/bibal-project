package com.bibal.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import javax.transaction.Transactional;

import com.bibal.metier.Emprunt;

/**
 * Repository utilise pour les requetes particulieres relative a l'emprunt
 */
public interface EmpruntRepository extends JpaRepository<Emprunt, Long> {

    @Transactional
    @Modifying
    @Query("UPDATE Emprunt SET archive = true WHERE id = :idEmprunt")
    void archiverEmprunt(@Param("idEmprunt")Long id);

    //Doesn't exists ???
    @Query(value = "SELECT * FROM emprunt ORDER BY id_emprunt DESC LIMIT 1", nativeQuery = true)
    Emprunt recupererDernierEmprunt();

}
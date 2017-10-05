package com.bibal.dao;

import com.bibal.metier.Emprunt;
import com.bibal.metier.Usager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmpruntRepository extends JpaRepository<Emprunt, Long> {
    /*@Query("SELECT u FROM Usager u WHERE u.nom LIKE %:x%")
    void archiverEmprunt(@Param("idEmprunt")Long id);*/
}

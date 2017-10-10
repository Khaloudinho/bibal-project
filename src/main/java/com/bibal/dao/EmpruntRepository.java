package com.bibal.dao;

import com.bibal.metier.Emprunt;
import com.bibal.metier.Usager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface EmpruntRepository extends JpaRepository<Emprunt, Long> {

    @Transactional
    @Modifying
    @Query("UPDATE Emprunt SET archive = true WHERE id = :idEmprunt")
    void archiverEmprunt(@Param("idEmprunt")Long id);
}

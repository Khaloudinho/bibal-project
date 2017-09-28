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
	
	@Query("SELECT o FROM Oeuvre o WHERE o.titre LIKE %:x%")
	List<Oeuvre> recupererOeuvreViaTitre(@Param("x") String titre);

	/*
	@Query("SELECT o FROM Oeuvre o WHERE o.idOeuvre LIKE %:id%")
	Oeuvre recupererOeuvreViaID(@Param("id") Long idOeuvre);

	@Query("SELECT o FROM Oeuvre o")
	List<Oeuvre> recupererToutesLesOeuvres();

	@Transactional
	@Modifying
	@Cascade(CascadeType.ALL)
	@Query("DELETE FROM Oeuvre WHERE idOeuvre = :id")
	void supprimerOeuvreViaID(@Param("id") Long id);
	*/
}

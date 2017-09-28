package com.bibal.dao;

import java.util.List;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bibal.metier.Usager;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;

public interface UsagerRepository extends JpaRepository<Usager, Long> {
	
	@Query("select u from Usager u where u.nom like %:x%")
	public List<Usager> searchUsagersByName(@Param("x")String nom);
	
	@Query("select u from Usager u where u.etat like :x")
	public List<Usager> searchUsagersByEtat(@Param("x")String etat);

	@Transactional
	@Modifying
	@Cascade(CascadeType.ALL)
	@Query("DELETE FROM Usager where id_usager = :id")
	public void deleteUsagerById(@Param("id")Long id);

}

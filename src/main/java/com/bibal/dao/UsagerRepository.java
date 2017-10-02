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
	
	@Query("SELECT u FROM Usager u WHERE u.nom LIKE %:x%")
	List<Usager> recupererUsagersViaNom(@Param("x")String nom);
}

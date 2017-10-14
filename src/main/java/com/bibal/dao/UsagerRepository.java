package com.bibal.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bibal.metier.Usager;

/**
 * Repository utilise pour les requetes particulieres relative a l'usager
 */
public interface UsagerRepository extends JpaRepository<Usager, Long> {
}

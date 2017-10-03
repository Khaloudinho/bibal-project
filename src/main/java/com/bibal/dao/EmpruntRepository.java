package com.bibal.dao;

import com.bibal.metier.Emprunt;
import com.bibal.metier.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpruntRepository extends JpaRepository<Emprunt, Long> {

}

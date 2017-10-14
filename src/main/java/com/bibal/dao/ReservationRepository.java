package com.bibal.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bibal.metier.Reservation;

/**
 * Repository utilise pour les requetes particulieres relative a la reservation
 */
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    @Query(value = "SELECT r.* FROM reservation r INNER JOIN oeuvre o ON r.id_oeuvre=o.id_oeuvre INNER JOIN exemplaire e ON e.id_oeuvre=o.id_oeuvre INNER JOIN emprunt emp ON emp.id_exemplaire=e.id_exemplaire WHERE emp.id_emprunt=:idEmprunt", nativeQuery = true)
    Reservation getReservationSelonEmprunt(@Param("idEmprunt") Long idEmprunt);
}

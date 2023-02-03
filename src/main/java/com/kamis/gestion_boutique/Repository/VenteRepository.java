package com.kamis.gestion_boutique.Repository;

import com.kamis.gestion_boutique.Modele.Vente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VenteRepository extends JpaRepository<Vente, Integer> {
}

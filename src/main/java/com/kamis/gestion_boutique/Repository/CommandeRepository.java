package com.kamis.gestion_boutique.Repository;

import com.kamis.gestion_boutique.Modele.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandeRepository extends JpaRepository<Commande, Integer> {
}

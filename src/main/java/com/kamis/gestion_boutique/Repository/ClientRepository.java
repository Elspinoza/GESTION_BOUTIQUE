package com.kamis.gestion_boutique.Repository;

import com.kamis.gestion_boutique.Modele.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
}

package com.kamis.gestion_boutique.Repository;

import com.kamis.gestion_boutique.Modele.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategorieRepository extends JpaRepository<Categorie, Integer> {
}

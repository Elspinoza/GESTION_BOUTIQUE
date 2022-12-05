package com.kamis.gestion_boutique.Modele;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private String Nom;
    private double Prix;
    private int Quantite;

   /* @ManyToMany // association plusieur à plusieur
    @JoinColumn(name = "venteId", insertable = false, updatable = false)

    private Vente vente;
    private int venteId;*/

}

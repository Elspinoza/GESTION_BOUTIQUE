package com.kamis.gestion_boutique.Modele;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Categorie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int Id;
    private String Libelle;

    @ManyToOne
    @JoinColumn(name = "articleId", insertable = false, updatable = false)

    private Article article;
    private int aricleId;
}

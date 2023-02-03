package com.kamis.gestion_boutique.Modele;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    @Column(nullable = false)
    private String Libelle;
    @Column(nullable = false)
    private double Prix;
    @Column(nullable = false)
    private int qteStock;

    @DateTimeFormat(pattern = "yyyy/MM/dd")//format de la date (valable juste en dessous)
    private LocalDate dateCreation;
    private int qteSeuil;

    @Transient
    private String etat;

    @Transient
    private String desi;

    @ManyToOne
    @JoinColumn(name = "categorieId", insertable = false, updatable = false)

    private Categorie categorie;
    private int categorieId;

    //creation de la classe d'association entre article et vente
    @ManyToMany(mappedBy = "articles", fetch = FetchType.LAZY)
    @JsonBackReference
    private Set<Vente> ventes;

    //creaction de la d'association entre commande et article
    @ManyToMany(mappedBy = "articles", fetch = FetchType.LAZY)
    @JsonBackReference
    private Set<Commande>commandes;



}

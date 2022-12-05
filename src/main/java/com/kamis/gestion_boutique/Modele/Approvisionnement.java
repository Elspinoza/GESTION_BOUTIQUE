package com.kamis.gestion_boutique.Modele;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity //declare la classe en tant qu'entité de la base de données
@Data // permettant de savoir que c'est une donnée
@NoArgsConstructor
@AllArgsConstructor

public class Approvisionnement {


    @Id //fonction permettant la création de l'id dans la bdd
    @GeneratedValue(strategy = GenerationType.IDENTITY) //fonction permettant l'ncrementation de l'id

    private int Id; //déclaration de l'attribut id de la classe
    private String Libelle; //déclaration de l'attribut libelle de la classe
    private int Quantite; //déclaration de l'attribut quantite de la classe

    @DateTimeFormat(pattern = "yyyy/MM/dd") //fonction permettant la mise en forme de la date

    private LocalDate Date_Appro; //declaration de l'attribut date de la classe

    //@ManyToOne // Pour une approvisionnement j'ai beaucoup d'article






}

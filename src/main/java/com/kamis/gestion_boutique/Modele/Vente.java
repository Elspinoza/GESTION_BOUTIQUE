package com.kamis.gestion_boutique.Modele;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Vente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int Id;
    private String Designation_Vente;
    private int Quantite_Vente;

    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate Date_Vente;

    /*@ManyToMany
    @JoinColumn(name = "articleId", insertable = false, updatable = false)

    private Article article;
    private int articleId;*/
}

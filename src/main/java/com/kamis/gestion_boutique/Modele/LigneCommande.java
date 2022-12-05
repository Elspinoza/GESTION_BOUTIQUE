package com.kamis.gestion_boutique.Modele;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class LigneCommande {

    private int nbArticle;
    private double prix;

    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate date;
}

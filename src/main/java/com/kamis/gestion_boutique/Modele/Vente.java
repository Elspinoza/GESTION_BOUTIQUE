package com.kamis.gestion_boutique.Modele;

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

public class Vente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int Id;
    @Column(nullable = false)
    private String Designation_Vente;
    @Column(nullable = false)
    private int Quantite_Vente;

    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate Date_Vente;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)

    @JoinTable(name = "Facture",

            joinColumns = {
                    @JoinColumn(name = "vente_id", referencedColumnName = "id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "article_id", referencedColumnName = "id")
            }
    )
    @JsonManagedReference
    private Set<Article> articles;
}

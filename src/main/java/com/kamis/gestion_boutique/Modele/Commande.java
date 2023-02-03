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

public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;

    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "clientId", insertable = false, updatable = false)

    private Client client;
    private int clientId;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "Ligne_Commande",
            joinColumns = {
                    @JoinColumn(name = "commande_id", referencedColumnName = "id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "article_id", referencedColumnName = "id")
            }
    )
    @JsonManagedReference
    private Set<Article> articles;
}

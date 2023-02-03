package com.kamis.gestion_boutique.Modele;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Client extends User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    @Column(nullable = false)
    private String nom;
    @Column(nullable = false)
    private String prenom;
    @Column(nullable = false)
    private String adresse;
  /*  @Column(nullable = false)
    private String telephone;
*/
}

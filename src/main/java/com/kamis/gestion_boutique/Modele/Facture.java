package com.kamis.gestion_boutique.Modele;

import com.sun.xml.bind.v2.schemagen.xmlschema.Particle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Facture{

    private int num_fact;

    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate date_fact;

}

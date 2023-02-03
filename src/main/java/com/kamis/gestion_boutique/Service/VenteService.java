package com.kamis.gestion_boutique.Service;

import com.kamis.gestion_boutique.Modele.Vente;
import com.kamis.gestion_boutique.Repository.VenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VenteService {

    @Autowired
    VenteRepository venteRepository;

    public void saveVente(Vente vente){
        venteRepository.save(vente);
    }

    public List<Vente> showAllVente(){
        return venteRepository.findAll();
    }

    public Vente showOneVente(int id){
        return venteRepository.findById(id).get();
    }

    public void deleteVente(int id){
        venteRepository.deleteById(id);
    }
}

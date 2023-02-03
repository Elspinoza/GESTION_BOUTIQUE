package com.kamis.gestion_boutique.Service;

import com.kamis.gestion_boutique.Modele.Client;
import com.kamis.gestion_boutique.Modele.Commande;
import com.kamis.gestion_boutique.Repository.ClientRepository;
import com.kamis.gestion_boutique.Repository.CommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommandeService {

    @Autowired
    private CommandeRepository commandeRepository;

    public void saveCommande(Commande commande){
        commandeRepository.save(commande);
    }

    public List<Commande> showAllCommande(){
        return commandeRepository.findAll();
    }

    public Commande showOneCommande(int id){
        return commandeRepository.findById(id).get();
    }

    public void deleteCommande(int id){
        commandeRepository.deleteById(id);
    }

}

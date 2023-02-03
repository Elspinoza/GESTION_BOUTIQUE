package com.kamis.gestion_boutique.Service;

import com.kamis.gestion_boutique.Modele.Client;
import com.kamis.gestion_boutique.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.AbstractPersistable_;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public void saveClient(Client client){
        clientRepository.save(client);
    }

    public List<Client> showAllClient(){
        return clientRepository.findAll();
    }

    public Client showOneClient(int id){
        return clientRepository.findById(id).get();
    }

    public void deleteClient(int id){
        clientRepository.deleteById(id);
    }
}

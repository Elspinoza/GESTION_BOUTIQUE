package com.kamis.gestion_boutique.Service;

import com.kamis.gestion_boutique.Modele.Approvisionnement;
import com.kamis.gestion_boutique.Repository.ApprovisionnementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApprovisionnementService {

    @Autowired
    ApprovisionnementRepository approvisionnementRepository;

    public void saveApprovisionnement(Approvisionnement approvisionnement){
        approvisionnementRepository.save(approvisionnement);
    }

    public List<Approvisionnement> showAllApprovisionnement(){
        return approvisionnementRepository.findAll();
    }

    public Approvisionnement showOneApprovisionnement(int id){
        return approvisionnementRepository.findById(id).get();
    }
    public void deleteApprovisionnement(int id){
        approvisionnementRepository.deleteById(id);
    }
}

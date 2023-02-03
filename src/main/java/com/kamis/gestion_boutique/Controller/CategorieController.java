package com.kamis.gestion_boutique.Controller;

import com.kamis.gestion_boutique.Modele.Categorie;
import com.kamis.gestion_boutique.Service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CategorieController {
    @Autowired
    private CategorieService categorieService;
    @GetMapping("/categorieShow")
    public String showAllCategories(Model model){
        model.addAttribute("listeCategorie",categorieService.showAllCategorie());
        //pas obligé d'avoir le mm nom que le return
        return "design/ListeCategories";
    }
    @GetMapping("/categorieForm")
    public String showFormCategorie(){
        return "design/categorieForm";
    }
    @PostMapping("/categorie/save")
    public String saveCategorie(Categorie categorie){
        categorieService.saveCategorie(categorie);
        return "redirect:/categorieShow";
    }

}

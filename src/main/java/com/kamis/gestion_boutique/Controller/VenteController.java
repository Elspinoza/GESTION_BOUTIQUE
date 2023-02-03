package com.kamis.gestion_boutique.Controller;

import com.kamis.gestion_boutique.Modele.Vente;
import com.kamis.gestion_boutique.Service.ArticleService;
import com.kamis.gestion_boutique.Service.VenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;

@Controller
public class VenteController {

    @Autowired
    private VenteService venteService;
    @Autowired
    private ArticleService articleService;

    @GetMapping("/venteShow")
    public String showAllVente(Model model){
        //model.addAttribute("listeVente",venteService.showAllVente());
        //pas obligé d'avoir le mm nom que le return
        return "design/ListeVente";
    }
    @GetMapping("/venteForm")
    public String ShowFormVente(Model model){
       // model.addAttribute("listeVente",articleService.showAllArticle());
        return "design/venteForm";
    }
    @PostMapping("/vente/save")
    public String saveVente(Vente vente){
        vente.setQuantite_Vente(vente.getQuantite_Vente());
        vente.setDate_Vente(LocalDate.now());
        venteService.saveVente(vente);
        return "redirect:/venteShow";
    }
    @GetMapping("/venteEdit{id}")
    public String venteEdit(@PathVariable("id") int id, Model model){
        //model.addAttribute("Une_vente",venteService.showOneVente(id));
        //model.addAttribute("listeVente",articleService.showAllArticle());
        return "vente/venteEdit";
    }
    @PostMapping("vente/update")
    public  String updateVente(@ModelAttribute("vente") Vente vente){
        venteService.saveVente(vente);
        return "redirect:/venteShow";

    }
    @GetMapping("/vente/delete/{id}")
    public String deleteVente(@PathVariable("id") int id){
        venteService.deleteVente(id);
        return "redirect:/venteShow";

    }

}

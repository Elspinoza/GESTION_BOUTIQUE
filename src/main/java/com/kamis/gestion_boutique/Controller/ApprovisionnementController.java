package com.kamis.gestion_boutique.Controller;

import com.kamis.gestion_boutique.Modele.Approvisionnement;
import com.kamis.gestion_boutique.Service.ApprovisionnementService;
import com.kamis.gestion_boutique.Service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;

@Controller
public class ApprovisionnementController {

    @Autowired
    private ApprovisionnementService approvisionnementService;

    @Autowired
    private ArticleService articleService;

    @GetMapping("/approShow")
    public String showAllApprovisionnement(Model model){
        model.addAttribute("listeAppro",approvisionnementService.showAllApprovisionnement());
        //pas obligé d'avoir le mm nom que le return
        return "design/ListeAppro";
    }
    @GetMapping("/approForm")
    public String ShowFormApprovisionnement(Model model){
        model.addAttribute("listeAppro",articleService.showAllArticle());
        return "design/approForm";
    }
    @PostMapping("/appro/save")
    public String saveApprovisionnement(Approvisionnement approvisionnement){
        approvisionnement.setQteAppro(approvisionnement.getQteAppro());
        approvisionnement.setDate_Appro(LocalDate.now());
        approvisionnementService.saveApprovisionnement(approvisionnement);
        articleService.updateStockArticle(approvisionnement.getQteAppro(),approvisionnement.getArticleId());
        return "redirect:/approShow";
    }
    @GetMapping("/approEdit{id}")
    public String approEdit(@PathVariable("id") int id, Model model){
        model.addAttribute("Un_approvisionnement",approvisionnementService.showOneApprovisionnement(id));
        model.addAttribute("listeAppro",articleService.showAllArticle());
        return "appro/approEdit";
    }
    @PostMapping("appro/update")
    public  String updateAppro(@ModelAttribute("approvisionnement") Approvisionnement approvisionnement){
        approvisionnementService.saveApprovisionnement(approvisionnement);
        return "redirect:/approShow";

    }
    @GetMapping("/appro/delete/{id}")
    public String deleteAppro(@PathVariable("id") int id){
        approvisionnementService.deleteApprovisionnement(id);
        return "redirect:/approShow";

    }

}

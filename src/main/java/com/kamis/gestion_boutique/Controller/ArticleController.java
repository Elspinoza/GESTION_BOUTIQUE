package com.kamis.gestion_boutique.Controller;

import com.kamis.gestion_boutique.Modele.Article;
import com.kamis.gestion_boutique.Service.ArticleService;
import com.kamis.gestion_boutique.Service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
public class ArticleController {

    @Autowired
    private CategorieService categorieService;
    @Autowired
    private ArticleService articleService;
    @GetMapping("/articleShow")
    public String showAllArticles(Model model){
        model.addAttribute("listeArticle",articleService.changerEtatArticle( articleService.showAllArticle()));
        //pas obligé d'avoir le mm nom que le return
        return "design/listesArticles";
    }
    @GetMapping("/articleForm")
    public String ShowFormArticle(Model model){
        model.addAttribute("listeCategorie",categorieService.showAllCategorie());
        return "design/articleForm";
    }
    @PostMapping("/articles/save")
    public String saveArticle(Article article){
        article.setQteStock(0);
        article.setDateCreation(LocalDate.now());
        articleService.saveArticle(article);
        return "redirect:/articleShow";
    }
    @GetMapping("/articleEdit{id}")
    public String formEdit(@PathVariable("id") int id, Model model){
        model.addAttribute("Un_article",articleService.showOneArticle(id));
        model.addAttribute("listeCategorie",categorieService.showAllCategorie());
        return "design/formEdit";
    }
    @PostMapping("/article/update")
    public  String updateArticle(@ModelAttribute("article") Article article){
        articleService.saveArticle(article);
        return "redirect:/articleShow";

    }
    @GetMapping("/article/delete/{id}")
    public String deleteArticle(@PathVariable("id") int id){
        articleService.deleteArticle(id);
        return "redirect:/articleShow";

    }
    @GetMapping("/articlesEtatSeuil")
    public String listeSeuil(Model model){
        model.addAttribute("listeSeuil",articleService.articleEtatCritique(articleService.showAllArticle()));
        return "design/listeSeuil";
    }

    //FONCTION DE RECHERCHE D'UN ARTICLE
    @GetMapping("/name")
    public String Liste(Model model, @RequestParam String Libelle){
        model.addAttribute("listeByNamer", articleService.findByLibelle(Libelle));
        return "/design/ListeName";
    }

    @PostMapping("/article/nom")
    public String listeByName(@RequestParam String desi){
        articleService.findByLibelle(desi);
        return "redirect:/name";
    }


}

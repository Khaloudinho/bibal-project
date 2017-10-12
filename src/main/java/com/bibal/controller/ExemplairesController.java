package com.bibal.controller;

import com.bibal.metier.Exemplaire;
import com.bibal.metier.Oeuvre;
import com.bibal.service.interfaces.ExemplaireService;
import com.bibal.service.interfaces.OeuvreService;
import com.bibal.util.EtatExemplaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Configuration
@Controller
@EnableAutoConfiguration
@ComponentScan
public class ExemplairesController {

    @Autowired
    private ExemplaireService exemplaireService;

    @Autowired
    private OeuvreService oeuvreService;

    /*
    * On récupère tous les exemplaires via le service exemplaire que l'on affiche sur la page exemplaires.html
    * */
    @GetMapping(value = "exemplaires")
    public String recupererTousLesExemplaires(Model model) {
        List<Exemplaire> exemplaires = exemplaireService.recupererTousLesExemplaires();
        model.addAttribute("exemplaires", exemplaires);
        return "exemplaires";
    }

    /*
    * On récupère le formulaire d'ajout d'un exemplaire, on récupère les oeuvres afin que l'utiliser
    * puisse créer l'exemplaire sur l'oeuvre de son choix et on retourne le formulaire formAjouterExemplaire.html
    * */
    @GetMapping(value = "exemplaires/create")
    public String getFormAjouterExemplaire(Model model) {
        List<Oeuvre> oeuvres = oeuvreService.recupererToutesLesOeuvres();
        model.addAttribute("oeuvres", oeuvres);
        return "formAjouterExemplaire";
    }

    /*
    * On récupère les informations de l'exemplaire que nous allons modifier via l'ID,
    * puis on retourne le formulaire formModifierExemplaire.html avec les informations pré-remplies
    * */
    @GetMapping(value = "exemplaires/{idExemplaire}/edit")
    public String getFormModifierExemplaire(@PathVariable Long idExemplaire, Model model) {
        Exemplaire exemplaire = exemplaireService.recupererExemplaireViaID(idExemplaire);
        model.addAttribute("exemplaire", exemplaire);
        return "formModifierExemplaire";
    }

    /*
    * On ajoute un exemplaire en lui passant une oeuvre existante, et un état parmi l'énumération créée à cet effet
    * */
    @PostMapping(value = "exemplaires")
    public String ajouterExemplaire(Long idOeuvre, EtatExemplaire etat) {
        exemplaireService.ajouterExemplaire(idOeuvre, etat);
        return "redirect:/exemplaires";
    }

    /*
    * On modifie uniquement l'état d'un exemplaire, donc on le récupère dans un premier temps via l'ID
    * puis on modifie l'état de l'exemplaire
    * */
    @PutMapping(value = "exemplaires/{idExemplaire}")
    public String modifierExemplaire(@PathVariable String idExemplaire, EtatExemplaire etat) {
        exemplaireService.modifierExemplaire(Long.valueOf(idExemplaire), etat);
        return "redirect:/exemplaires";
    }

    /*
    * On supprime l'exemplaire via cette fonction, pour ce faire on utilise son ID pour identifier l'exemplaire à supprimer
    * */
    @DeleteMapping(value = "exemplaires/{idExemplaire}")
    public String supprimerExemplaire(@PathVariable Long idExemplaire) {
        exemplaireService.supprimerExemplaire(idExemplaire);
        return "redirect:/exemplaires";
    }
}

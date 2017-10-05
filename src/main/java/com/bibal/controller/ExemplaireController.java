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
public class ExemplaireController {

    @Autowired
    private ExemplaireService exemplaireService;

    @Autowired
    private OeuvreService oeuvreService;

    @GetMapping(value = "exemplaires")
    public String recupererTousLesExemplaires(Model model) {
        List<Exemplaire> exemplaires = exemplaireService.recupererTousLesExemplaires();
        model.addAttribute("exemplaires", exemplaires);
        return "exemplaires";
    }

    @GetMapping(value = "exemplaires/create")
    public String getFormAjouterExemplaire(Model model) {
        List<Oeuvre> oeuvres = oeuvreService.recupererToutesLesOeuvres();
        model.addAttribute("oeuvres", oeuvres);
        return "formAjouterExemplaire";
    }

    @GetMapping(value = "exemplaires/{idExemplaire}/edit")
    public String getFormModifierExemplaire(@PathVariable Long idExemplaire, Model model) {
        Exemplaire exemplaire = exemplaireService.recupererExemplaireViaID(idExemplaire);
        model.addAttribute("exemplaire", exemplaire);
        return "formModifierExemplaire";
    }

    @PostMapping(value = "exemplaires")
    public String ajouterExemplaire(Long idOeuvre, EtatExemplaire etat) {
        exemplaireService.ajouterExemplaire(idOeuvre, etat);
        return "redirect:/exemplaires";
    }

    @PutMapping(value = "exemplaires/{idExemplaire}")
    public String modifierExemplaire(@PathVariable String idExemplaire, EtatExemplaire etat) {
        exemplaireService.modifierExemplaire(Long.valueOf(idExemplaire), etat);
        return "redirect:/exemplaires";
    }

    @DeleteMapping(value = "exemplaires/{idExemplaire}")
    public String supprimerExemplaire(@PathVariable Long idExemplaire) {
        exemplaireService.supprimerExemplaire(idExemplaire);
        return "redirect:/exemplaires";
    }
}

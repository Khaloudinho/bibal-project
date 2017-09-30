package com.bibal.controller;

import com.bibal.metier.Exemplaire;
import com.bibal.service.interfaces.ExemplaireService;
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

    @GetMapping(value = "/exemplaires")
    public String recupererTousLesExemplaires(Model model) {
        List<Exemplaire> exemplaires = exemplaireService.recupererTousLesExemplaires();
        model.addAttribute("exemplaires", exemplaires);
        return "exemplaires";
    }

    @GetMapping(value = "/getFormAjouterExemplaire")
    public String getFormAjouterExemplaire() {
        return "formAjouterExemplaire";
    }

    @GetMapping(value = "/getFormModifierExemplaire/{id}")
    public String getFormModifierExemplaire(@PathVariable(value = "id") Long idExemplaire, Model model) {
        Exemplaire exemplaire = exemplaireService.recupererExemplaireViaID(idExemplaire);
        model.addAttribute("exemplaire", exemplaire);
        return "formModifierExemplaire";
    }

    @PostMapping(value = "/ajouterExemplaire")
    public String ajouterExemplaire(@RequestParam("id") Long idOeuvre) {
        exemplaireService.ajouterExemplaire(idOeuvre);
        return "redirect:exemplaires";
    }

    @PutMapping(value = "/modifierExemplaire/{id}/edit")
    public String modifierExemplaire(@RequestParam("id") String idExemplaire, EtatExemplaire etat) {
        exemplaireService.modifierExemplaire(Long.valueOf(idExemplaire), etat);
        return "redirect:exemplaires";
    }

    @DeleteMapping(value = "/supprimerExemplaire/{id}/delete")
    public String supprimerExemplaire(@RequestParam("id") Long idExemplaire) {
        exemplaireService.supprimerExemplaire(idExemplaire);
        return "redirect:exemplaires";
    }
}

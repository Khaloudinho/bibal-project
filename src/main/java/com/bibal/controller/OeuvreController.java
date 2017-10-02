package com.bibal.controller;

import com.bibal.metier.Oeuvre;
import com.bibal.service.interfaces.OeuvreService;
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
public class OeuvreController {

    @Autowired
    private OeuvreService oeuvreService;

    @GetMapping(value = "oeuvres")
    public String recupererToutesLesOeuvres(Model model) {
        List<Oeuvre> oeuvres = oeuvreService.recupererToutesLesOeuvres();
        model.addAttribute("oeuvres", oeuvres);
        return "oeuvres";
    }

    @GetMapping(value = "oeuvres/{titre}")
    public String recupererOeuvresViaTitre(@PathVariable String titre, Model model) {
        List<Oeuvre> oeuvres = oeuvreService.recupererOeuvresViaTitre(titre);
        model.addAttribute("oeuvres", oeuvres);
        return "oeuvres";
    }

    @GetMapping(value = "oeuvres/create")
    public String getFormAjouterOeuvre() {
        return "formAjouterOeuvre";
    }

    @GetMapping(value = "oeuvres/{idOeuvre}/edit")
    public String getFormModifierOeuvre(@PathVariable Long idOeuvre, Model model) {
        Oeuvre oeuvre = oeuvreService.recupererOeuvreViaID(idOeuvre);
        model.addAttribute("oeuvre", oeuvre);
        return "formModifierOeuvre";
    }

    @PostMapping(value = "oeuvres")
    public String ajouterOeuvre(String titre, String auteur, String genre) {
        oeuvreService.ajouterOeuvre(titre, auteur, genre);
        return "redirect:/oeuvres";
    }

    @PutMapping(value = "oeuvres/{idOeuvre}")
    public String modifierOeuvre(@PathVariable String idOeuvre, String titre, String auteur, String genre) {
        oeuvreService.modifierOeuvre(Long.valueOf(idOeuvre), titre, auteur, genre);
        return "redirect:/oeuvres";
    }

    @DeleteMapping(value = "oeuvres/{idOeuvre}")
    public String supprimerOeuvre(@PathVariable Long idOeuvre) {
        oeuvreService.supprimerOeuvre(idOeuvre);
        return "redirect:/oeuvres";
    }
}

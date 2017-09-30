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

    @GetMapping(value = "/oeuvres")
    public String recupererToutesLesOeuvres(Model model) {
        List<Oeuvre> oeuvres = oeuvreService.recupererToutesLesOeuvres();
        model.addAttribute("oeuvres", oeuvres);
        return "oeuvres";
    }

    @GetMapping(value = "/oeuvre/{titre}")
    public String recupererOeuvreViaTitre(@RequestParam("titre") String titre, Model model) {
        List<Oeuvre> oeuvres = oeuvreService.recupererOeuvreViaTitre(titre);
        model.addAttribute("oeuvres", oeuvres);
        return "oeuvres";
    }

    @GetMapping(value = "/getFormAjouterOeuvre")
    public String getFormAjouterOeuvre() {
        return "formAjouterOeuvre";
    }

    @GetMapping(value = "/getFormModifierOeuvre/{id}")
    public String getFormModifierOeuvre(@PathVariable(value = "id") Long idOeuvre, Model model) {
        Oeuvre oeuvre = oeuvreService.recupererOeuvreViaID(idOeuvre);
        model.addAttribute("oeuvre", oeuvre);
        return "formModifierOeuvre";
    }

    @PostMapping(value = "/ajouterOeuvre")
    public String ajouterOeuvre(@RequestParam("titre") String titre, @RequestParam("auteur") String auteur, @RequestParam("genre") String genre) {
        oeuvreService.ajouterOeuvre(titre, auteur, genre);
        return "redirect:oeuvres";
    }

    @PutMapping(value = "/modifierOeuvre/{id}/edit")
    public String modifierOeuvre(@RequestParam("id") String idOeuvre, @RequestParam("titre") String titre, @RequestParam("auteur") String auteur, @RequestParam("genre") String genre) {
        oeuvreService.modifierOeuvre(Long.valueOf(idOeuvre), titre, auteur, genre);
        return "redirect:oeuvres";
    }

    @DeleteMapping(value = "/supprimerOeuvre/{id}/delete")
    public String supprimerOeuvre(@RequestParam("id") Long idOeuvre) {
        oeuvreService.supprimerOeuvre(idOeuvre);
        return "redirect:oeuvres";
    }
}

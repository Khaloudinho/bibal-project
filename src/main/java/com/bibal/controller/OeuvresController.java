package com.bibal.controller;

import com.bibal.metier.Oeuvre;
import com.bibal.service.interfaces.OeuvreService;
import com.bibal.util.TypeOeuvre;
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
public class OeuvresController {

    @Autowired
    private OeuvreService oeuvreService;

    /*
    * On affiche toutes les oeuvres et leurs propriétés dans la vue oeuvres.html
    * */
    @GetMapping(value = "oeuvres")
    public String recupererToutesLesOeuvres(Model model) {
        List<Oeuvre> oeuvres = oeuvreService.recupererToutesLesOeuvres();
        model.addAttribute("oeuvres", oeuvres);
        return "oeuvres";
    }

    /*
    * On retourne simplement le formulaire pour ajouter une oeuvre
    * */
    @GetMapping(value = "oeuvres/create")
    public String getFormAjouterOeuvre() {
        return "formAjouterOeuvre";
    }

    /*
    * On récupère l'oeuvre à travers son ID, et on retourne le formulaire de modification avec
    * les propriétés actuelles de l'oeuvre que l'on peut modifier
    * */
    @GetMapping(value = "oeuvres/{idOeuvre}/edit")
    public String getFormModifierOeuvre(@PathVariable Long idOeuvre, Model model) {
        Oeuvre oeuvre = oeuvreService.recupererOeuvreViaID(idOeuvre);
        model.addAttribute("oeuvre", oeuvre);
        return "formModifierOeuvre";
    }

    /*
    * On ajoute une oeuvre avec un titre, auteur, type via la méthode adéquate du service
    * on fait une redirection sur la page affichant les oeuvres
    * */
    @PostMapping(value = "oeuvres")
    public String ajouterOeuvre(String titre, String auteur, TypeOeuvre type) {
        oeuvreService.ajouterOeuvre(titre, auteur, type);
        return "redirect:/oeuvres";
    }

    /*
    * On modifie une oeuvre après l'avoir récupérer via son ID,
    * puis on modifie ses propriétés et on redirige vers la page oeuvres.html
    * */
    @PutMapping(value = "oeuvres/{idOeuvre}")
    public String modifierOeuvre(@PathVariable String idOeuvre, String titre, String auteur, TypeOeuvre type) {
        oeuvreService.modifierOeuvre(Long.valueOf(idOeuvre), titre, auteur, type);
        return "redirect:/oeuvres";
    }

    /*
    * On supprime une oeuvre via son ID, action lancée depuis le bouton Supprimer de la page oeuvres.html
    * */
    @DeleteMapping(value = "oeuvres/{idOeuvre}")
    public String supprimerOeuvre(@PathVariable Long idOeuvre) {
        oeuvreService.supprimerOeuvre(idOeuvre);
        return "redirect:/oeuvres";
    }
}

package com.bibal.controller;

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
public class IndexController {

	/*
	* Méthode chargeant la page d'accueil du projet "Bibal"
	* */
	@GetMapping(value = {"/accueil", "/"})
	public String afficherPageAccueil(Model model) {
		return "index";
	}

}

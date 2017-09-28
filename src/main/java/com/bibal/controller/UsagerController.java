package com.bibal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bibal.metier.Usager;
import com.bibal.service.interfaces.UsagerService;

@Configuration
@Controller
@EnableAutoConfiguration
@ComponentScan
public class UsagerController {

	@Autowired
	private UsagerService usagerService;

	@RequestMapping("/usagers")
	public String ListeUsagers(Model model) {
		List<Usager> usagers = usagerService.findAll();
		model.addAttribute("allUsagers", usagers);
		return "usagers";
	}

	@RequestMapping(value = "/addUsagerForm", method = RequestMethod.GET)
	public String getFormCreationUsager() {
		return "createUserForm";
	}

	@RequestMapping(value = "/addUsager", method = RequestMethod.POST)
	public String ajouterUsager(@RequestParam("prenom") String prenom, @RequestParam("nom") String nom,
			@RequestParam("adresse") String adresse, @RequestParam("mail") String mail,
			@RequestParam("tel") String tel) {
		usagerService.addUsager(nom, prenom, adresse, mail, tel);
		return "redirect:usagers";
	}

	@RequestMapping(value = "/updateUsagerForm", method = RequestMethod.GET)
	public String getFormUpdateUsager(Long idUsager, Model model) {
		Usager usager = usagerService.getById(idUsager);
		model.addAttribute("usager", usager);
		return "updateUserForm";
	}

	@RequestMapping(value = "/usager", method = RequestMethod.PUT)
	public String updateUsager(@RequestParam("id") String id, @RequestParam("prenom") String prenom,
			@RequestParam("nom") String nom, @RequestParam("adresse") String adresse,
			@RequestParam("mail") String mail, @RequestParam("tel") String tel) {
		usagerService.update(Long.valueOf(id), nom, prenom, adresse, tel, mail);
		return "redirect:usagers";
	}

	@RequestMapping(value = "/usager", method = RequestMethod.DELETE)
	public String deleteUsager(Long idUsager) {
		usagerService.supprimmerUsager(idUsager);
		return "redirect:usagers";
	}

	@RequestMapping(value = "/searchUsagerByName", method = RequestMethod.GET)
	public String searchUsagerByName(@RequestParam("nom") String nom, Model model) {
		List<Usager> usagers = usagerService.searchByName(nom);
		model.addAttribute("usagers", usagers);
		return "ListeUsagers";
	}

	@RequestMapping("/searchUsager")
	public String SearchUsager(Model model) {
		model.addAttribute("usagers", null);
		return "ListeUsagers";
	}

	@RequestMapping("/allUsagers")
	public String allUsagers(Model model) {
		List<Usager> usagers = usagerService.findAll();
		model.addAttribute("allUsagers", usagers);
		return "ListeUsagers";
	}
	
	@GetMapping("/activer")
	public String activer(Long idUsager) {
		usagerService.activer(idUsager);
		return "redirect:/ListeUsagers";
	}

}

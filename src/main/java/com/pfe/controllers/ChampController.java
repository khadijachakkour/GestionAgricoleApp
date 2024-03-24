package com.pfe.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.pfe.Service.ChampService;
import com.pfe.Service.IngenieurService;
import com.pfe.Service.TechnicienService;
import com.pfe.entities.Champ;
import com.pfe.entities.Ingenieur;
import com.pfe.entities.Technicien;

import jakarta.servlet.http.HttpSession;

@Controller
public class ChampController {
	
	//Ingenieur
	
	@Autowired
	private ChampService champService;
	
	@Autowired
	private IngenieurService ingenieurService;
	
	@Autowired
	private TechnicienService technicienService;
	
	@GetMapping("/ajouter")
	public String AjouterChamp(Model model)
	{
		
		return"/Ingenieur/ajouter";
	}
	@PostMapping("/champs")
	public String creerChamps(@ModelAttribute Champ champ,HttpSession session)
	{
		 Ingenieur ingenieurConnecte=(Ingenieur) session.getAttribute("ingenieurConnecte");
		champ.setIngenieur(ingenieurConnecte);
		champService.saveChamp(champ);
		
		return"redirect:/afficher";
	}
	
	
	
	@GetMapping("/afficher")
	public String afficherChamp(Model model,HttpSession session) {
		
	    Integer idIng = (Integer) session.getAttribute("idIng");

	    Ingenieur ingenieurConnect = ingenieurService.getIngenieurById(idIng);
	    List<Champ> champs = champService.getAllChampByIngenieur(ingenieurConnect);
	    model.addAttribute("champs", champs);
	    return "Ingenieur/afficher.html";
	}
	
	
	@GetMapping("/champs/{id}/edit")
	public String showEditForm(@PathVariable Integer id, Model model) {
	    Champ champ = champService.getChampById(id);
	    model.addAttribute("champ", champ);
	    
	    return "Ingenieur/edit-form"; 
	}
	
	@PostMapping("/champs/{id}/edit")
	public String processEditForm(@ModelAttribute Champ champ) {
	    champService.updateChamp(champ);
	    
	    return "redirect:/afficher";
	}
	
	@GetMapping("/champs/{id}/delete")
	public String showDeleteForm(@PathVariable Integer id) {
	   champService.deleteChampById(id);
	    
	    return "redirect:/afficher"; 
	}
	
	
	
	//Technicien
	@GetMapping("/Tafficher")
	public String afficher(Model model,HttpSession session)
	{  
		Integer idTech = (Integer) session.getAttribute("idTech");

	    Technicien technicienconnecte = technicienService.getTechnicientById(idTech);
	    Ingenieur idIng =technicienconnecte.getIngenieur();
	        	
	    List<Champ> champs = champService.getAllChampByIngenieur(idIng);
	    model.addAttribute("champs", champs);
	    return "Technicien/afficher.html";

	}
	
	
	
	
	
	
}

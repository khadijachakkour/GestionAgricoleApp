package com.pfe.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.pfe.Service.IngenieurService;
import com.pfe.Service.RapportService;
import com.pfe.entities.Ingenieur;
import com.pfe.entities.Rapport;

import jakarta.servlet.http.HttpSession;

@Controller
public class RapportController {
	
	//Ingenieur
    @Autowired
    private RapportService rapportService;
    
    @Autowired
    private IngenieurService ingenieurService;
    
    
    @GetMapping("/afficherRapport.html")
	public String listRapport(Model model,HttpSession session) {
	    Integer idIng = (Integer) session.getAttribute("idIng");

	    Ingenieur ingenieurConnecte = ingenieurService.getIngenieurById(idIng);
	    List<Rapport> rapports = rapportService.getAllRapportByIngenieur(ingenieurConnecte);
	    model.addAttribute("rapports", rapports);
	    return "Ingenieur/afficherRapport.html";
	}


    @GetMapping("/creerRapport")
    public String afficherFormulaireCreationRapport(Model model) {
		
        model.addAttribute("rapport", new Rapport());
        return "Ingenieur/creerRapport";
    }

    @PostMapping("/creer")
    public String creerRapport(@ModelAttribute Rapport rapport,HttpSession session) {
		 Ingenieur ingenieurConnecte=(Ingenieur) session.getAttribute("ingenieurConnecte");
             rapport.setIngenieur(ingenieurConnecte);
        rapportService.saveRapport(rapport);
        return "redirect:/afficherRapport.html";
    }
    
  	@GetMapping("/rapports/{id}/edit")
  	public String showEditRapport(@PathVariable Integer id, Model model) {
  	    Rapport rapport = rapportService.getRapportById(id);
  	    model.addAttribute("rapport", rapport);
  	    
  	    return "Ingenieur/edit-rapport"; // Le nom de la vue Thymeleaf pour le formulaire d'édition
  	}
  	
  	@PostMapping("/rapports/{id}/edit")
  	public String processEditRapport(@ModelAttribute Rapport rapport) {
  	    rapportService.updateRapport(rapport);
  	    
        return "redirect:/afficherRapport.html";
  	}
  	
  	@GetMapping("/rapports/{id}/delete")
  	public String showDeleteRapport(@PathVariable Integer id) {
  	   rapportService.deleteRapportById(id);
  	    
       return "redirect:/afficherRapport.html";
  	}
    
    
}


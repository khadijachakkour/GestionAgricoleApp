package com.pfe.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.pfe.Service.TechnicienService;
import com.pfe.entities.Technicien;

import jakarta.servlet.http.HttpSession;

@Controller
public class TechnicienController {
	
	@Autowired
	private TechnicienService technicienService;
	
	@GetMapping("/LoginTech")
	public String LoginTech()
	{
		return "Technicien/LoginTech.html";
	}

	
	@PostMapping("/Tech")
	public String Ing(@ModelAttribute Technicien technicien,HttpSession session,Model model) {
		
		boolean f = technicienService.isValidCredentials(technicien.getEmail(),technicien.getPassword());
		
		

		if (f) {
			
			Technicien technicienconnecte = technicienService.getTechnicienByEmail(technicien.getEmail());
	        session.setAttribute("idTech", technicienconnecte.getIdTech());

			return "Technicien/Menu.html";

			
		}   
		
		else
		{
			model.addAttribute("errorMessage", "Mot de passe ou email incorrect");
			return "Technicien/LoginTech.html";
		}

}
	@GetMapping("/MenuT")
	public String Acceuil()
	{
		return"Technicien/Menu.html";
	}
	
	
	@GetMapping("/ProfileTech")
	public String profile(HttpSession session, Model model) {
	    Integer idTech = (Integer) session.getAttribute("idTech");

	    Technicien technicienconnecte = technicienService.getTechnicientById(idTech);

	    String nom = technicienconnecte.getNom();
	    String prenom = technicienconnecte.getPrenom();
	    String email = technicienconnecte.getEmail();

	    model.addAttribute("nom", nom);
	    model.addAttribute("prenom", prenom);
	    model.addAttribute("email", email);

	    return "Technicien/ProfileTech.html";
	}
	
	@GetMapping("/MaladieT")
	public String AfficherMaladie()
	{
		return "Technicien/Maladie.html";
	}
	
	@GetMapping("/ModifierProfil")
	public String ModifierProfil(HttpSession session, Model model) {
	    Integer idTech = (Integer) session.getAttribute("idTech");

	    Technicien technicien = technicienService.getTechnicientById(idTech);
	    model.addAttribute("technicien", technicien);

	
		return "Technicien/ModifierProfil";
	

}
	
	@PostMapping("/ModifierProfil")
	public String modifier(@ModelAttribute Technicien technicien, HttpSession session,Model model ) {
        Integer idTech = (Integer) session.getAttribute("idTech");

        Technicien technicienConnecte = technicienService.getTechnicientById(idTech);
        technicienConnecte.setPassword(technicien.getPassword());

        technicienService.updateTechnicien(technicienConnecte);
        
                return "redirect:/ModifierProfil";
	
}
	
	
}
	
	

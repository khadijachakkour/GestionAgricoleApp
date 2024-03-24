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
import com.pfe.Service.TechnicienService;
import com.pfe.entities.Ingenieur;
import com.pfe.entities.Technicien;

import jakarta.servlet.http.HttpSession;


@Controller
public class IngenieurController {
	
	@Autowired
	private IngenieurService ingenieurService;
	
	@Autowired
	private TechnicienService technicienService;
	
	
	@GetMapping("/LoginIng.html")
	public String LoginPage()
	{
		return "Ingenieur/LoginIng.html";
	}
	
	
	@PostMapping("/Ing")
	public String Ing(@ModelAttribute Ingenieur ingenieur,HttpSession session,Model model) {
		
		boolean f = ingenieurService.isValidCredentials(ingenieur.getEmail(),ingenieur.getPassword());
		
		
		if (f) {
			
	        Ingenieur ingenieurConnecte = ingenieurService.getIngenieurByEmail(ingenieur.getEmail());
	        session.setAttribute("idIng", ingenieurConnecte.getIdIng());
            session.setAttribute("ingenieurConnecte", ingenieurConnecte);
		
			return "Ingenieur/Menu.html";

			
		}   
		
		else
		{
			model.addAttribute("errorMessage", "Mot de passe ou email incorrect");
			return "Ingenieur/LoginIng.html";
		}

}
	
	@GetMapping("/Menu")
	public String AcceuilPage()
	{
		return "Ingenieur/Menu.html";
	}
	
	@GetMapping("/Techniciens.html")
	public String ListTechniciens(Model model,HttpSession session) {
		// Récupérer l'ID de l'ingénieur connecté depuis la session
	    Integer idIng = (Integer) session.getAttribute("idIng");

	    // Utiliser l'ID pour récupérer l'objet Ingénieur correspondant
	    Ingenieur ingenieurConnecte = ingenieurService.getIngenieurById(idIng);
	    List<Technicien> techniciens = technicienService.getAllTechniciensByIngenieur(ingenieurConnecte);
	    model.addAttribute("techniciens", techniciens);
	    return "Ingenieur/Techniciens.html";
	}

	@PostMapping("/Techniciens.html")
	public String list(@ModelAttribute Technicien technicien,Model model,HttpSession session) {
	   boolean f = technicienService.checkEmail(technicien.getEmail());
		 Ingenieur ingenieurConnecte=(Ingenieur) session.getAttribute("ingenieurConnecte");
	   if(!f) {
		   technicien.setIngenieur(ingenieurConnecte);
	    technicienService.saveTechnicien(technicien);
	    return "redirect:/Techniciens.html";
	   }
	   else
	   {
		   
			model.addAttribute("errorMessage", "Technicien déja existe ");
           return"Ingenieur/create_technicien";
	   }
	    
		
	}
	
	@GetMapping("Techniciens/new")
    public String showCreateTechnicienForm(Model model) {
		 
            model.addAttribute("technicien", new Technicien());
          
        return "Ingenieur/create_technicien.html";
    }
	
	

	@GetMapping("/SignUp.html")
	public String signInPage() {
			
			return "Ingenieur/SignUp.html";
			
		}
	
	
	@PostMapping("/createUser")
	public String createuser(@ModelAttribute Ingenieur ingenieur,Model model) {
		
		
		boolean f = ingenieurService.checkEmail(ingenieur.getEmail());

		if (!f) {
			
		
			ingenieurService.saveIngenieur(ingenieur);

			return "Ingenieur/SignUp.html";
		}   
		else {
		model.addAttribute("errorMessage", "Email déja existe ");


		return "Ingenieur/SignUp.html";
}
	}
	
	
	@GetMapping("/Profile")
	public String profile(HttpSession session, Model model) {
		
	    // Récupérer l'ID de l'ingénieur connecté depuis la session
	    Integer idIng = (Integer) session.getAttribute("idIng");

	    Ingenieur ingenieurConnecte = ingenieurService.getIngenieurById(idIng);

	    String nom = ingenieurConnecte.getNom();
	    String prenom = ingenieurConnecte.getPrenom();
	    String email = ingenieurConnecte.getEmail();

	    model.addAttribute("nom", nom);
	    model.addAttribute("prenom", prenom);
	    model.addAttribute("email", email);

	    return "Ingenieur/Profile.html";
	}
	
	@GetMapping("/MaladieIng")
	public String MaladiePage()
	{
		return"Ingenieur/Maladie.html";
	}
	
	
	
	
	
	//Supprimer un technicien
		@GetMapping("/techniciens/{id}/delete")
		public String DeleteForm(@PathVariable Integer id) {
		   technicienService.deleteTechnicienById(id);
		    
		    return "redirect:/Techniciens.html"; 
		}
		
		
		//Modifier un technicien
		@GetMapping("/techniciens/{id}/edit")
		public String Edit(@PathVariable Integer id, Model model) {
		    Technicien technicien = technicienService.getTechnicientById(id);
		    model.addAttribute("technicien", technicien);
		    
		    return "Ingenieur/edit-Tech"; // Le nom de la vue Thymeleaf pour le formulaire d'édition
		}
		
		@PostMapping("/techniciens/{id}/edit")
		public String  EditForm(@ModelAttribute Technicien technicien) {
		    technicienService.updateTechnicien(technicien);
		    
		    return "redirect:/Techniciens.html";
		}
	
	
	

}

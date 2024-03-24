package com.pfe.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.pfe.Service.CapteurService;
import com.pfe.entities.Capteur;

@Controller
public class CapteurController {
	
	@Autowired
	CapteurService capteurService;
	
	//Ingenieur 
	@GetMapping("/capteur")
	public String CapteurData(Model model)
	{
		List<Capteur> capteurs=capteurService.getAllCapteur();
		model.addAttribute("capteurs", capteurs);
		//extraire les températures de chaque capteur et les stocker dans une liste
		List<Float> temperatures = capteurs.stream().map(Capteur::getTemperature).collect(Collectors.toList());
	    List<Float> humidities = capteurs.stream().map(Capteur::getHumidite).collect(Collectors.toList());
	    model.addAttribute("temperatures", temperatures);
	    model.addAttribute("humidities", humidities);
		return"Ingenieur/capteur";
	}

	
	@GetMapping("/Ventilateur")
	public String Ventilateur()
	{
		return "Ingenieur/Ventilateur";
	}
	
	//Technicien 
	@GetMapping("/capteurT")
	public String CapteurD(Model model)
	{
		List<Capteur> capteurs=capteurService.getAllCapteur();
		model.addAttribute("capteurs", capteurs);
		List<Float> temperatures = capteurs.stream().map(Capteur::getTemperature).collect(Collectors.toList());
	    List<Float> humidities = capteurs.stream().map(Capteur::getHumidite).collect(Collectors.toList());
	    model.addAttribute("temperatures", temperatures);
	    model.addAttribute("humidities", humidities);
		return"Technicien/capteur";
	}

	
	@GetMapping("/VentilateurT")
	public String VentilateurT()
	{
		return "Technicien/Ventilateur";
	}
	
}

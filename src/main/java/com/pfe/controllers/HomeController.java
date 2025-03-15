package com.pfe.controllers;



import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.slf4j.*;

@Controller
public class HomeController {
		
	
	private Logger logger  = LoggerFactory.getLogger(HomeController.class);
	

	@GetMapping("/")
	public String HomePage()
	{
		logger.info("****HomePage() execution started ****");
		return "Home.html";
	}
	

	@GetMapping("/Home")
	public String Page()
	{
		return "Home.html";
	}
	
	
	
	@GetMapping("/Choix.html")
	public String ChoixPage(){
		return "Choix.html";
	}
	
	
	
	}
	
	
	
	
	



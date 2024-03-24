package com.pfe.Service;


import java.util.List;

import com.pfe.entities.Ingenieur;


public interface IngenieurService {
	List<Ingenieur> getAllIngenieur();
	
	Ingenieur saveIngenieur(Ingenieur ingenieur);
	
	Ingenieur getIngenieurById(int id);
	
	
	void deleteIngenieurById(int id);

	
	public boolean isValidCredentials(String email, String password);

	boolean checkEmail(String email);


	Ingenieur getIngenieurByEmail(String email);


	
	
	
	
	

}

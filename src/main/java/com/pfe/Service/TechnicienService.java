package com.pfe.Service;

import java.util.List;

import com.pfe.entities.Ingenieur;
import com.pfe.entities.Technicien;


public interface TechnicienService {
	
    List<Technicien> getAllTechniciens();
	
    Technicien saveTechnicien(Technicien technicien);
	
    Technicien getTechnicientById(int id);
	
    Technicien updateTechnicien(Technicien technicien);
	
	void deleteTechnicienById(int id);

	public boolean checkEmail(String email);
    
	public List<Technicien> getAllTechniciensByIngenieur(Ingenieur ingenieurConnecte) ;

	boolean isValidCredentials(String email, String password);

	Technicien getTechnicienByEmail(String email);

	

}

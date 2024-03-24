package com.pfe.Service.Impl;


import java.util.List;

import org.springframework.stereotype.Service;


import com.pfe.Repository.IngenieurRepository;
import com.pfe.Service.IngenieurService;
import com.pfe.entities.Champ;
import com.pfe.entities.Ingenieur;



@Service
public class IngenieurServiceImpl implements IngenieurService{

	private IngenieurRepository ingenieurRepository;
	
	
	public IngenieurServiceImpl(IngenieurRepository ingenieurRepository) {
		super();
		this.ingenieurRepository = ingenieurRepository;
	}

	public List<Ingenieur> getAllIngenieur() {
		return ingenieurRepository.findAll();
	}

	public Ingenieur saveIngenieur(Ingenieur ingenieur) {
		return ingenieurRepository.save(ingenieur);

	}

	public Ingenieur getIngenieurById(int id) {
		return ingenieurRepository.findById(id).get();

	}

		public void deleteIngenieurById(int id) {
		ingenieurRepository.deleteById(id);	
		
	}

	public boolean checkEmail(String email) {

		return ingenieurRepository.existsByEmail(email);
	}
	
	public boolean isValidCredentials(String email, String password) {
	    Ingenieur ingenieur = ingenieurRepository.findByEmail(email);
	    if (ingenieur != null) {
	        if (password.equals(ingenieur.getPassword())) {
	            return true;
	        }
	    }
	    return false;
	}

	

	@Override
	public Ingenieur getIngenieurByEmail(String email) {
		// TODO Auto-generated method stub
		return ingenieurRepository.findByEmail(email);
	}

	


	
	
	

	
	
	

	

}
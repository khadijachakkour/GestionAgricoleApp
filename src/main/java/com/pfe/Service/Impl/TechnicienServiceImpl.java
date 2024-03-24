package com.pfe.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pfe.Repository.TechnicienRepository;
import com.pfe.Service.TechnicienService;
import com.pfe.entities.Champ;
import com.pfe.entities.Ingenieur;
import com.pfe.entities.Technicien;

@Service
public class TechnicienServiceImpl implements TechnicienService {
	
	@Autowired
	private TechnicienRepository technicienRepository;
	
	

	public TechnicienServiceImpl(TechnicienRepository technicienRepository) {
		super();
		this.technicienRepository = technicienRepository;
	}

	@Override
	public List<Technicien> getAllTechniciens() {
		return technicienRepository.findAll();
	}

	@Override
	public Technicien saveTechnicien(Technicien technicien) {
		return technicienRepository.save(technicien);
	}

	@Override
	public Technicien getTechnicientById(int id) {
		
		return technicienRepository.findById(id).get();
	}

	@Override
	public Technicien updateTechnicien(Technicien technicien) {
		Technicien existingTechnicien = technicienRepository.findById(technicien.getIdTech()).orElse(null);
        if (existingTechnicien == null) {
            throw new RuntimeException("Technicien not found");
        }
        
        // Mettre à jour les propriétés du champ existant avec les nouvelles valeurs
        existingTechnicien.setEmail(technicien.getEmail());
        existingTechnicien.setNom(technicien.getNom());
        existingTechnicien.setPrenom(technicien.getPrenom());
        existingTechnicien.setPassword(technicien.getPassword());
        
        return technicienRepository.save(existingTechnicien);	}

	@Override
	public void deleteTechnicienById(int id) {
		technicienRepository.deleteById(id);
		
	}

	@Override
	public boolean checkEmail(String email) {
		return technicienRepository.existsByEmail(email);
	}
 
	public List<Technicien> getAllTechniciensByIngenieur(Ingenieur ingenieurConnecte) {
	    List<Technicien> techniciens = ingenieurConnecte.getTechniciens();
	    return techniciens;
	}

	@Override
	public boolean isValidCredentials(String email, String password) {
		Technicien technicien = technicienRepository.findByEmail(email);
	    if (technicien != null) {
	        // Vérifier si le mot de passe correspond
	        if (password.equals(technicien.getPassword())) {
	            return true;
	        }
	    }
	    return false;
	}

	@Override
	public Technicien getTechnicienByEmail(String email) {
		// TODO Auto-generated method stub
		return technicienRepository.findByEmail(email);
	}

	
	
	
	

	
	
}

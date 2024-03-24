package com.pfe.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pfe.Repository.RapportRepository;
import com.pfe.Service.RapportService;
import com.pfe.entities.Champ;
import com.pfe.entities.Ingenieur;
import com.pfe.entities.Rapport;


@Service
public class RapportServiceImpl implements RapportService{

	
	@Autowired
	 private RapportRepository rapportRepository;
	
	
	public RapportServiceImpl(RapportRepository rapportRepository) {
		super();
		this.rapportRepository = rapportRepository;
	}

	@Override
	public List<Rapport> getAllRapport() {
		// TODO Auto-generated method stub
		return rapportRepository.findAll();
	}

	@Override
	public Rapport saveRapport(Rapport rapport) {
		// TODO Auto-generated method stub
		return rapportRepository.save(rapport);
	}

	@Override
	public Rapport getRapportById(int id) {
		// TODO Auto-generated method stub
		return rapportRepository.findById(id).get();
	}

	@Override
	public Rapport updateRapport(Rapport rapport) {
		Rapport existingRapport = rapportRepository.findById(rapport.getId()).orElse(null);
        if (existingRapport == null) {
            throw new RuntimeException("Rapport not found");
        }
        
        // Mettre à jour les propriétés du champ existant avec les nouvelles valeurs
		/*
		 * existingRapport.setId(rapport.getId());
		 */        
        //existingRapport.setIngenieur(rapport.getIngenieur());
        existingRapport.setTitre(rapport.getTitre());
        existingRapport.setContenu(rapport.getContenu());
       
        return rapportRepository.save(existingRapport);
	}

	@Override
	public void deleteRapportById(int id) {
		rapportRepository.deleteById(id);		
	}

	@Override
	public void delete(Rapport rapport) {
		rapportRepository.delete(rapport);
		
	}

	@Override
	public List<Rapport> getAllRapportByIngenieur(Ingenieur ingenieurConnect) {
		List<Rapport> rapports = ingenieurConnect.getRapport();
		return rapports;
	}
	
     
}

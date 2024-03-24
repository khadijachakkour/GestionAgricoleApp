package com.pfe.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pfe.Repository.ChampRepository;
import com.pfe.Service.ChampService;
import com.pfe.entities.Champ;
import com.pfe.entities.Ingenieur;
import com.pfe.entities.Technicien;

@Service
public class ChampServiceImpl implements ChampService {

	@Autowired
	private ChampRepository champRepository;
	
	
	public ChampServiceImpl(ChampRepository champRepository) {
		super();
		this.champRepository = champRepository;
	}

	@Override
	public List<Champ> getAllChamp() {
		return champRepository.findAll();
	}

	@Override
	public Champ saveChamp(Champ champ) {
		return champRepository.save(champ);
	}

	@Override
	public Champ getChampById(int id) {
		return champRepository.findById(id).get();
	}

	@Override
	public Champ updateChamp(Champ champ) {
        Champ existingChamp = champRepository.findById(champ.getId_ch()).orElse(null);
        if (existingChamp == null) {
            throw new RuntimeException("Champ not found");
        }
        
        // Mettre à jour les propriétés du champ existant avec les nouvelles valeurs
        existingChamp.setNom(champ.getNom());
        existingChamp.setCulture(champ.getCulture());
        existingChamp.setLocalisation(champ.getLocalisation());
        existingChamp.setTypeSol(champ.getTypeSol());
        existingChamp.setSuperficie(champ.getSuperficie());
        
        return champRepository.save(existingChamp);
    }

	@Override
	public void deleteChampById(int id) {
		champRepository.deleteById(id);		
	}

	@Override
	public void delete(Champ champ) {
		champRepository.delete(champ);		
	}

	@Override
	public List<Champ> getAllChampByIngenieur(Ingenieur ingenieurConnect) {
	    List<Champ> champs = ingenieurConnect.getChamps();
	    return champs;
	}
	

}

package com.pfe.Service.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pfe.Repository.CapteurRepository;
import com.pfe.Service.CapteurService;
import com.pfe.entities.Capteur;

@Service
public class CapteurServiceImpl implements CapteurService {
	
	private CapteurRepository capteurRepository;
	

	public CapteurServiceImpl(CapteurRepository capteurRepository) {
		super();
		this.capteurRepository = capteurRepository;
	}


	@Override
	public List<Capteur> getAllCapteur() {
		// TODO Auto-generated method stub
		return capteurRepository.findAll();
	}

}

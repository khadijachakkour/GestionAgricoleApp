package com.pfe.Service;

import java.util.List;

import com.pfe.entities.Ingenieur;
import com.pfe.entities.Rapport;

public interface RapportService {
	
	List<Rapport> getAllRapport();
	
    Rapport saveRapport(Rapport rapport);
	
    Rapport getRapportById(int id);
	
	
	void deleteRapportById(int id);

	void delete(Rapport rapport);

	List<Rapport> getAllRapportByIngenieur(Ingenieur ingenieurConnect);

	Rapport updateRapport(Rapport rapport);


}

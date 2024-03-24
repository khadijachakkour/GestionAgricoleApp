package com.pfe.Service;

import java.util.List;

import com.pfe.entities.Champ;
import com.pfe.entities.Ingenieur;


public interface ChampService {
	
	List<Champ> getAllChamp();
	
	Champ saveChamp(Champ champ);
	
	Champ getChampById(int id);
	
	Champ updateChamp(Champ champ);
	
	void deleteChampById(int id);

	void delete(Champ champ);

	List<Champ> getAllChampByIngenieur(Ingenieur ingenieurConnect);
	
	


}

package com.pfe.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.pfe.entities.Ingenieur;



public interface IngenieurRepository extends JpaRepository<Ingenieur, Integer>{

	boolean existsByEmail(String email);
	
	Ingenieur findByPassword(String password);
	
	Ingenieur findByEmail(String email);
	Ingenieur getIngenieurByEmail(String email);


	

	



}
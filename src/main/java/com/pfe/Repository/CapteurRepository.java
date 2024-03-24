package com.pfe.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pfe.entities.Capteur;

public interface CapteurRepository extends JpaRepository<Capteur,Integer>{

	List<Capteur> findAll();

}

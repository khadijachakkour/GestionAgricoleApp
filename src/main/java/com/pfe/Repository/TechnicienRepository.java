package com.pfe.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.pfe.entities.Technicien;

public interface TechnicienRepository extends JpaRepository<Technicien, Integer>{
	
    boolean existsByEmail(String email);
    Technicien  findByEmail(String email);

	

}

package com.pfe.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pfe.entities.Champ;

public interface ChampRepository extends JpaRepository<Champ, Integer> {

}

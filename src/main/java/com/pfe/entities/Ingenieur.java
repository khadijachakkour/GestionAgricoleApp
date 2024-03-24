package com.pfe.entities;

import java.util.List;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "ingenieur", catalog = "pfe_bd")
public class Ingenieur implements java.io.Serializable {
 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idIng;
	private String prenom;
	private String nom;
	private String email;
	private String password;
	
	public Ingenieur() {
	}
	
	@OneToMany(mappedBy = "ingenieur",cascade = CascadeType.ALL)
	private List<Technicien> techniciens;
	
	@OneToMany(mappedBy = "ingenieur",cascade = CascadeType.ALL)
	private List<Champ> champs ;
	
	@OneToMany(mappedBy = "ingenieur",cascade = CascadeType.ALL)
	private List<Rapport> Rapport ;
	
	

	public List<Rapport> getRapport() {
		return Rapport;
	}

	public void setRapport(List<Rapport> rapport) {
		Rapport = rapport;
	}

	public List<Champ> getChamps() {
		return champs;
	}

	public void setChamps(List<Champ> champs) {
		this.champs = champs;
	}

	@Column(name = "Id_Ing", unique = true, nullable = false)
	public Integer getIdIng() {
		return this.idIng;
	}

	public void setIdIng(Integer idIng) {
		this.idIng = idIng;
	}

	@Column(name = "Prenom", nullable = false, length = 10)
	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	@Column(name = "Nom", nullable = false, length = 10)
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Column(name = "Email", nullable = false, length = 20)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "Password", nullable = false, length = 20)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public List<Technicien> getTechniciens() {
		return this.techniciens;
	}

	public void setTechniciens(List<Technicien> techniciens) {
		this.techniciens = techniciens;
	}
	
	

   
	

	

}

package com.pfe.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "technicien")
public class Technicien implements java.io.Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idTech;
	
	@ManyToOne
	@JoinColumn(name = "Id_Ing")
	private Ingenieur ingenieur;
	
	private String prenom;
	private String nom;
	private String email;
	private String password;
	

	public Technicien() {
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Technicien(Ingenieur ingenieur, String prenom, String nom, String email) {
		this.ingenieur = ingenieur;
		this.prenom = prenom;
		this.nom = nom;
		this.email = email;
	}
	

	@Column(name = "Id_Tech", unique = true, nullable = false)
	public Integer getIdTech() {
		return this.idTech;
	}

	public void setIdTech(Integer idTech) {
		this.idTech = idTech;
	}

	
	public Ingenieur getIngenieur() {
		return this.ingenieur;
	}

	public void setIngenieur(Ingenieur ingenieur) {
		this.ingenieur = ingenieur;
	}

	@Column(name = "Prenom", nullable = false, length = 50)
	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	@Column(name = "Nom", nullable = false, length = 50)
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Column(name = "Email", nullable = false, length = 50)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	

	
}

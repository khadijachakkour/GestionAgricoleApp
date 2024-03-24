package com.pfe.entities;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Champ implements java.io.Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_ch;
	private String Nom;
	private double superficie;  
	private String Localisation;
	private String TypeSol;
	private String Culture;
	
	@ManyToOne
	@JoinColumn(name = "Id_Ing")
	private Ingenieur ingenieur;

	
	public String getTypeSol() {
		return TypeSol;
	}
	public void setTypeSol(String typeSol) {
		TypeSol = typeSol;
	}
	public String getCulture() {
		return Culture;
	}
	public void setCulture(String culture) {
		Culture = culture;
	}
	
	
	
	public Ingenieur getIngenieur() {
		return ingenieur;
	}
	public void setIngenieur(Ingenieur ingenieur) {
		this.ingenieur = ingenieur;
	}
	public Integer getId_ch() {
		return id_ch;
	}
	public void setId_ch(Integer id_ch) {
		this.id_ch = id_ch;
	}
	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
	public double getSuperficie() {
		return superficie;
	}
	public void setSuperficie(double superficie) {
		this.superficie = superficie;
	}
	public String getLocalisation() {
		return Localisation;
	}
	public void setLocalisation(String localisation) {
		Localisation = localisation;
	}
	
	

}

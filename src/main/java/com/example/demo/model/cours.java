package com.example.demo.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties("cours")
public class cours implements Serializable {
	@Id
	@GeneratedValue
	private  Long code_C;
	private String libeel_C;
   @ManyToMany(mappedBy = "cours")
   private Collection<Etudiant> etudiants;
   @OneToOne
   @JoinColumn(name="num_s")
   private salle salle;
   @OneToMany(mappedBy = "cours")
   private Collection<enseignant> enseignants;
   
public cours(Long code_C, String libeel_C, Collection<Etudiant> etudiants, salle salle,
		Collection<enseignant> enseignants) {
	super();
	this.code_C = code_C;
	this.libeel_C = libeel_C;
	this.etudiants = etudiants;
	this.salle = salle;
	this.enseignants = enseignants;
}
public Long getCode_C() {
	return code_C;
}
public void setCode_C(Long code_C) {
	this.code_C = code_C;
}
public String getLibeel_C() {
	return libeel_C;
}
public void setLibeel_C(String libeel_C) {
	this.libeel_C = libeel_C;
}
public Collection<Etudiant> getEtudiants() {
	return etudiants;
}
public void setEtudiants(Collection<Etudiant> etudiants) {
	this.etudiants = etudiants;
}
public salle getSalle() {
	return salle;
}
public void setSalle(salle salle) {
	this.salle = salle;
}
public Collection<enseignant> getEnseignants() {
	return enseignants;
}
public void setEnseignants(Collection<enseignant> enseignants) {
	this.enseignants = enseignants;
}
public cours() {

}
   
   
}

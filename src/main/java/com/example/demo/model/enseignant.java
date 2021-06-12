package com.example.demo.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class enseignant implements Serializable {
@Id 
@GeneratedValue
private Long matricul ; 
private String nomens;
private String prenomens;
private String adresseens;
private String diplom;
@ManyToOne
@JoinColumn(name="codedep")
private Departement departement;
@ManyToOne
@JoinColumn(name="code_C")
private cours cours;
@ManyToMany
@JoinTable(name="etu_ens",joinColumns =
@JoinColumn(name="matricul"),inverseJoinColumns=
@JoinColumn(name="numinsc"))
private Collection<Etudiant> etudiants;

public enseignant(Long matricul, String nomens, String prenomens, String adresseens, String diplom,
		Departement departement, com.example.demo.model.cours cours, Collection<Etudiant> etudiants) {
	super();
	this.matricul = matricul;
	this.nomens = nomens;
	this.prenomens = prenomens;
	this.adresseens = adresseens;
	this.diplom = diplom;
	this.departement = departement;
	this.cours = cours;
	this.etudiants = etudiants;
}
public Long getMatricul() {
	return matricul;
}
public void setMatricul(Long matricul) {
	this.matricul = matricul;
}
public String getNomens() {
	return nomens;
}
public void setNomens(String nomens) {
	this.nomens = nomens;
}
public String getPrenomens() {
	return prenomens;
}
public void setPrenomens(String prenomens) {
	this.prenomens = prenomens;
}
public String getAdresseens() {
	return adresseens;
}
public void setAdresseens(String adresseens) {
	this.adresseens = adresseens;
}
public String getDiplom() {
	return diplom;
}
public void setDiplom(String diplom) {
	this.diplom = diplom;
}
public Departement getDepartement() {
	return departement;
}
public void setDepartement(Departement departement) {
	this.departement = departement;
}
public cours getCours() {
	return cours;
}
public void setCours(cours cours) {
	this.cours = cours;
}
public Collection<Etudiant> getEtudiants() {
	return etudiants;
}
public void setEtudiants(Collection<Etudiant> etudiants) {
	this.etudiants = etudiants;
}
public enseignant() {

}

}

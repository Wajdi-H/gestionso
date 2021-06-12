package com.example.demo.model;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Etudiant {
 @Id
 private Long numinsc;
 private String nometu;
 private String prenomrtu;
 private String adresseetu;
 private Date dateentee;
 @ManyToMany(mappedBy ="etudiants")
 private Collection<enseignant> enseignants;
 @ManyToMany
 @JoinTable(name="etu_cours",joinColumns =
 @JoinColumn(name="numinsc"),inverseJoinColumns=
 @JoinColumn(name="code_C"))
 private Collection<cours> cours;
public Etudiant(Long numinsc, String nometu, String prenomrtu, String adresseetu, Date dateentee,
		Collection<enseignant> enseignants, Collection<cours> cours) {
	super();
	this.numinsc = numinsc;
	this.nometu = nometu;
	this.prenomrtu = prenomrtu;
	this.adresseetu = adresseetu;
	this.dateentee = dateentee;
	this.enseignants = enseignants;
	this.cours = cours;
}
public Long getNuminsc() {
	return numinsc;
}
public void setNuminsc(Long numinsc) {
	this.numinsc = numinsc;
}
public String getNometu() {
	return nometu;
}
public void setNometu(String nometu) {
	this.nometu = nometu;
}
public String getPrenomrtu() {
	return prenomrtu;
}
public void setPrenomrtu(String prenomrtu) {
	this.prenomrtu = prenomrtu;
}
public String getAdresseetu() {
	return adresseetu;
}
public void setAdresseetu(String adresseetu) {
	this.adresseetu = adresseetu;
}
public Date getDateentee() {
	return dateentee;
}
public void setDateentee(Date dateentee) {
	this.dateentee = dateentee;
}
public Collection<enseignant> getEnseignants() {
	return enseignants;
}
public void setEnseignants(Collection<enseignant> enseignants) {
	this.enseignants = enseignants;
}
public Collection<cours> getCours() {
	return cours;
}
public void setCours(Collection<cours> cours) {
	this.cours = cours;
}
public Etudiant() {

}
 
 
 
}
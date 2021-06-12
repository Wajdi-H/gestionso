package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity

public class salle implements Serializable {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long num_s;
private String nom_s;
private Long capacite;
@OneToOne
@JoinColumn(name="code_C")
private cours cours;

public salle() {
	super();
}

public salle(Long num_s, String nom_s, Long capacite, cours cours) {
	super();
	this.num_s = num_s;
	this.nom_s = nom_s;
	this.capacite = capacite;
	this.cours = cours;
}
public Long getNum_s() {
	return num_s;
}
public void setNum_s(Long num_s) {
	this.num_s = num_s;
}
public String getNom_s() {
	return nom_s;
}
public void setNom_s(String nom_s) {
	this.nom_s = nom_s;
}
public Long getCapacite() {
	return capacite;
}
public void setCapacite(Long capacite) {
	this.capacite = capacite;
}
public cours getCours() {
	return cours;
}
public void setCours(cours cours) {
	this.cours = cours;
}

}


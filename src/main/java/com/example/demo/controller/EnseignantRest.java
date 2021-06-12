package com.example.demo.controller;

import java.util.Collection;


import com.example.demo.repository.CoursRepository;
import com.example.demo.repository.DepartementRepository;
import com.example.demo.repository.enseignantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Departement;
import com.example.demo.model.cours;
import com.example.demo.model.enseignant;

@RestController
@RequestMapping("/enseignant")
@CrossOrigin("*")
public class EnseignantRest {
	@Autowired
	private enseignantRepository EF;
	@Autowired
	private DepartementRepository departementinterface;
	@Autowired
	private CoursRepository coursi;
	
	@PostMapping("/add/{iddept}/{idcours}") 
	public void save(@RequestBody enseignant es,@PathVariable long iddept,@PathVariable long idcours)
	
	{
		Departement dept= new Departement();
		cours cour=new cours();
		cour=coursi.findById(idcours).get();
		dept=departementinterface.findById(iddept).get();
		es.setDepartement(dept);
		es.setCours(cour);
		
		EF.save(es);
	}
	
	@GetMapping("/get")
	public Collection<enseignant> findALL()
	{
		return EF.findAll();
	}
	
	
	@DeleteMapping("/supprimer/{id}")
	public void supprimer(@PathVariable Long id) {
	
		EF.deleteById(id);
	}
	@GetMapping("/get/{id}")
	public enseignant findById(@PathVariable Long id)
	{
		return EF.findById(id).get();
	}
	@PutMapping("edit/{id}")  // modification

	public void update(@PathVariable Long id , @RequestBody enseignant es)
	
	{
		es.setMatricul(id);
		EF.save(es)	;
	}

}

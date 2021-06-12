package com.example.demo.controller;



import java.util.Collection;


import com.example.demo.repository.DepartementRepository;
import com.example.demo.repository.universitesRepository;
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
import com.example.demo.model.universites;

@RestController
@RequestMapping("/Departements")
@CrossOrigin("*")

public class DepartementRest {

	@Autowired
	private DepartementRepository departementinterface;
	@Autowired
	private universitesRepository unif;
	
	@PostMapping("/add/{idc}") 
	public void save(@RequestBody Departement departements,@PathVariable long idc)
	
	{	
		universites uni = new universites();
		uni=unif.findById(idc).get();
		departements.setUniversites(uni);
		departementinterface.save(departements);
	}
	@GetMapping("/get")
	public Collection<Departement> findALL()
	{
		return departementinterface.findAll();
	}
	
	@GetMapping("get/{codeDEP}")
	public Departement findById(@PathVariable Long codeDEP)
	{
		return departementinterface.findById(codeDEP).get();
	}
	
	
	@DeleteMapping("/supprimer/{codeDEP}")
	public void supprimer(@PathVariable Long codeDEP) {
	
		departementinterface.deleteById(codeDEP);
	}
	@PutMapping("edit/{codeDEP}")  // modification

	public void update(@PathVariable Long codeDEP , @RequestBody Departement departements)
	
	{
		departements.setCodedep(codeDEP);
		departementinterface.save(departements);
	}

}

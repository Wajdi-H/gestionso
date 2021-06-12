package com.example.demo.controller;

import java.util.Collection;


import com.example.demo.repository.CoursRepository;
import com.example.demo.repository.salleRepository;
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


import com.example.demo.model.cours;
import com.example.demo.model.salle;

@RestController
@RequestMapping("/cours")
@CrossOrigin("*")
public class CoursRest {
	@Autowired
	private CoursRepository CF;
	@Autowired
	private salleRepository SI ;
	
	
	@PostMapping("/add/{id}") 
	public void save(@RequestBody cours cours , @PathVariable long id)
	
	{	salle sa = new salle();
		sa=SI.findById(id).get();
		cours.setSalle(sa);
		CF.save(cours);
	}
	
	@GetMapping("/get")
	public Collection<cours> findALL()
	{
		return CF.findAll();
	}
	@GetMapping("/get/{id}")
	public cours findById(@PathVariable Long id)
	{
		return CF.findById(id).get();
	}
	
	
	@DeleteMapping("/supprimer/{id}")
	public void supprimer(@PathVariable Long id) {
	
		CF.deleteById(id);
	}
	@PutMapping("edit/{id}")  // modification

	public void update(@PathVariable Long id , @RequestBody cours cours)
	
	{
		cours.setCode_C(id);
		CF.save(cours)	;
	}
	
}

package com.example.demo.controller;

import java.util.Collection;


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
import com.example.demo.model.salle;

@RestController
@RequestMapping("/Salle")
@CrossOrigin("*")
public class SalleRest {
	@Autowired
	private salleRepository SF;
	
	
	@PostMapping("/add") 
	public void save(@RequestBody salle salle)
	
	{	SF.save(salle);
	}
	
	@GetMapping("/get")
	public Collection<salle> findALL()
	{
		return SF.findAll();
	}
	
	@GetMapping("/get/{id}")
	public salle findById(@PathVariable Long id)
	{
		return SF.findById(id).get();
	}
	@DeleteMapping("/supprimer/{id}")
	public void supprimer(@PathVariable Long id) {
	
		SF.deleteById(id);
	}
	@PutMapping("edit/{id}")  // modification

	public void update(@PathVariable Long id , @RequestBody salle salle)
	
	{
		salle.setNum_s(id);
		SF.save(salle)	;
	}

}

package com.example.demo.controller;

import java.util.Collection;


import com.example.demo.repository.EtudiantRepository;
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
import com.example.demo.model.Etudiant;

@RestController
@RequestMapping("/etudiant")
@CrossOrigin("*")
public class EtudiantRest {
	@Autowired
	private EtudiantRepository EF;
	
	
	@PostMapping("/add") 
	public void save(@RequestBody Etudiant ET)
	
	{	EF.save(ET);
	}
	
	@GetMapping("/get")
	public Collection<Etudiant> findALL()
	{
		return EF.findAll();
	}
	@GetMapping("/get/{id}")
	public Etudiant findById(@PathVariable Long id)
	{
		return EF.findById(id).get();
	}
	
	
	@DeleteMapping("/supprimer/{id}")
	public void supprimer(@PathVariable Long id) {
	
		EF.deleteById(id);
	}
	@PutMapping("edit/{id}")  // modification

	public void update(@PathVariable Long numinsc , @RequestBody Etudiant ET)
	
	{
		ET.setNuminsc(numinsc);
		EF.save(ET)	;
	}

}

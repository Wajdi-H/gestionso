package com.example.demo.controller;

import java.util.Collection;


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
import com.example.demo.model.universites;

@RestController
@RequestMapping("/Uni")
@CrossOrigin("*")
public class UniversiteRest {

	@Autowired
	private universitesRepository UF;

	
	
	@PostMapping("/add") 
	public void save(@RequestBody universites uni)
	
	{	UF.save(uni);
	}
	
	@GetMapping("/get")
	public Collection<universites> findALL()
	{
		return UF.findAll();
	}
	
	@GetMapping("/getaa/{a}")
	public Collection<universites> RechN(@PathVariable char a )
	{
		return UF.Recherche(a);
	}
    
	@GetMapping("/getc/{a}")
	public int counterr(@PathVariable Long a )
	{
		return UF.counter(a);
	}
	
	@GetMapping("/get/{id}")
	public universites findById(@PathVariable Long id)
	{
		return UF.findById(id).get();
	}
	@GetMapping("/getunidept/{id}")
	public Object unicountdept(@PathVariable Long id)
	{
		return UF.UniDept(id);
	}
	
	
	@DeleteMapping("/supprimer/{id}")
	public void supprimer(@PathVariable Long id) {
	
		UF.deleteById(id);
	}
	@PutMapping("edit/{id}")  // modification

	public void update(@PathVariable Long id , @RequestBody universites uni)
	
	{
		uni.setCodeuniv(id);
		UF.save(uni)	;
	}

}



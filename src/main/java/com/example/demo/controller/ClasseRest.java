package com.example.demo.controller;

import java.util.List;

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

import com.example.demo.model.Classe;
import com.example.demo.repository.ClasseRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("classe")
public class ClasseRest {

	@Autowired
	private ClasseRepository classeRepository;
	
	@GetMapping("/")
	public List<Classe> getAll()
	{
		return classeRepository.findAll();
	}
	
	@PostMapping("save")
	public void save(@RequestBody Classe classe)
	{
		classeRepository.save(classe);
	}
	
	
	@GetMapping("{id}")
	public Classe finByid(@PathVariable int id)
		{
			return classeRepository.findById(id).get();
		}
	
	@DeleteMapping("delete/{id}")
	public void delete(@PathVariable int id)
	{
		classeRepository.deleteById(id);
	}
	
	@PutMapping("edit/{id}")
	public void update(@PathVariable int id, @RequestBody Classe classe)
	{
		classe.setId(id);
		classeRepository.save(classe);
	}
}

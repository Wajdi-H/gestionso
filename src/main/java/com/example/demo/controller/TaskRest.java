package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Task;
import com.example.demo.repository.TaskRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("tasks")
public class TaskRest {

	@Autowired
	public TaskRepository taskRepository;

	@GetMapping("/")
	public List<Task> getAll()
	{
		return taskRepository.findAll();
	}
	
	
}

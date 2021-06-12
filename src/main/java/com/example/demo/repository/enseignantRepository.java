package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.enseignant;

import java.lang.Long;

public interface enseignantRepository extends JpaRepository<enseignant,Long> {
}

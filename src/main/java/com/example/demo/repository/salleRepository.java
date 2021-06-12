package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.salle;

import java.lang.Long;

public interface salleRepository extends JpaRepository<salle,Long> {

}

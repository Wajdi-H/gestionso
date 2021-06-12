package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.cours;

import java.lang.Long;

public interface CoursRepository extends JpaRepository<cours,Long> {

}

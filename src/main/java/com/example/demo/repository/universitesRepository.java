package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.universites;

import java.util.Collection;

public interface universitesRepository extends JpaRepository<universites,Long> {
	@Query(value="SELECT * FROM universites u WHERE u.nomuniv  LIKE '%?a%'" , nativeQuery=true)
   public Collection<universites> Recherche(char a );
   @Query("SELECT  COUNT(d) FROM  Departement d join d.universites u  WHERE u.codeuniv = :a")
   public int counter(Long a);
   @Query("SELECT u.nomuniv , COUNT(d) FROM  Departement d join d.universites u  WHERE u.codeuniv = :a")
   public Object UniDept(Long a);
   
   
   
}

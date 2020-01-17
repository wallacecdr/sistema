package com.sistema.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sistema.model.Estado;
import com.sistema.model.Pais;

public interface PaisRepository extends JpaRepository<Pais, Long>{
	
	@Query("SELECT nome FROM Pais p WHERE p.nome LIKE %?1%")
	List<String> getPaises(String nome);
	
	@Query("SELECT p FROM Pais p WHERE p.nome = ?1")
	Pais getPaisByNome(String nome);
}

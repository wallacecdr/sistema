package com.sistema.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sistema.model.Entidade;

@Repository
public interface EntidadeRepository extends JpaRepository<Entidade, Long>{

	@Query("SELECT e FROM Entidade e WHERE cliente = 1")
	List<Entidade> getClientes();	
	
	@Query("SELECT e FROM Entidade e WHERE fornecedor = 1")
	List<Entidade> getFornecedores();	
}

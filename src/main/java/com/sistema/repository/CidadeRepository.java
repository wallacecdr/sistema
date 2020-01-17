package com.sistema.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sistema.model.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Long>{
	
	@Query("SELECT c FROM Cidade c WHERE c.nome LIKE %?1%")
	List<String> getCidades(String nome);
	
	@Query("SELECT c FROM Cidade c WHERE c.nome = ?1")
	Cidade getCidadeByNome(String nome);
	
	@Query("SELECT c FROM Cidade c WHERE c.idestado = (SELECT e.id FROM Estado e WHERE e.codigo = ?1)")
	List<Cidade> getCidadesByEstado(String codigo);
}

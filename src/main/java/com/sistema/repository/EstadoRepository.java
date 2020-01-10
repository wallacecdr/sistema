package com.sistema.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sistema.model.Estado;

public interface EstadoRepository extends JpaRepository<Estado, Long>{
	
	@Query("SELECT codigo FROM Estado e WHERE e.codigo LIKE %?1%")
	List<String> getEstados(String estado);
	
	@Query("SELECT e FROM Estado e WHERE e.codigo = ?1")
	Estado getEstadoByCodigo(String codigo);
}

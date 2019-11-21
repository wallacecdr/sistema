package com.sistema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sistema.model.Entidade;

@Repository
public interface EntidadeRepository extends JpaRepository<Entidade, Long>{

}

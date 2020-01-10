package com.sistema;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sistema.model.Estado;
import com.sistema.repository.EstadoRepository;

@SpringBootTest
class SistemaApplicationTests {
	
	@Autowired
	private EstadoRepository estadoRepository;

	@Test
	void contextLoads() {
		
		Estado estado = estadoRepository.getEstadoByCodigo("PR");
		System.out.println(estado.getNome());
	}

}

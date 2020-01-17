package com.sistema;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sistema.model.Cidade;
import com.sistema.model.Estado;
import com.sistema.repository.CidadeRepository;
import com.sistema.repository.EstadoRepository;

@SpringBootTest
class SistemaApplicationTests {
	
	@Autowired
	private CidadeRepository cidadeRepository;

	@Test
	void contextLoads() {
		
	}

}

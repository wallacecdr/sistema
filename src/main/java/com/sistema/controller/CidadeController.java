package com.sistema.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sistema.model.Cidade;
import com.sistema.repository.CidadeRepository;
import com.sistema.repository.EstadoRepository;

@Controller
public class CidadeController {

	@Autowired
	private CidadeRepository cidadeRepository;
	
	@RequestMapping(value = "/getCidades", 
			method = RequestMethod.GET, 
			headers="Accept=*/*",
			produces="application/json")
	/*Retorna os estados em formato JSON devido ao uso do @ResponseBody*/
	public @ResponseBody List<Cidade> getCidades(@RequestParam("codEstado") String codEstado){
		
		return cidadeRepository.getCidadesByEstado(codEstado);
	}
}

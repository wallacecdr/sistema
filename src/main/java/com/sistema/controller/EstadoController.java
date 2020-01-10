package com.sistema.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sistema.repository.EstadoRepository;

@Controller
public class EstadoController {

	@Autowired
	private EstadoRepository estadoRepository;
	
	@RequestMapping(value = "/getEstados", 
			method = RequestMethod.GET, 
			headers="Accept=*/*")
	/*Retorna os estados em formato JSON devido ao uso do @ResponseBody*/
	public @ResponseBody List<String> getEstados(@RequestParam("term") String query){
		
		return estadoRepository.getEstados(query);
	}
}

package com.sistema.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.sistema.model.Entidade;
import com.sistema.repository.EntidadeRepository;

@Controller
public class EntidadeController {

	@Autowired
	private EntidadeRepository entidadeRepository;
	
	@GetMapping("/incluirEntidade")
	public ModelAndView incluir() {
	
		ModelAndView view = new ModelAndView("cadastro/cadastro_entidade");
		view.addObject("tipo", "Cliente");
		
		return view;
	}
	
	@PostMapping(path="/salvarEntidade")
	public ModelAndView cadastrar(Entidade entidade) {
		
		entidadeRepository.save(entidade);
		
		ModelAndView view = new ModelAndView("lista/lista_entidades");
		
		Iterable<Entidade> entidades = entidadeRepository.findAll();
		
		view.addObject("tipo", "Cliente");
		view.addObject("entidades", entidades);
		
		return view;
	}
	
	@GetMapping(path="/excluirEntidade")
	@ResponseBody
	public ModelAndView excluir(@RequestParam(required = true) Long id) {
		
		entidadeRepository.deleteById(id);
		
		ModelAndView view = new ModelAndView("lista/lista_entidades");
		
		Iterable<Entidade> entidades = entidadeRepository.findAll();
		
		view.addObject("tipo", "Cliente");
		view.addObject("entidades", entidades);
		
		return view;
	}
	
	@GetMapping(path="/editarEntidade")
	@ResponseBody
	public ModelAndView editar(@RequestParam(required = true) Long id) {

		ModelAndView view = new ModelAndView("cadastro/cadastro_entidade");
		
		Optional<Entidade> entidade = entidadeRepository.findById(id);
		
		view.addObject("tipo", "Cliente");
		view.addObject("entidade", entidade.get());
		
		return view;
	}
	
	@GetMapping("/entidades")
	public ModelAndView listarEntidades() {
		
		ModelAndView view = new ModelAndView("lista/lista_entidades");
		
		Iterable<Entidade> entidades = entidadeRepository.findAll();
		
		view.addObject("tipo", "Cliente");
		view.addObject("entidades", entidades);
		
		return view;
	}
}

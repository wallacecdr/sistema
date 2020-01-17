package com.sistema.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sistema.model.Cidade;
import com.sistema.model.Entidade;
import com.sistema.model.Estado;
import com.sistema.model.Pais;
import com.sistema.repository.CidadeRepository;
import com.sistema.repository.EntidadeRepository;
import com.sistema.repository.EstadoRepository;
import com.sistema.repository.PaisRepository;

@Controller
public class EntidadeController {

	@Autowired
	private EntidadeRepository entidadeRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private PaisRepository paisRepository;
	
	@GetMapping("/incluirEntidade")
	public ModelAndView incluir() {
	
		Iterable<Estado> estados = estadoRepository.findAll();
		Iterable<Cidade> cidades = cidadeRepository.getCidadesByEstado("EX");
		Iterable<Pais> paises = paisRepository.findAll();
		
		ModelAndView view = new ModelAndView("cadastro/cadastro_entidade");
		view.addObject("tipo", "Cliente");
		view.addObject("entidade", new Entidade());
		view.addObject("cidades", cidades);
		view.addObject("estados", estados);
		view.addObject("paises", paises);
		
		return view;
	}
	
	@PostMapping(path="/salvarEntidade")
	public ModelAndView cadastrar(Entidade entidade, BindingResult br, HttpServletRequest request) {
		
		String estadoSelecionado = request.getParameter("estado");
		
		/*Valida o estado selecionado*/
		if(estadoSelecionado != null && !estadoSelecionado.isEmpty()) {
			Estado estado = estadoRepository.getEstadoByCodigo(estadoSelecionado);
			entidade.setEstado(estado);
		}
		
		String cliente = request.getParameter("cliente");

		/*Valida o checkbox cliente*/
		if(cliente != null) {
			if(cliente.equalsIgnoreCase("on")) {
				entidade.setCliente(1);
			}else {
				entidade.setCliente(0);
			}
		}
		
		String fornecedor = request.getParameter("fornecedor");
		
		/*Valida o checkbox fornecedor*/
		if(fornecedor != null) {
			if(fornecedor.equalsIgnoreCase("on")) {
				entidade.setFornecedor(1);
			}else {
				entidade.setFornecedor(0);
			}
		}
		
		entidadeRepository.save(entidade);
		
		ModelAndView view = new ModelAndView("lista/lista_entidades");
		
		Iterable<Entidade> entidades = entidadeRepository.findAll();
		Iterable<Estado> estados = estadoRepository.findAll();
		
		view.addObject("tipo", "Cliente");
		view.addObject("entidades", entidades);
		view.addObject("estados", estados);
		
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
		Iterable<Estado> estados = estadoRepository.findAll();
		
		view.addObject("tipo", "Cliente");
		view.addObject("entidade", entidade.get());
		view.addObject("estados", estados);
		
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

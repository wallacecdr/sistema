package com.sistema.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sistema.model.Cidade;
import com.sistema.model.Empresa;
import com.sistema.model.Estado;
import com.sistema.model.Pais;
import com.sistema.repository.CidadeRepository;
import com.sistema.repository.EmpresaRepository;
import com.sistema.repository.EstadoRepository;
import com.sistema.repository.PaisRepository;

@Controller
public class EmpresaController {

	private static final String TIPO = "EMPRESA";
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private PaisRepository paisRepository;
	
	@GetMapping("/empresa")	
	public ModelAndView incluir() {
		
		//Empresa empresa = new Empresa();
		Empresa empresa = empresaRepository.findById(1L).get();
		Iterable<Estado> estados = estadoRepository.findAll();
		Iterable<Cidade> cidades = cidadeRepository.getCidadesByEstado("PR");
		Iterable<Pais> paises = paisRepository.findAll();
		
		ModelAndView view = new ModelAndView("cadastro/cadastro_empresa");
		
		view.addObject("tipo", TIPO);
		view.addObject("empresa", empresa);
		view.addObject("cidades", cidades);
		view.addObject("estados", estados);
		view.addObject("paises", paises);
		
		return view;
	}
	
	@PostMapping("/salvarEmpresa")
	public ModelAndView cadastrar(Empresa empresa, BindingResult br, HttpServletRequest request) {
		
		String estadoSelecionado = request.getParameter("estado");
		String cidadeSelecionada = request.getParameter("cidade");
		
		/*Valida o estado selecionado*/
		if(estadoSelecionado != null && !estadoSelecionado.isEmpty()) {
			Estado estado = estadoRepository.getEstadoByCodigo(estadoSelecionado);
			empresa.setEstado(estado);
		}
		
		/*Valida a cidade selecionada*/
		if(cidadeSelecionada != null && !cidadeSelecionada.isEmpty()) {
			Cidade cidade = cidadeRepository.getCidadeByNome(cidadeSelecionada);
			empresa.setCidade(cidade);
		}
		
		Iterable<Estado> estados = estadoRepository.findAll();
		Iterable<Cidade> cidades = cidadeRepository.getCidadesByEstado("PR");
		
		ModelAndView view = new ModelAndView("main");
		
		view.addObject("tipo", TIPO);
		view.addObject("empresa", empresa);
		view.addObject("cidades", cidades);
		view.addObject("estados", estados);
			
		empresaRepository.save(empresa);
		
		return view;
	}
}

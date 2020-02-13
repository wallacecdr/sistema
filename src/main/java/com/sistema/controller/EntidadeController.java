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
	
	@GetMapping("/entidades")
	public ModelAndView listarEntidades(@RequestParam(name = "tipo") String tipo) {
		
		ModelAndView view = new ModelAndView("lista/lista_entidades");
		
		Iterable<Entidade> entidades = null;
		
		if(tipo.equalsIgnoreCase("cliente")) {
			entidades = entidadeRepository.getClientes();
		}else if(tipo.equalsIgnoreCase("fornecedor")){
			entidades = entidadeRepository.getFornecedores();
		}
		
		view.addObject("tipo", tipo.toUpperCase());
		view.addObject("entidades", entidades);
		
		return view;
	}
	
	@GetMapping("/incluirEntidade")
	public ModelAndView incluir(@RequestParam(name = "tipo") String tipo) {
		
		Entidade entidade = new Entidade();
		Iterable<Estado> estados = estadoRepository.findAll();
		Iterable<Cidade> cidades = cidadeRepository.getCidadesByEstado("PR");
		Iterable<Pais> paises = paisRepository.findAll();
		
		/*seta o tipo de contribuinte para que o campo de inscrição fique readonly*/
		entidade.setTipocontribuinte(9);
	

		if(tipo.equalsIgnoreCase("cliente")) {
			entidade.setCliente(1);
		}else if(tipo.equalsIgnoreCase("fornecedor")) {
			entidade.setFornecedor(1);
		}
		
		ModelAndView view = new ModelAndView("cadastro/cadastro_entidade");
		
		view.addObject("tipo", tipo.toUpperCase());
		view.addObject("entidade", entidade);
		view.addObject("cidades", cidades);
		view.addObject("estados", estados);
		view.addObject("paises", paises);
		
		return view;
	}
	
	@PostMapping(path="/salvarEntidade")
	public String cadastrar(@RequestParam(name = "tipo") String tipo, Entidade entidade, BindingResult br, HttpServletRequest request) {

		if(tipo.equalsIgnoreCase("cliente")) {
			entidade.setCliente(1);
		}else if(tipo.equalsIgnoreCase("fornecedor")){
			entidade.setFornecedor(1);
		}
		
		String estadoSelecionado = request.getParameter("estado");
		String cidadeSelecionada = request.getParameter("cidade");
		String paisSelecionado = request.getParameter("pais");
		
		/*Valida o estado selecionado*/
		if(estadoSelecionado != null && !estadoSelecionado.isEmpty()) {
			Estado estado = estadoRepository.getEstadoByCodigo(estadoSelecionado);
			entidade.setEstado(estado);
		}
		
		/*Valida a cidade selecionada*/
		if(cidadeSelecionada != null && !cidadeSelecionada.isEmpty()) {
			Cidade cidade = cidadeRepository.getCidadeByNome(cidadeSelecionada);
			entidade.setCidade(cidade);
		}
		
		/*Valida o pais selecionado*/
		if(paisSelecionado != null && !paisSelecionado.isEmpty()) {
			Pais pais = paisRepository.getPaisByNome(paisSelecionado);
			entidade.setPais(pais);
		}else {
			Pais pais = paisRepository.getPaisByNome("BRASIL");
			entidade.setPais(pais);
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
		
		String inscricaoEstadual = "";
		String tipocontribuinte = "";
		String cpfcnpj = "";
		
		/*Valida a inscricao estadual, tipo de contribuinte e cpf/cnpj para pf(0) ou pj(1)*/
		if(entidade.getTipopessoa() == 0) {
			inscricaoEstadual = request.getParameter("inscricaoestadualpf");
			tipocontribuinte = request.getParameter("tipocontribuintepf");
			cpfcnpj = request.getParameter("cpf");
		}else {
			inscricaoEstadual = request.getParameter("inscricaoestadualpj");
			tipocontribuinte = request.getParameter("tipocontribuintepj");
			cpfcnpj = request.getParameter("cnpj");
		}
		
		entidade.setInscricaoestadual(inscricaoEstadual);
		entidade.setTipocontribuinte(Integer.parseInt(tipocontribuinte));
		entidade.setCpfcnpj(cpfcnpj);
		
		entidadeRepository.save(entidade);

		return "redirect:/entidades?tipo="+tipo;
	}
	
	@GetMapping(path="/excluirEntidade")
	public String excluir(@RequestParam(name = "tipo") String tipo, @RequestParam(required = true) Long id) {
		
		entidadeRepository.deleteById(id);

		return "redirect:/entidades?tipo="+tipo;
	}
	
	@GetMapping(path="/editarEntidade")
	@ResponseBody
	public ModelAndView editar(@RequestParam(name = "tipo") String tipo, @RequestParam(required = true) Long id) {
		
		ModelAndView view = new ModelAndView("cadastro/cadastro_entidade");
		
		Optional<Entidade> entidade = entidadeRepository.findById(id);
		Iterable<Estado> estados = estadoRepository.findAll();
		Iterable<Cidade> cidades = cidadeRepository.getCidadesByEstado(entidade.get().getEstado().getCodigo());
		Iterable<Pais> paises = paisRepository.findAll();
		
		view.addObject("tipo", tipo.toUpperCase());
		view.addObject("entidade", entidade.get());
		view.addObject("cidades", cidades);
		view.addObject("estados", estados);
		view.addObject("paises", paises);
		
		return view;
	}
}

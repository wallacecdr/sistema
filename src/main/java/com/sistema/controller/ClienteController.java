package com.sistema.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClienteController {

	@GetMapping("/clientes")
	public String listarClientes() {
		return "lista/lista_clientes";
	}
}

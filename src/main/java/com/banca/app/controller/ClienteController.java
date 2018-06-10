package com.banca.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.banca.app.entity.Cliente;
import com.banca.app.service.IClienteService;


@Controller
@SessionAttributes("cliente")
public class ClienteController {

	@Autowired
	private IClienteService clienteService;

	
	@GetMapping(value="/listar")
	public String listar(Model model) {
		
		model.addAttribute("titulo", "Listar Clientes");
		model.addAttribute("clientes", clienteService.findAll());
		
		return "listar";
		
	}

	@GetMapping(value="/agregar")
	public String agregar(Model model) {
		
		Cliente cliente=new Cliente();
		model.addAttribute("titulo", "Agregar Cliente");
		model.addAttribute("cliente", cliente);
		
		return "agregar";
		
	}
	
	@PostMapping(value="/agregar")
	public String guardar(Model model, @Valid Cliente cliente) {
		
		clienteService.save(cliente);
		return "redirect:/listar";
	}
	
	
}

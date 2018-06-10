package com.banca.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.banca.app.entity.Cuenta;
import com.banca.app.entity.Cliente;
import com.banca.app.service.IClienteService;
import com.banca.app.service.ICuentaService;

@Controller
@SessionAttributes("cuenta")
public class CuentaController {


	@Autowired
	private ICuentaService cuentaService;
	@Autowired
	private IClienteService clienteService;

	
	@GetMapping(value="listarcuenta/{clienteId}")
	public String listar(Model model,@PathVariable(value = "clienteId") Long clienteId) {
		
		
		model.addAttribute("titulo", "Listar Cuentas");
		model.addAttribute("cuentas", cuentaService.listCuentaByCliente(clienteId));
		
		return "listarcuenta" ;
		
	}

	@GetMapping(value="agregarcuenta/{clienteId}")
	public String agregar(@PathVariable(value = "clienteId") Long clienteId, Model model) {
		
		Cliente cliente = clienteService.findById(clienteId);

		Cuenta cuenta=new Cuenta();
		cuenta.setCliente(cliente);
		model.addAttribute("titulo", "Agregar");
		model.addAttribute("cuenta", cuenta);
		
		return "agregarcuenta";
		
	}
	
	
	@PostMapping("/agregarcuenta")
	public String guardar(@Valid Cuenta cuenta, Model model) {


		cuentaService.save(cuenta);
		return "redirect:/listarcuenta/" + cuenta.getCliente().getId();
	}
	
	
}
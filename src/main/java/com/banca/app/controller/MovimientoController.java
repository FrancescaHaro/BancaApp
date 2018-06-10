package com.banca.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.banca.app.entity.Cuenta;
import com.banca.app.entity.Movimiento;
import com.banca.app.service.ICuentaService;
import com.banca.app.service.IMovimientoService;

@Controller
@SessionAttributes("movimiento")
public class MovimientoController {


	@Autowired
	private IMovimientoService movimientoService;
	@Autowired
	private ICuentaService cuentaService;

	
	@GetMapping(value="listarmovimiento/{cuentaId}")
	public String listar(Model model,@PathVariable(value = "cuentaId") Long cuentaId) {
		
		
		model.addAttribute("titulo", "Listar Movimiento");
		model.addAttribute("movimientos", movimientoService.listMovimientoByCliente(cuentaId));
		
		return "listarmovimiento" ;
		
	}


	@GetMapping(value="agregarmovimiento/{cuentaId}")
	public String agregar(@PathVariable(value = "cuentaId") Long cuentaId, Model model) {
		
		Cuenta cuenta = cuentaService.findById(cuentaId);
		Movimiento movimiento = new Movimiento();
		movimiento.setCuenta(cuenta);
		
		model.addAttribute("titulo", "Agregar Movimiento");
		model.addAttribute("movimiento", movimiento);
		return "agregarMovimiento";
	}
	
	@PostMapping(value="agregarmovimiento")
	public String guardar(Model model, @Valid Movimiento movimiento) {
		movimientoService.save(movimiento);
		return "redirect:/listarmovimiento/" + movimiento.getCuenta().getId();
	}
}

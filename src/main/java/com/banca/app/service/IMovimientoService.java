package com.banca.app.service;

import java.util.List;
import com.banca.app.entity.Movimiento;

public interface IMovimientoService {

	public List<Movimiento> findAll();

	public void save(Movimiento movimiento);

	public Movimiento findById(Long id);
	
	public List<Movimiento> listMovimientoByCuenta(Long id);
}

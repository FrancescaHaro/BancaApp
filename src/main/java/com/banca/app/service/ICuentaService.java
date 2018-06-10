package com.banca.app.service;

import java.util.List;

import com.banca.app.entity.Cuenta;

public interface ICuentaService {

	public List<Cuenta> findAll();

	public void save(Cuenta cuenta);

	public Cuenta findById(Long id);
	
	public List<Cuenta> listCuentaByCliente(Long id);
}

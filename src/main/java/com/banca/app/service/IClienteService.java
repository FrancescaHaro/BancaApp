package com.banca.app.service;

import java.util.List;

import com.banca.app.entity.Cliente;


public interface IClienteService {

	public List<Cliente> findAll();

	public void save(Cliente cliente);

	public Cliente findById(Long id);

}

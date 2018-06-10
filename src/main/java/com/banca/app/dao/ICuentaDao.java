package com.banca.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.banca.app.entity.Cuenta;

@Repository
public interface ICuentaDao extends JpaRepository<Cuenta, Long>{

	@Query("select c from Cuenta c where c.cliente.id =?1")
	public List<Cuenta> listCuentaByCliente(Long id);
}
	
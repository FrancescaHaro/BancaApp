package com.banca.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.banca.app.entity.Cliente;

@Repository
public interface IClienteDao  extends JpaRepository<Cliente, Long>{
	

}

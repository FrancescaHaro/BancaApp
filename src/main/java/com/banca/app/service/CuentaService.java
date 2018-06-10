package com.banca.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.banca.app.dao.ICuentaDao;
import com.banca.app.entity.Cuenta;

@Service
public class CuentaService implements ICuentaService {

	@Autowired
	private ICuentaDao cuentaDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Cuenta> findAll() {
		// TODO Auto-generated method stub
		return  cuentaDao.findAll();
	}

	@Override
	@Transactional
	public void save(Cuenta cuenta) {
		cuentaDao.save(cuenta);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Cuenta findById(Long id) {
		return cuentaDao.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Cuenta> listCuentaByCliente(Long id) {
		// TODO Auto-generated method stub
		return cuentaDao.listCuentaByCliente(id);
	}

}

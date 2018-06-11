package com.banca.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.banca.app.dao.IMovimientoDao;
import com.banca.app.entity.Movimiento;

@Service
public class MovimientoService implements IMovimientoService{

	@Autowired
	private IMovimientoDao movimientoDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Movimiento> findAll() {
		// TODO Auto-generated method stub
		return  movimientoDao.findAll();
	}

	@Override
	@Transactional
	public void save(Movimiento movimiento) {
		this.actualizarSaldo(movimiento);
		movimientoDao.save(movimiento);
	}
	
	private void actualizarSaldo(Movimiento movimiento) {
		if(movimiento.getTipo().equalsIgnoreCase("Retiro")) {
			double monto = movimiento.getMonto();
			double saldoAnterior = movimiento.getCuenta().getSaldo();
			movimiento.getCuenta().setSaldo(saldoAnterior - monto);
		}else {
			if(movimiento.getTipo().equalsIgnoreCase("Deposito")) {
				double monto = movimiento.getMonto();
				double saldoAnterior = movimiento.getCuenta().getSaldo();
				movimiento.getCuenta().setSaldo(saldoAnterior + monto);
			}
		}
	}
	

	@Override
	@Transactional(readOnly = true)
	public Movimiento findById(Long id) {
		return movimientoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Movimiento> listMovimientoByCuenta(Long id) {
		// TODO Auto-generated method stub
		return movimientoDao.listMovimientoByCuenta(id);
	}

}

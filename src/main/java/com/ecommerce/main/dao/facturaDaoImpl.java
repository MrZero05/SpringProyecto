package com.ecommerce.main.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import com.ecommerce.main.entities.Factura;

@Component
public class facturaDaoImpl implements ITFactura{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void crearFactura(Factura factura) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarFactura(Factura factura) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Factura> listarFacturasAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Factura getFacturaById(long factId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}

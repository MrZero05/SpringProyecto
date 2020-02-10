package com.ecommerce.main.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecommerce.main.dao.ITFactura;
import com.ecommerce.main.entities.Factura;

@Repository
public class FacturaRepositotyImpl implements ITFacturaRepository{

	@Autowired
	ITFactura daoFactura;

	@Override
	public void crearFactura(Factura factura) throws Exception {
		daoFactura.crearFactura(factura);
		
	}

	@Override
	public void modificarFactura(Factura factura) throws Exception {
		daoFactura.modificarFactura(factura);
		
	}

	@Override
	public List<Factura> listarFacturasAll() throws Exception {
		// TODO Auto-generated method stub
		return daoFactura.listarFacturasAll();
	}

	@Override
	public Factura getFacturaById(long factId) throws Exception {
		// TODO Auto-generated method stub
		return daoFactura.getFacturaById(factId);
	}
	


}

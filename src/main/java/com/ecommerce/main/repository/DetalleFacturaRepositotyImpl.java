package com.ecommerce.main.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecommerce.main.dao.ITDetalleFactura;
import com.ecommerce.main.entities.Detallefactura;

@Repository
public class DetalleFacturaRepositotyImpl implements ITDetalleFacturaRepository{

	@Autowired
	ITDetalleFactura daoDetalleFactura;
	
	@Override
	public List<Detallefactura> listarDetalleFacturaByFactura(long factId) throws Exception {
		// TODO Auto-generated method stub
		return daoDetalleFactura.listarDetalleFacturaByFactura(factId);
	}

}

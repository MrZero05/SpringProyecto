package com.ecommerce.main.dao;

import java.util.List;

import javax.transaction.Transactional;

import com.ecommerce.main.entities.Detallefactura;

public interface ITDetalleFactura {
	List<Detallefactura> listarDetalleFacturaByFactura(long factId) throws Exception;
	@Transactional
	void crearDetalleFactura(Detallefactura detallefactura)throws Exception;
}

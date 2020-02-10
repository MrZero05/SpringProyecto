package com.ecommerce.main.dao;

import java.util.List;

import com.ecommerce.main.entities.Detallefactura;

public interface ITDetalleFactura {
	List<Detallefactura> listarDetalleFacturaByFactura(long factId) throws Exception;
}

package com.ecommerce.main.repository;

import java.util.List;

import com.ecommerce.main.entities.Detallefactura;

public interface ITDetalleFacturaRepository {
	List<Detallefactura> listarDetalleFacturaByFactura(long factId) throws Exception;
}

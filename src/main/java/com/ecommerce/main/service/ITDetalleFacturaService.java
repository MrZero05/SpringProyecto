package com.ecommerce.main.service;

import java.util.List;

import com.ecommerce.main.entities.Detallefactura;

public interface ITDetalleFacturaService {
	List<Detallefactura> listarDetalleFacturaByFactura(long factId) throws Exception;
}

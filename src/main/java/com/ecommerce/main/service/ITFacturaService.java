package com.ecommerce.main.service;

import java.util.List;

import com.ecommerce.main.dto.FacturaRegistrerDTO;
import com.ecommerce.main.entities.Factura;

public interface ITFacturaService {
	void crearFactura (FacturaRegistrerDTO facturaDTO)throws Exception;
	void modificarFactura(Factura factura)throws Exception;
	List<Factura> listarFacturasAll()throws Exception;
	Factura getFacturaById(long factId)throws Exception;
}

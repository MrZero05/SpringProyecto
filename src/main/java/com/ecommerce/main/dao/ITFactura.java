package com.ecommerce.main.dao;

import java.util.List;

import com.ecommerce.main.entities.Factura;

public interface ITFactura {
	void crearFactura (Factura factura)throws Exception;
	void modificarFactura(Factura factura)throws Exception;
	List<Factura> listarFacturasAll()throws Exception;
	Factura getFacturaById(long factId)throws Exception;
}

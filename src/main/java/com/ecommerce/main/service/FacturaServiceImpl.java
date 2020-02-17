package com.ecommerce.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.main.dto.FacturaRegistrerDTO;
import com.ecommerce.main.entities.Factura;
import com.ecommerce.main.repository.ITFacturaRepository;

@Service
public class FacturaServiceImpl implements ITFacturaService{
	
	@Autowired
	ITFacturaRepository repoFacturaService;

	@Override
	public void crearFactura(FacturaRegistrerDTO facturaDTO) throws Exception {
		repoFacturaService.crearFactura(facturaDTO);
		
	}

	@Override
	public void modificarFactura(Factura factura) throws Exception {
		repoFacturaService.modificarFactura(factura);
		
	}

	@Override
	public List<Factura> listarFacturasAll() throws Exception {
		return repoFacturaService.listarFacturasAll();
	}

	@Override
	public Factura getFacturaById(long factId) throws Exception {
		// TODO Auto-generated method stub
		return repoFacturaService.getFacturaById(factId);
	}

}

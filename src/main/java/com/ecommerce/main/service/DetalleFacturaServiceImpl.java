package com.ecommerce.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.main.entities.Detallefactura;
import com.ecommerce.main.repository.ITDetalleFacturaRepository;

@Service
public class DetalleFacturaServiceImpl implements ITDetalleFacturaService {
	
	@Autowired
	ITDetalleFacturaRepository repoDetalleFacturaService;

	@Override
	public List<Detallefactura> listarDetalleFacturaByFactura(long factId) throws Exception {
		// TODO Auto-generated method stub
		return repoDetalleFacturaService.listarDetalleFacturaByFactura(factId);
	}

}

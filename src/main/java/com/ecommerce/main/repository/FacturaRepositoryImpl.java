package com.ecommerce.main.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecommerce.main.dao.ITDetalleFactura;
import com.ecommerce.main.dao.ITFactura;
import com.ecommerce.main.dao.ITProducto;
import com.ecommerce.main.dao.ITUsuario;
import com.ecommerce.main.dto.DetalleFacturaRegistrerDTO;
import com.ecommerce.main.dto.FacturaRegistrerDTO;
import com.ecommerce.main.entities.Detallefactura;
import com.ecommerce.main.entities.Factura;
import com.ecommerce.main.entities.Producto;
import com.ecommerce.main.entities.Usuario;

@Repository
public class FacturaRepositoryImpl implements ITFacturaRepository{

	@Autowired
	ITFactura daoFactura;
	
	@Autowired
	ITUsuario daoUsuario;
	
	@Autowired
	ITProducto daoProducto;
	
	@Autowired
	ITDetalleFactura daoDetalleFactura;

	@Override
	public void crearFactura(FacturaRegistrerDTO facturaDTO) throws Exception {
		Factura factura = new Factura();
		factura.setFactEstado("A");
		factura.setFactFecha(new Date());
		factura.setUserId(daoUsuario.findByUserNombre(facturaDTO.getUserName()));
		factura = daoFactura.crearFactura(factura);
		
		for(DetalleFacturaRegistrerDTO detalleFacturaDTO: facturaDTO.getListDetalleFactura()) {
			if(detalleFacturaDTO.getProdId()!= null) {
			Detallefactura detallefactura = new Detallefactura();
			detallefactura.setDetfactCantidad(detalleFacturaDTO.getDetfactCantidad());
			detallefactura.setDetfactValor(detalleFacturaDTO.getDetfactValor());
			detallefactura.setPorcDescuento(detalleFacturaDTO.getPorcDescuento());
			detallefactura.setPorcValor(detalleFacturaDTO.getPorcValor());
			Producto producto = new Producto();
			producto.setProdId(detalleFacturaDTO.getProdId());
			detallefactura.setProdId(producto);
			detallefactura.setFactId(factura);
			daoDetalleFactura.crearDetalleFactura(detallefactura);
			}
		}
		
		
		
		
		
		
		
		
		
		
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

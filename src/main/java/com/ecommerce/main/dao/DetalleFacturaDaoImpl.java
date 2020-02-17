package com.ecommerce.main.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.ecommerce.main.entities.Detallefactura;

@Component
public class DetalleFacturaDaoImpl implements ITDetalleFactura{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Detallefactura> listarDetalleFacturaByFactura(long factId) throws Exception {
		// TODO Auto-generated method stub
		return em.createQuery("from DetalleFactura where detfactId ="+factId).getResultList();
	}

	@Transactional
	public void crearDetalleFactura(Detallefactura detallefactura) throws Exception {
		// TODO Auto-generated method stub
		em.merge(detallefactura);
	}

}

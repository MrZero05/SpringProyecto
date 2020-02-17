package com.ecommerce.main.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.ecommerce.main.entities.Factura;

@Component
public class FacturaDaoImpl implements ITFactura{

	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public Factura crearFactura(Factura factura) throws Exception {
		// TODO Auto-generated method stub
		Factura f = em.merge(factura);
		em.flush();
		return f;
		
	}

	@Override
	public void modificarFactura(Factura factura) throws Exception {
		// TODO Auto-generated method stub
		em.persist(factura);
		em.flush();
	}

	@Override
	public List<Factura> listarFacturasAll() throws Exception {
		// TODO Auto-generated method stub
		return em.createQuery("from Factura").getResultList();
	}

	@Override
	public Factura getFacturaById(long factId) throws Exception {
		// TODO Auto-generated method stub
		return (Factura) em.createQuery("from Factura where factId="+factId).getResultList().get(0);
	}

}

package com.ecommerce.main.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import com.ecommerce.main.entities.Productos;

@Component
public class ProductoDaoImpl implements ITProducto{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void crearProducto(Productos producto) throws Exception {
		// TODO Auto-generated method stub
		em.merge(producto);
		em.flush();
	}

	@Override
	public void modificarProducto(Productos producto) throws Exception {
		// TODO Auto-generated method stub
		em.persist(producto);
		em.flush();
	}

	@Override
	public List<Productos> listarProductoAll() throws Exception {
		// TODO Auto-generated method stub
		return em.createQuery("from Productos").getResultList();
	}

	@Override
	public Productos getProductoById(long prodId) throws Exception {
		// TODO Auto-generated method stub
		return (Productos) em.createQuery("from Productos where prodId= "+ prodId).getResultList().get(0);
	}

	@Override
	public List<Productos> listarProductoByCategoria(long catId) throws Exception {
		// TODO Auto-generated method stub
		return em.createQuery("from Productos where catId= "+ catId).getResultList();
	}

}

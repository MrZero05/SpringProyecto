package com.ecommerce.main.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import com.ecommerce.main.entities.Productos;

@Component
public class productoDaoImpl implements ITProducto{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void crearProducto(Productos producto) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarProducto(Productos producto) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Productos> listarProductoAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Productos getProductoById(long prodId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}

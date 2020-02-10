package com.ecommerce.main.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecommerce.main.dao.ITProducto;
import com.ecommerce.main.entities.Productos;

@Repository
public class ProductoRepositotyImpl implements ITProductosRepository{

	@Autowired
	ITProducto daoProducto;
	
	@Override
	public void crearProducto(Productos producto) throws Exception {
		// TODO Auto-generated method stub
		daoProducto.crearProducto(producto);
	}

	@Override
	public void modificarProducto(Productos producto) throws Exception {
		// TODO Auto-generated method stub
		daoProducto.modificarProducto(producto);
	}

	@Override
	public List<Productos> listarProductoAll() throws Exception {
		// TODO Auto-generated method stub
		return daoProducto.listarProductoAll();
	}

	@Override
	public Productos getProductoById(long prodId) throws Exception {
		// TODO Auto-generated method stub
		return daoProducto.getProductoById(prodId);
	}

}

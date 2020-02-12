package com.ecommerce.main.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecommerce.main.dao.ITProducto;
import com.ecommerce.main.entities.Producto;

@Repository
public class ProductoRepositoryImpl implements ITProductosRepository{

	@Autowired
	ITProducto daoProducto;
	
	@Override
	public void addProducto(Producto producto) throws Exception {
		// TODO Auto-generated method stub
		daoProducto.addProducto(producto);
	}

	@Override
	public void updateProducto(Producto producto) throws Exception {
		// TODO Auto-generated method stub
		daoProducto.updateProducto(producto);
	}

	@Override
	public List<Producto> listProductoAll() throws Exception {
		// TODO Auto-generated method stub
		return daoProducto.listProductoAll();
	}

	@Override
	public Producto getProductoById(long prodId) throws Exception {
		// TODO Auto-generated method stub
		return daoProducto.getProductoById(prodId);
	}

	@Override
	public List<Producto> listProductoByCategoria(String catNombre) throws Exception {
		// TODO Auto-generated method stub
		return daoProducto.listProductoByCategoria(catNombre);
	}

}

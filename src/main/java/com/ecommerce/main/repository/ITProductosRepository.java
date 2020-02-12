package com.ecommerce.main.repository;

import java.util.List;

import com.ecommerce.main.entities.Producto;

public interface ITProductosRepository {
	public void addProducto (Producto producto)throws Exception;
	public void updateProducto(Producto producto)throws Exception;
	public List<Producto> listProductoAll()throws Exception;
	public Producto getProductoById(long prodId)throws Exception;
	public List<Producto> listProductoByCategoria(String catNombre)throws Exception;
}

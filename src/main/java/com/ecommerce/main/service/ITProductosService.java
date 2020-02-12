package com.ecommerce.main.service;

import java.util.List;

import com.ecommerce.main.entities.Producto;

public interface ITProductosService {
	public void addProducto (Producto producto)throws Exception;
	public void updateProducto(Producto producto)throws Exception;
	public List<Producto> listProductoAll()throws Exception;
	public Producto getProductoById(long prodId)throws Exception;
	public List<Producto> listProductoByCategoria(long catId)throws Exception;
}

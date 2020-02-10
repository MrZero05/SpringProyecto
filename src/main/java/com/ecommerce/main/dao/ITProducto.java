package com.ecommerce.main.dao;

import java.util.List;

import com.ecommerce.main.entities.Productos;


public interface ITProducto {
	void crearProducto (Productos producto)throws Exception;
	void modificarProducto(Productos producto)throws Exception;
	List<Productos> listarProductoAll()throws Exception;
	Productos getProductoById(long prodId)throws Exception;
}

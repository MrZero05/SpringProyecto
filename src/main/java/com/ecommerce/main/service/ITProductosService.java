package com.ecommerce.main.service;

import java.util.List;

import com.ecommerce.main.entities.Productos;

public interface ITProductosService {
	void crearProducto (Productos producto)throws Exception;
	void modificarProducto(Productos producto)throws Exception;
	List<Productos> listarProductoAll()throws Exception;
	Productos getProductoById(long prodId)throws Exception;
	List<Productos> listarProductoByCategoria(long catId)throws Exception;
}

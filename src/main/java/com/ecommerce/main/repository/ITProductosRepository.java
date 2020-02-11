package com.ecommerce.main.repository;

import java.util.List;

import com.ecommerce.main.entities.Productos;

public interface ITProductosRepository {
	void crearProducto (Productos producto)throws Exception;
	void modificarProducto(Productos producto)throws Exception;
	List<Productos> listarProductoAll()throws Exception;
	Productos getProductoById(long prodId)throws Exception;
	List<Productos> listarProductoByCategoria(long catId)throws Exception;
}

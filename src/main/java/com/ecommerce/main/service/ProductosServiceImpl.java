package com.ecommerce.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.main.entities.Productos;
import com.ecommerce.main.repository.ITProductosRepository;

@Service
public class ProductosServiceImpl implements ITProductosService {
	
	@Autowired
	ITProductosRepository repoProductoService;

	@Override
	public void crearProducto(Productos producto) throws Exception {
		repoProductoService.crearProducto(producto);
		
	}

	@Override
	public void modificarProducto(Productos producto) throws Exception {
		repoProductoService.modificarProducto(producto);
		
	}

	@Override
	public List<Productos> listarProductoAll() throws Exception {
		return repoProductoService.listarProductoAll();
	}

	@Override
	public Productos getProductoById(long prodId) throws Exception {
		return repoProductoService.getProductoById(prodId);
	}

}

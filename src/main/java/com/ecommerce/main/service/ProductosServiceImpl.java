package com.ecommerce.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.main.entities.Producto;
import com.ecommerce.main.repository.ITProductosRepository;

@Service
public class ProductosServiceImpl implements ITProductosService {
	
	@Autowired
	ITProductosRepository repoProductoService;

	@Override
	public void addProducto(Producto producto) throws Exception {
		repoProductoService.addProducto(producto);
		
	}

	@Override
	public void updateProducto(Producto producto) throws Exception {
		repoProductoService.updateProducto(producto);
		
	}

	@Override
	public List<Producto> listProductoAll() throws Exception {
		return repoProductoService.listProductoAll();
	}

	@Override
	public Producto getProductoById(long prodId) throws Exception {
		return repoProductoService.getProductoById(prodId);
	}

	@Override
	public List<Producto> listProductoByCategoria(String catNombre) throws Exception {
		
		return repoProductoService.listProductoByCategoria(catNombre);
	}

}

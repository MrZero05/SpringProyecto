package com.ecommerce.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.main.entities.Productos;
import com.ecommerce.main.service.ITProductosService;

@RestController
@RequestMapping("producto")
public class ProductoController {
	
	@Autowired
	ITProductosService serviceProductos;
	
	@GetMapping(value = "/listProducto/{catId}")
	public List<Productos> listarProductosByCategoria(@PathVariable(required = true)Long catId) throws Exception{
		return serviceProductos.listarProductoByCategoria(catId);
	}
	
	@GetMapping(value = "/getProducto/{prodId}")
	public Productos getProductosById(@PathVariable(required = true)Long prodId) throws Exception{
		return serviceProductos.getProductoById(prodId);
	}


}

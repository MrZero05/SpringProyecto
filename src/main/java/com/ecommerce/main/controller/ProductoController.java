package com.ecommerce.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.main.entities.Producto;
import com.ecommerce.main.service.ITProductosService;

@RestController
@RequestMapping("api/producto")
public class ProductoController {
	
	@Autowired
	ITProductosService serviceProductos;
	
	@GetMapping(value = "/listProducto/{catNombre}")
	public List<Producto> listarProductosByCategoria(@PathVariable(required = true)String catNombre) throws Exception{
		return serviceProductos.listProductoByCategoria(catNombre);
	}
	
	@GetMapping(value = "/getProducto/{prodId}")
	public Producto getProductosById(@PathVariable(required = true)Long prodId) throws Exception{
		return serviceProductos.getProductoById(prodId);
	}
	
	@GetMapping(value = "/promoProductList2/{promId}")
	public List<Producto> getPromotionProducts(@PathVariable(required = true)int promId) {
		return serviceProductos.getProductsByPromotionId(promId);
	}
	
	@GetMapping(value = "/promoProductList")
	public List<Producto> getPromotionProducts() {
		return serviceProductos.getPromotionProducts();
	}


}

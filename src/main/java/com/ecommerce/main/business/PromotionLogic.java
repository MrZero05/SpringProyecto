package com.ecommerce.main.business;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.ecommerce.main.entities.Producto;

@Component
public class PromotionLogic {
	
	public List<Producto> getProductsByPromotions(List<Producto> products, int promoId) {
		List<Producto> filterProds = new ArrayList<Producto>();
		filterProds = products.stream().filter(prod -> (prod.getPromId() != null ? prod.getPromId().getPromId() : 0) == promoId ).collect(Collectors.toList());
		return filterProds;
	}
	
	public List<Producto> getValidPromotionProducts(List<Producto> products) {
		List<Producto> filterProds = new ArrayList<Producto>();
		filterProds = products.stream().filter(prod -> (prod.getPromId() != null ? prod.getPromId().getProm() : "X").equalsIgnoreCase("A") ).collect(Collectors.toList());
		return filterProds;
	}

}

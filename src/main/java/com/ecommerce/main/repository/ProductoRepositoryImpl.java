package com.ecommerce.main.repository;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecommerce.main.business.PromotionLogic;
import com.ecommerce.main.dao.ITProducto;
import com.ecommerce.main.entities.Producto;
import com.ecommerce.main.security.JWTAuthorizationFilter;

@Repository
public class ProductoRepositoryImpl implements ITProductosRepository{

	private static final Log LOG = LogFactory.getLog(JWTAuthorizationFilter.class);
	
	@Autowired
	ITProducto daoProducto;
	
	@Autowired
	PromotionLogic promo;
	
	@Override
	public void addProducto(Producto producto) throws Exception {
		// TODO Auto-generated method stub
		daoProducto.addProducto(producto);
	}

	@Override
	public void updateProducto(Producto producto) throws Exception {
		// TODO Auto-generated method stub
		daoProducto.updateProducto(producto);
	}

	@Override
	public List<Producto> listProductoAll() throws Exception {
		// TODO Auto-generated method stub
		return daoProducto.listProductoAll();
	}

	@Override
	public Producto getProductoById(long prodId) throws Exception {
		// TODO Auto-generated method stub
		return daoProducto.getProductoById(prodId);
	}

	@Override
	public List<Producto> listProductoByCategoria(String catNombre) throws Exception {
		// TODO Auto-generated method stub
		return daoProducto.listProductoByCategoria(catNombre);
	}

	@Override
	public List<Producto> getProductsByPromotionId(int promId) {
		List<Producto> prods = new ArrayList<Producto>();
		List<Producto> promoProds = new ArrayList<Producto>();
		
		try {
			prods = daoProducto.listProductoAll();
			promoProds = promo.getProductsByPromotions(prods, promId);
			if(!promoProds.isEmpty()) {
				return promo.getValidPromotionProducts(promoProds);
			}
			return null;
		} catch (Exception e) {
			LOG.error("Error al obtener promoción con id ; " + promId + " " + e);
		}
		return null;
	}

	@Override
	public List<Producto> getPromotionProducts() {
		List<Producto> prods = new ArrayList<Producto>();
		try {
			prods = daoProducto.listProductoAll();
			if(!prods.isEmpty()) {
				return promo.getValidPromotionProducts(prods);
			}
			return null;
		} catch (Exception e) {
			LOG.error("Error al obtener promoción; "+e);
		}
		return null;
	}

}

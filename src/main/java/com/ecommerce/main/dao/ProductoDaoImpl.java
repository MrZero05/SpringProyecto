package com.ecommerce.main.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import com.ecommerce.main.entities.Producto;

@Component
public class ProductoDaoImpl implements ITProducto{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void addProducto(Producto producto) throws Exception {
		// TODO Auto-generated method stub
		em.merge(producto);
		em.flush();
	}

	@Override
	public void updateProducto(Producto producto) throws Exception {
		// TODO Auto-generated method stub
		em.persist(producto);
		em.flush();
	}

	@Override
	public List<Producto> listProductoAll() throws Exception {
		// TODO Auto-generated method stub
		return em.createQuery("from Producto").getResultList();
	}

	@Override
	public Producto getProductoById(long prodId) throws Exception {
		// TODO Auto-generated method stub
		return (Producto) em.createQuery("from Producto where prodId= "+ prodId).getResultList().get(0);

	}

	@Override
	public List<Producto> listProductoByCategoria(String catNombre) throws Exception {
		// TODO Auto-generated method stub
		String hql=  "select p from Producto p inner join Categoria c on c.catId = p.catId where p.catNombre = $1";
		List<Producto> list = em.createQuery(hql).setParameter(1, catNombre).getResultList();
		return list;
	}

}

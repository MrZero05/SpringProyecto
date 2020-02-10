package com.ecommerce.main.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import com.ecommerce.main.entities.Categoria;

@Component
public class categoriaDaoImpl implements ITCategoria{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Categoria> listarCategiraAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}

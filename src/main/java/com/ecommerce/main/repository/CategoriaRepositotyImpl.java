package com.ecommerce.main.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecommerce.main.dao.ITCategoria;
import com.ecommerce.main.entities.Categoria;

@Repository
public class CategoriaRepositotyImpl implements ITCategoriaRepository{

	@Autowired
	ITCategoria daoCategoria;
	
	@Override
	public List<Categoria> listarCategiraAll() throws Exception {
		// TODO Auto-generated method stub
		return daoCategoria.listarCategiraAll();
	}

}

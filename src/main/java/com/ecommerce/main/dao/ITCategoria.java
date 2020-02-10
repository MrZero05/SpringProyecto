package com.ecommerce.main.dao;

import java.util.List;

import com.ecommerce.main.entities.Categoria;


public interface ITCategoria {
	List<Categoria> listarCategiraAll() throws Exception;
}

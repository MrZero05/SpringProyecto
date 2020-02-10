package com.ecommerce.main.service;

import java.util.List;

import com.ecommerce.main.entities.Categoria;

public interface ITCategoriaService {
	List<Categoria> listarCategoriaAll() throws Exception;

}

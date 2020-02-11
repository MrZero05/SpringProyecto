package com.ecommerce.main.repository;

import java.util.List;

import com.ecommerce.main.entities.Categoria;

public interface ITCategoriaRepository {

	List<Categoria> listarCategoriaAll() throws Exception;
}

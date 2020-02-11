package com.ecommerce.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.main.entities.Categoria;
import com.ecommerce.main.repository.ITCategoriaRepository;

@Service
public class CategoriaServiceImpl implements ITCategoriaService {
	
	@Autowired
	ITCategoriaRepository repoCategoriaService;

	@Override
	public List<Categoria> listarCategoriaAll() throws Exception {
		// TODO Auto-generated method stub
		return repoCategoriaService.listarCategiraAll();
	}

}

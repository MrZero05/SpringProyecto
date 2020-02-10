package com.ecommerce.main.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import com.ecommerce.main.entities.Usuarios;

@Component
public class usuarioDaoImpl implements ITUsusario{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Usuarios> listadoUsuariosAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuarios getUsuarioById(long usuId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuarios getUsusarioByNameByPass(String userName, String userPass) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void creaUsuario(Usuarios usuario) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizarUsuario(Usuarios usuario) throws Exception {
		// TODO Auto-generated method stub
		
	}

}

package com.ecommerce.main.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ecommerce.main.entities.Usuarios;

@Service
public class UsuarioServiceImpl implements ITUsuarioService{

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

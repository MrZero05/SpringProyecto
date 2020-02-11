package com.ecommerce.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.main.entities.Usuarios;
import com.ecommerce.main.repository.ITUsuariosRepository;

@Service
public class UsuarioServiceImpl implements ITUsuarioService{
	
	@Autowired
	ITUsuariosRepository repoUsuarioService;

	@Override
	public List<Usuarios> listadoUsuariosAll() throws Exception {
		
		return repoUsuarioService.listadoUsuariosAll();
	}

	@Override
	public Usuarios getUsuarioById(long usuId) throws Exception {
		// TODO Auto-generated method stub
		return repoUsuarioService.getUsuarioById(usuId);
	}

	@Override
	public Usuarios getUsusarioByNameByPass(String userName, String userPass) throws Exception {
		// TODO Auto-generated method stub
		return repoUsuarioService.getUsusarioByNameByPass(userName, userPass);
	}

	@Override
	public void creaUsuario(Usuarios usuario) throws Exception {
		repoUsuarioService.creaUsuario(usuario);		
	}

	@Override
	public void actualizarUsuario(Usuarios usuario) throws Exception {
		repoUsuarioService.actualizarUsuario(usuario);		
	}
}

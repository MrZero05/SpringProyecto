package com.ecommerce.main.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.ecommerce.main.dao.ITUsusario;
import com.ecommerce.main.entities.Usuarios;

@Repository
public class UsuarioRepositotyImpl implements ITUsuariosRepository{

	@Autowired
	ITUsusario daoUsuario;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Override
	public List<Usuarios> listadoUsuariosAll() throws Exception {
		// TODO Auto-generated method stub
		return daoUsuario.listadoUsuariosAll();
	}

	@Override
	public Usuarios getUsuarioById(long usuId) throws Exception {
		// TODO Auto-generated method stub
		return daoUsuario.getUsuarioById(usuId);
	}

	@Override
	public Usuarios getUsusarioByNameByPass(String userName, String userPass) throws Exception {
		// TODO Auto-generated method stub
		return daoUsuario.getUsusarioByNameByPass(userName, userPass);
	}

	@Override
	public void creaUsuario(Usuarios usuario) throws Exception {
		usuario.setUserPassword(encoder.encode(usuario.getUserPassword()));
		daoUsuario.creaUsuario(usuario);
	}

	@Override
	public void actualizarUsuario(Usuarios usuario) throws Exception {
		// TODO Auto-generated method stub
		daoUsuario.actualizarUsuario(usuario);
	}

	@Override
	public Usuarios findByUserNombre(String name) {
		return daoUsuario.findByUserNombre(name);
	}

}

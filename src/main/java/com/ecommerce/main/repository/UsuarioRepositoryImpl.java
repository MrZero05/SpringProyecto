package com.ecommerce.main.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.ecommerce.main.dao.ITUsuario;
import com.ecommerce.main.entities.Usuario;

@Repository
public class UsuarioRepositoryImpl implements ITUsuariosRepository{

	@Autowired
	ITUsuario daoUsuario;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Override
	public List<Usuario> listUsuarioAll() throws Exception {
		// TODO Auto-generated method stub
		return daoUsuario.listUsuarioAll();
	}

	@Override
	public Usuario getUsuarioById(long usuId) throws Exception {
		// TODO Auto-generated method stub
		return daoUsuario.getUsuarioById(usuId);
	}

	@Override
	public Usuario getUsuarioByNameByPass(String userName, String userPass) throws Exception {
		// TODO Auto-generated method stub
		return daoUsuario.getUsuarioByNameByPass(userName, userPass);
	}

	@Override
	public void addUsuario(Usuario usuario) throws Exception {
		usuario.setUserPassword(encoder.encode(usuario.getUserPassword()));
		daoUsuario.addUsuario(usuario);
	}

	@Override
	public void updateUsuario(Usuario usuario) throws Exception {
		// TODO Auto-generated method stub
		daoUsuario.updateUsuario(usuario);
	}

	@Override
	public Usuario findByUserNombre(String name) {
		return daoUsuario.findByUserNombre(name);
	}

}

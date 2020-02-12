package com.ecommerce.main.dao;

import java.util.List;

import com.ecommerce.main.entities.Usuario;

public interface ITUsuario {
	public List<Usuario> listUsuarioAll() throws Exception;
	public Usuario getUsuarioById(long usuId) throws Exception;
	public Usuario getUsuarioByNameByPass(String userName, String userPass) throws Exception;
	public void addUsuario(Usuario usuario) throws Exception;
	public void updateUsuario(Usuario usuario)throws Exception;
	public Usuario findByUserNombre(String name);
}

package com.ecommerce.main.repository;

import java.util.List;

import com.ecommerce.main.entities.Usuarios;

public interface ITUsuariosRepository {
	List<Usuarios> listadoUsuariosAll() throws Exception;
	Usuarios getUsuarioById(long usuId) throws Exception;
	Usuarios getUsusarioByNameByPass(String userName, String userPass) throws Exception;
	void creaUsuario(Usuarios usuario) throws Exception;
	void actualizarUsuario(Usuarios usuario)throws Exception;
}
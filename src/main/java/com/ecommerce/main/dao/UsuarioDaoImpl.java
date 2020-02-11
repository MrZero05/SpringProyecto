package com.ecommerce.main.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import com.ecommerce.main.entities.Usuarios;

@Component
public class UsuarioDaoImpl implements ITUsusario{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Usuarios> listadoUsuariosAll() throws Exception {
		// TODO Auto-generated method stub
		return em.createQuery("from Usuarios").getResultList();
	}

	@Override
	public Usuarios getUsuarioById(long usuId) throws Exception {
		// TODO Auto-generated method stub
		return (Usuarios) em.createQuery("from Usuarios where userId =" + usuId).getResultList().get(0);
	}

	@Override
	public Usuarios getUsusarioByNameByPass(String userName, String userPass) throws Exception {
		// TODO Auto-generated method stub
		return (Usuarios) em.createQuery("from Usuarios where userNombre =" + userName + " and userPassword = "+ userPass).getResultList().get(0);
	}

	@Override
	public void creaUsuario(Usuarios usuario) throws Exception {
		// TODO Auto-generated method stub
		em.merge(usuario);
	}

	@Override
	public void actualizarUsuario(Usuarios usuario) throws Exception {
		// TODO Auto-generated method stub
		em.merge(usuario);
	}

}

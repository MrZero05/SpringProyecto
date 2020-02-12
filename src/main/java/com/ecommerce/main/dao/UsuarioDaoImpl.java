package com.ecommerce.main.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.main.entities.Usuarios;

@Component
public class UsuarioDaoImpl implements ITUsusario{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Usuarios> listadoUsuariosAll() throws Exception {
		// TODO Auto-generated method stub
		 List<Usuarios> result = em.createQuery("from Usuarios").getResultList();
		return result;
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
	@Transactional
	public void creaUsuario(Usuarios usuario) throws Exception {
		// TODO Auto-generated method stub
		em.merge(usuario);
		em.flush();
	}

	@Override
	public void actualizarUsuario(Usuarios usuario) throws Exception {
		// TODO Auto-generated method stub
		em.merge(usuario);
	}

	@Override
	public Usuarios findByUserNombre(String name) {
		return (Usuarios) em.createQuery("from Usuarios where userNombre=" + name ).getResultList().get(0);
	}

}

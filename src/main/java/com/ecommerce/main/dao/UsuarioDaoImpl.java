package com.ecommerce.main.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.main.entities.Usuario;

@Component
public class UsuarioDaoImpl implements ITUsuario{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Usuario> listUsuarioAll() throws Exception {
		// TODO Auto-generated method stub
		 List<Usuario> result = em.createQuery("from Usuario").getResultList();
		return result;
	}

	@Override
	public Usuario getUsuarioById(long usuId) throws Exception {
		// TODO Auto-generated method stub
		return (Usuario) em.createQuery("from Usuario where userId =" + usuId).getResultList().get(0);
	}

	@Override
	public Usuario getUsuarioByNameByPass(String userName, String userPass) throws Exception {
		// TODO Auto-generated method stub
		return (Usuario) em.createQuery("from Usuario where userNombre =" + userName + " and userPassword = "+ userPass).getResultList().get(0);
	}

	@Transactional
	public void addUsuario(Usuario usuario) throws Exception {
		em.merge(usuario);
		em.flush();
	}

	@Override
	public void updateUsuario(Usuario usuario) throws Exception {
		// TODO Auto-generated method stub
		em.merge(usuario);
	}

	@Override
	public Usuario findByUserNombre(String name) {
		String hql = "from Usuario where userNombre = :userNombre";
		Query query = em.createQuery(hql);		
		query.setParameter("userNombre",name); 
		Usuario result = null;
		
		List<Usuario> list = (List<Usuario>) query.getResultList();
		
		if (!list.isEmpty()) {
			result = list.get(0);			
		}
		return result;
	}

}

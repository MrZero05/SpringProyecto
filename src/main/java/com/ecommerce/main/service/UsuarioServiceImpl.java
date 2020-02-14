package com.ecommerce.main.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ecommerce.main.entities.Usuario;
import com.ecommerce.main.repository.ITUsuariosRepository;

@Service
public class UsuarioServiceImpl implements ITUsuarioService, UserDetailsService{
	
	@Autowired
	ITUsuariosRepository repoUsuarioService;

	@Override
	public List<Usuario> listUsuarioAll() throws Exception {
		
		return repoUsuarioService.listUsuarioAll();
	}

	@Override
	public Usuario getUsuarioById(long usuId) throws Exception {
		// TODO Auto-generated method stub
		return repoUsuarioService.getUsuarioById(usuId);
	}

	@Override
	public Usuario getUsuarioByNameByPass(String userName, String userPass) throws Exception {
		// TODO Auto-generated method stub
		return repoUsuarioService.getUsuarioByNameByPass(userName, userPass);
	}

	@Override
	public void addUsuario(Usuario usuario) throws Exception {
		repoUsuarioService.addUsuario(usuario);		
	}

	@Override
	public void updateUsuario(Usuario usuario) throws Exception {
		repoUsuarioService.updateUsuario(usuario);		
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario user = repoUsuarioService.findByUserNombre(username);
		
		List<GrantedAuthority> roles =  new ArrayList<GrantedAuthority>();
		roles.add(new SimpleGrantedAuthority("ADMIN"));
		
		UserDetails userDet = new User(user.getUserNombre(), user.getUserPassword(), roles);
		return userDet;
	}

	@Override
	public Usuario findByUserNombre(String userName) throws Exception {
		return repoUsuarioService.findByUserNombre(userName);
	}
}

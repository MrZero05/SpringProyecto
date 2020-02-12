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

import com.ecommerce.main.entities.Usuarios;
import com.ecommerce.main.repository.ITUsuariosRepository;

@Service
public class UsuarioServiceImpl implements ITUsuarioService, UserDetailsService{
	
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

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuarios user= repoUsuarioService.findByUserNombre(username);
		
		List<GrantedAuthority> roles =  new ArrayList<GrantedAuthority>();
		roles.add(new SimpleGrantedAuthority("ADMIN"));
		
		UserDetails userDet = new User(user.getUserNombre(), user.getUserPassword(), roles);
		return userDet;
	}
}

package com.ecommerce.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.main.dto.UserRegisterDTO;
import com.ecommerce.main.entities.Usuario;
import com.ecommerce.main.service.ITUsuarioService;

@RestController
@RequestMapping("api/user")
public class UsuarioController {
	
	@Autowired
	ITUsuarioService serviceUsuario;
	
	@PostMapping("/register")
	public @ResponseBody void registerUser(@RequestBody UserRegisterDTO userDTO) throws Exception {
		
		System.out.println(userDTO);
		
		Usuario user = new Usuario();
		user.setUserNombre(userDTO.getUsername());
		user.setUserPassword(userDTO.getPassword());
		user.setUserCorreo(userDTO.getEmail());
		serviceUsuario.addUsuario(user);
	}
	
	@GetMapping("/validatoruser")
	public @ResponseBody boolean validUser() throws Exception {
		return false;
	
	
	}
}

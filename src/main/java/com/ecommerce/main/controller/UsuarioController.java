package com.ecommerce.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.main.dto.UserRegisterDTO;
import com.ecommerce.main.dto.ValidateUser;
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
	
	@GetMapping("/validatoruser/{userNombre}")
	public ValidateUser validUser(@PathVariable(required = true)String userNombre ) throws Exception {
		ValidateUser validateUser =  new ValidateUser();
		Usuario resultUser;
		resultUser = serviceUsuario.findByUserNombre(userNombre);		
		if (resultUser != null) {
			validateUser.setCode("01");
			validateUser.setMessage("Ya existe el usuario");
			validateUser.setValue("deny");
			return validateUser;
		} else {
			validateUser.setCode("02");
			validateUser.setMessage("No existe usuario");
			validateUser.setValue("accept");
			return validateUser;
		}
	}
}

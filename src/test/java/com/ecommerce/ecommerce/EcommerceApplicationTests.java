package com.ecommerce.ecommerce;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.ecommerce.main.EcommerceApplication;
import com.ecommerce.main.entities.Usuarios;
import com.ecommerce.main.repository.UsuarioRepositotyImpl;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@SpringBootTest(classes = EcommerceApplication.class)
class EcommerceApplicationTests {
	
	@Autowired
	UsuarioRepositotyImpl repo;
	
	@Autowired
	private BCryptPasswordEncoder encoder;

	@Test
	public void createUsuario() throws Exception {
		Usuarios user = new Usuarios();
		
		user.setUserId(101);
		user.setUserNombre("admin");
		user.setUserPassword(encoder.encode("a1234567"));
		
		repo.creaUsuario(user);
		assertTrue(repo.findByUserNombre("admin").getUserNombre().equalsIgnoreCase(user.getUserNombre()) );
	}

}

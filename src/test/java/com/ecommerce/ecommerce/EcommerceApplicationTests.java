package com.ecommerce.ecommerce;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.ecommerce.main.EcommerceApplication;
import com.ecommerce.main.entities.Usuario;
import com.ecommerce.main.repository.UsuarioRepositoryImpl;

//@RunWith(SpringRunner.class)
@WebAppConfiguration
@SpringBootTest(classes = EcommerceApplication.class)
class EcommerceApplicationTests {
	
	@Autowired
	UsuarioRepositoryImpl repo;
	
	@Autowired
	private BCryptPasswordEncoder encoder;

	@Test
	public void createUsuario() throws Exception {
		Usuario user = new Usuario();
		
		user.setUserId(102);
		user.setUserNombre("sergio");
		user.setUserPassword("a123456");
		
		repo.addUsuario(user);
		System.out.println(repo.findByUserNombre("sergio").getUserPassword());
		assertTrue(repo.findByUserNombre("sergio").getUserPassword().equalsIgnoreCase(user.getUserPassword()) );
	}

}

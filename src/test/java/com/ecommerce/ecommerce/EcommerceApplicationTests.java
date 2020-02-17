package com.ecommerce.ecommerce;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.web.WebAppConfiguration;

import com.ecommerce.main.EcommerceApplication;
import com.ecommerce.main.entities.Usuario;
import com.ecommerce.main.entities.Producto;
import com.ecommerce.main.repository.UsuarioRepositoryImpl;
import com.ecommerce.main.service.ITFacturaService;
import com.ecommerce.main.service.ProductosServiceImpl;
import com.ecommerce.main.service.UsuarioServiceImpl;

//@RunWith(SpringRunner.class)
@WebAppConfiguration
@SpringBootTest(classes = EcommerceApplication.class)
class EcommerceApplicationTests {
	
	@Autowired
	UsuarioRepositoryImpl repoUser;
	
	@Autowired
	UsuarioServiceImpl serviceUser;
	
	@Autowired
	ProductosServiceImpl serviceProd;
	
	@Autowired
	ITFacturaService serviceFactura;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Test 
	public void createUsuarioTest() throws Exception {
		Usuario user = new Usuario();

		user.setUserNombre("test6");
		user.setUserPassword("test12345");
		user.setUserCorreo("test6@gmail.com");

		repoUser.addUsuario(user);
		System.out.println(repoUser.findByUserNombre("test6").getUserPassword());
		assertTrue(repoUser.findByUserNombre("test6").getUserPassword().equalsIgnoreCase(user.getUserPassword()));
	}
	 
	@Test
	public void findUserNombreTest() throws Exception {		
		Usuario result = serviceUser.findByUserNombre("test6");	
		assertTrue(result != null);
	}
	
	@Test
	public void categoryListTest() throws Exception {
		List<Producto> listResult = serviceProd.listProductoByCategoria("child");
		assertTrue(listResult.size() > 0);
	}
	
	@Test
	public void getUserByIdTest() throws Exception {
		Usuario userResult = serviceUser.getUsuarioById(19);		
		assertEquals(userResult.getUserNombre(), "test6");
	}
	
	@Test
	public void crearFacturaTest() throws Exception {
		
	}		
}

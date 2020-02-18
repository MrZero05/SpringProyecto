package com.ecommerce.ecommerce;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.web.WebAppConfiguration;

import com.ecommerce.main.EcommerceApplication;
import com.ecommerce.main.dto.DetalleFacturaRegistrerDTO;
import com.ecommerce.main.dto.FacturaRegistrerDTO;
import com.ecommerce.main.entities.Producto;
import com.ecommerce.main.entities.Usuario;
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
		FacturaRegistrerDTO facturaDTO = new FacturaRegistrerDTO();
		facturaDTO.setUserName("sergio");
		facturaDTO.setFactEstado("A");
		facturaDTO.setFactFecha(new java.util.Date());
		
		DetalleFacturaRegistrerDTO detalleFactura1 = new DetalleFacturaRegistrerDTO();
		detalleFactura1.setProdId(1012);
		detalleFactura1.setDetfactCantidad(1);
		detalleFactura1.setDetfactId(24);
		detalleFactura1.setDetfactValor(7500.0);
		
		DetalleFacturaRegistrerDTO detalleFactura2 = new DetalleFacturaRegistrerDTO();
		detalleFactura2.setProdId(1011);
		detalleFactura2.setDetfactCantidad(1);
		detalleFactura2.setDetfactId(25);
		detalleFactura2.setDetfactValor(6500.0);
		
		List<DetalleFacturaRegistrerDTO> listDetalleFactura = new ArrayList<DetalleFacturaRegistrerDTO>();
		
		listDetalleFactura.add(detalleFactura1);
		listDetalleFactura.add(detalleFactura2);
		
		facturaDTO.setListDetalleFactura(listDetalleFactura);
		serviceFactura.crearFactura(facturaDTO);
		assertTrue(serviceFactura.getFacturaById(25) != null);
		
	}		
}

package com.ecommerce.main.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.main.dao.ITFactura;
import com.ecommerce.main.dao.ITUsuario;
import com.ecommerce.main.dto.DetalleFacturaRegistrerDTO;
import com.ecommerce.main.dto.FacturaRegistrerDTO;
import com.ecommerce.main.entities.Detallefactura;
import com.ecommerce.main.entities.Factura;
import com.ecommerce.main.entities.Producto;
import com.ecommerce.main.entities.Usuario;
import com.ecommerce.main.service.ITFacturaService;

@RestController
@RequestMapping("api/factura")
public class FacturaController {

	
	@Autowired
	ITFacturaService serviceFactura;
		
	
	@PostMapping("/register")
	public @ResponseBody void registrerFactura(@RequestBody FacturaRegistrerDTO facturaDTO) throws Exception {
		serviceFactura.crearFactura(facturaDTO);
	}
}

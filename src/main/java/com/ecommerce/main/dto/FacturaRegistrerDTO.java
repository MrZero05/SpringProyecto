package com.ecommerce.main.dto;


import java.util.Date;
import java.util.List;

import com.ecommerce.main.entities.Usuario;

public class FacturaRegistrerDTO {

    private String factEstado;

    private Date factFecha;

    private String userName;
    
    private List<DetalleFacturaRegistrerDTO> listDetalleFactura;
    
	public String getFactEstado() { 
		return factEstado;
	}

	public void setFactEstado(String factEstado) {
		this.factEstado = factEstado;
	}

	public Date getFactFecha() {
		return factFecha;
	}

	public void setFactFecha(Date factFecha) {
		this.factFecha = factFecha;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<DetalleFacturaRegistrerDTO> getListDetalleFactura() {
		return listDetalleFactura;
	}

	public void setListDetalleFactura(List<DetalleFacturaRegistrerDTO> listDetalleFactura) {
		this.listDetalleFactura = listDetalleFactura;
	}
}

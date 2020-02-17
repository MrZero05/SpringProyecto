package com.ecommerce.main.dto;

import java.io.Serializable;

public class DetalleFacturaRegistrerDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer detfactId;
	private Integer detfactCantidad;
	private Double detfactValor;
	private Integer prodId;
	private Integer porcDescuento;
	private Integer porcValor;

	public Integer getDetfactId() {
		return detfactId;
	}

	public void setDetfactId(Integer detfactId) {
		this.detfactId = detfactId;
	}

	public Integer getDetfactCantidad() {
		return detfactCantidad;
	}

	public void setDetfactCantidad(Integer detfactCantidad) {
		this.detfactCantidad = detfactCantidad;
	}

	public Double getDetfactValor() {
		return detfactValor;
	}

	public void setDetfactValor(Double detfactValor) {
		this.detfactValor = detfactValor;
	}

	public Integer getProdId() {
		return prodId;
	}

	public void setProdId(Integer prodId) {
		this.prodId = prodId;
	}

	public Integer getPorcDescuento() {
		return porcDescuento;
	}

	public void setPorcDescuento(Integer porcDescuento) {
		this.porcDescuento = porcDescuento;
	}

	public Integer getPorcValor() {
		return porcValor;
	}

	public void setPorcValor(Integer porcValor) {
		this.porcValor = porcValor;
	}

}

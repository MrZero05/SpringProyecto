package com.ecommerce.main.entities;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
*
* @author josorio
*/
@Entity
@Table(name = "promocion")
public class Promocion implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
    @Basic(optional = false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "promId")
	private Integer promId;
	
	
	@Size(max = 11)
    @Column(name = "promPorcetaje")
	private Integer promPorcetaje;
	
	
	@Size(max = 2)
    @Column(name = "promEstado")
	private String prom;


	public Integer getPromId() {
		return promId;
	}


	public void setPromId(Integer promId) {
		this.promId = promId;
	}


	public Integer getPromPorcetaje() {
		return promPorcetaje;
	}


	public void setPromPorcetaje(Integer promPorcetaje) {
		this.promPorcetaje = promPorcetaje;
	}


	public String getProm() {
		return prom;
	}


	public void setProm(String prom) {
		this.prom = prom;
	}
	

}

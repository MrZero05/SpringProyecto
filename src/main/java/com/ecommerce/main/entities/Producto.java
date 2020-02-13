/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.main.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author josorio
 */
@Entity
@Table(name = "producto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p")})
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "prodId")
    private Integer prodId;
    @Size(max = 45)
    @Column(name = "prodNombre")
    private String prodNombre;
    @Size(max = 45)
    @Column(name = "prodDescription")
    private String prodDescription;
    @Column(name = "prodPrecio")
    private Integer prodPrecio;
    @Column(name = "prodImageMain")
    private String prodImageMain;
    @Column(name = "prodImage")
    private String prodImage;
    @JoinColumn(name = "catId", referencedColumnName = "catId")
    @ManyToOne
    private Categoria catId;

    public Producto() {
    }

    public Producto(Integer prodId) {
        this.prodId = prodId;
    }

    public Integer getProdId() {
        return prodId;
    }

    public void setProdId(Integer prodId) {
        this.prodId = prodId;
    }

    public String getProdNombre() {
        return prodNombre;
    }

    public void setProdNombre(String prodNombre) {
        this.prodNombre = prodNombre;
    }

    public String getProdDescription() {
        return prodDescription;
    }

    public void setProdDescription(String prodCodigo) {
        this.prodDescription = prodCodigo;
    }

    public Integer getProdPrecio() {
        return prodPrecio;
    }

    public void setProdPrecio(Integer prodPrecio) {
        this.prodPrecio = prodPrecio;
    }

    public Categoria getCatId() {
        return catId;
    }

    public void setCatId(Categoria catId) {
        this.catId = catId;
    }
    
    public String getProdImageMain() {
		return prodImageMain;
	}

	public void setProdImageMain(String prodImageMain) {
		this.prodImageMain = prodImageMain;
	}

	public String getProdImage() {
		return prodImage;
	}

	public void setProdImage(String prodImage) {
		this.prodImage = prodImage;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (prodId != null ? prodId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.prodId == null && other.prodId != null) || (this.prodId != null && !this.prodId.equals(other.prodId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.Producto[ prodId=" + prodId + " ]";
    }
    
}

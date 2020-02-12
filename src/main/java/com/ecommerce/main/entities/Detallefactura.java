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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author josorio
 */
@Entity
@Table(name = "detallefactura")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Detallefactura.findAll", query = "SELECT d FROM Detallefactura d")})
public class Detallefactura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "detfactId")
    private Integer detfactId;
    @Column(name = "detfactCantidad")
    private Integer detfactCantidad;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "detfactValor")
    private Double detfactValor;
    @JoinColumn(name = "factId", referencedColumnName = "factId")
    @ManyToOne
    private Factura factId;
    @JoinColumn(name = "prodId", referencedColumnName = "prodId")
    @ManyToOne
    private Producto prodId;

    public Detallefactura() {
    }

    public Detallefactura(Integer detfactId) {
        this.detfactId = detfactId;
    }

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

    public Factura getFactId() {
        return factId;
    }

    public void setFactId(Factura factId) {
        this.factId = factId;
    }

    public Producto getProdId() {
        return prodId;
    }

    public void setProdId(Producto prodId) {
        this.prodId = prodId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detfactId != null ? detfactId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Detallefactura)) {
            return false;
        }
        Detallefactura other = (Detallefactura) object;
        if ((this.detfactId == null && other.detfactId != null) || (this.detfactId != null && !this.detfactId.equals(other.detfactId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.Detallefactura[ detfactId=" + detfactId + " ]";
    }
    
}

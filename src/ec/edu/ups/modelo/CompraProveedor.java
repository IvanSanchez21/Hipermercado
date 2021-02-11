/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.modelo;

import java.util.Date;

/**
 *
 * @author ronal
 */
public class CompraProveedor {
    private int codigo;
    private String numeroFac;
    private Date fEmision;
    private Proveedor proveedor;

    public CompraProveedor() {
        this.codigo=codigo;
        this.numeroFac=numeroFac;
        this.fEmision=fEmision;
        this.proveedor=new Proveedor();
    }

    public CompraProveedor(int codigo, String numeroFac, Date fEmision, Proveedor proveedor) {
        this.codigo = codigo;
        this.numeroFac = numeroFac;
        this.fEmision = fEmision;
        this.proveedor = proveedor;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNumeroFac() {
        return numeroFac;
    }

    public void setNumeroFac(String numeroFac) {
        this.numeroFac = numeroFac;
    }

    public Date getfEmision() {
        return fEmision;
    }

    public void setfEmision(Date fEmision) {
        this.fEmision = fEmision;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    @Override
    public String toString() {
        return "CompraProveedor{" + "codigo=" + codigo + ", numeroFac=" + numeroFac +
                ", fEmision=" + fEmision + ", proveedor=" + proveedor + '}';
    }
    
    
}

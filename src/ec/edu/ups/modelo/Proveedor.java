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
public class Proveedor {
    private int codigo;
    private String ruc;
    private Date fecha_registro;
    private String razon_social;
    private String correo;

    public Proveedor() {
        this.codigo=codigo;
        this.ruc=ruc;
        this.fecha_registro= new Date();
        this.razon_social=razon_social;
        this.correo=correo;
    }

    public Proveedor(int codigo, String ruc, Date fecha_registro, String razon_social, String correo) {
        this.codigo = codigo;
        this.ruc = ruc;
        this.fecha_registro = fecha_registro;
        this.razon_social = razon_social;
        this.correo = correo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public Date getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(Date fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public String getRazon_social() {
        return razon_social;
    }

    public void setRazon_social(String razon_social) {
        this.razon_social = razon_social;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        return "Proveedor{" + "codigo=" + codigo + ", ruc=" + ruc + ", fecha_registro=" 
                + fecha_registro + ", razon_social=" + razon_social + ", correo=" + correo + '}';
    }
    
    
}

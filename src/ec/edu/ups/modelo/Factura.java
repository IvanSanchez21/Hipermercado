/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.modelo;

import java.util.Date;

/**
 *
 * @author Iván
 */
public class Factura {

    private int idCabecera;
    private String numFactura;
    private Date fechaEmision;
    private int subTotal;
    private int iva;
    private int total;
    private boolean anulado;
    private int idCliente;
    private int idUsuario;

    public Factura() {
    }

    public Factura(int idCabecera, String numFactura, Date fechaEmision, int subTotal, int iva, int total, boolean anulado, int idCliente, int idUsuario) {
        this.idCabecera = idCabecera;
        this.numFactura = numFactura;
        this.fechaEmision = fechaEmision;
        this.subTotal = subTotal;
        this.iva = iva;
        this.total = total;
        this.anulado = anulado;
        this.idCliente = idCliente;
        this.idUsuario = idUsuario;
    }

    public int getIdCabecera() {
        return idCabecera;
    }

    public void setIdCabecera(int idCabecera) {
        this.idCabecera = idCabecera;
    }

    public String getNumFactura() {
        return numFactura;
    }

    public void setNumFactura(String numFactura) {
        this.numFactura = numFactura;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public int getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(int subTotal) {
        this.subTotal = subTotal;
    }

    public int getIva() {
        return iva;
    }

    public void setIva(int iva) {
        this.iva = iva;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public boolean getAnulado() {
        return anulado;
    }

    public void setAnulado(boolean anulado) {
        this.anulado = anulado;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    
}

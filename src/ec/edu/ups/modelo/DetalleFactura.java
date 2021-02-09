/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.modelo;

import java.util.Date;

/**
 *
 * @author ASUS
 */
public class DetalleFactura {
    
    private int idDetalle;
    private int cantidad;
    private int precio;
    private int subTotal;
    private int iva;
    private int idCabecera;
    private int idProducto;

    public DetalleFactura() {
    }

    public DetalleFactura(int idDetalle, int cantidad, int precio, int subTotal, int iva, int idCabecera, int idProducto) {
        this.idDetalle = idDetalle;
        this.cantidad = cantidad;
        this.precio = precio;
        this.subTotal = subTotal;
        this.iva = iva;
        this.idCabecera = idCabecera;
        this.idProducto = idProducto;
    }

    public int getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(int idDetalle) {
        this.idDetalle = idDetalle;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
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

    public int getIdCabecera() {
        return idCabecera;
    }

    public void setIdCabecera(int idCabecera) {
        this.idCabecera = idCabecera;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }
    
}

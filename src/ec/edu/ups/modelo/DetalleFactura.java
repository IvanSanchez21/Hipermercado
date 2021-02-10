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
    private double precio;
    private double subTotal;
    private double iva;
    private double total;
    private int idCabecera;
    private int idProducto;

    public DetalleFactura() {
    }

    public DetalleFactura(int idDetalle, int cantidad, double precio, double subTotal, double iva, double total, int idCabecera, int idProducto) {
        this.idDetalle = idDetalle;
        this.cantidad = cantidad;
        this.precio = precio;
        this.subTotal = subTotal;
        this.iva = iva;
        this.total = total;
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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
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

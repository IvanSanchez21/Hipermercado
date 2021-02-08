/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.modelo;

import java.util.Date;

/**
 *
 * @author Josze
 */
public class Producto {

    private int prd_id;
    private String prd_cbarra;
    private Date prd_fecha_registro;
    private String prd_nombre;
    private double prd_precio;
    private double prd_stock;
    private String prd_estado;
    private String prd_unidad;
    private String prd_origen;
    private boolean prd_iva;
    private Categoria categoria;

    public Producto() {
    }

    public Producto(int prd_id, String prd_cbarra, Date prd_fecha_registro, String prd_nombre, double prd_precio, double prd_stock, String prd_estado, String prd_unidad, String prd_origen, boolean prd_iva, Categoria categoria) {
        this.prd_id = prd_id;
        this.prd_cbarra = prd_cbarra;
        this.prd_fecha_registro = prd_fecha_registro;
        this.prd_nombre = prd_nombre;
        this.prd_precio = prd_precio;
        this.prd_stock = prd_stock;
        this.prd_estado = prd_estado;
        this.prd_unidad = prd_unidad;
        this.prd_origen = prd_origen;
        this.prd_iva = prd_iva;
        this.categoria = categoria;
    }

    public int getPrd_id() {
        return prd_id;
    }

    public void setPrd_id(int prd_id) {
        this.prd_id = prd_id;
    }

    public String getPrd_cbarra() {
        return prd_cbarra;
    }

    public void setPrd_cbarra(String prd_cbarra) {
        this.prd_cbarra = prd_cbarra;
    }

    public Date getPrd_fecha_registro() {
        return prd_fecha_registro;
    }

    public void setPrd_fecha_registro(Date prd_fecha_registro) {
        this.prd_fecha_registro = prd_fecha_registro;
    }

    public String getPrd_nombre() {
        return prd_nombre;
    }

    public void setPrd_nombre(String prd_nombre) {
        this.prd_nombre = prd_nombre;
    }

    public double getPrd_precio() {
        return prd_precio;
    }

    public void setPrd_precio(double prd_precio) {
        this.prd_precio = prd_precio;
    }

    public double getPrd_stock() {
        return prd_stock;
    }

    public void setPrd_stock(double prd_stock) {
        this.prd_stock = prd_stock;
    }

    public String getPrd_estado() {
        return prd_estado;
    }

    public void setPrd_estado(String prd_estado) {
        this.prd_estado = prd_estado;
    }

    public String getPrd_unidad() {
        return prd_unidad;
    }

    public void setPrd_unidad(String prd_unidad) {
        this.prd_unidad = prd_unidad;
    }

    public String getPrd_origen() {
        return prd_origen;
    }

    public void setPrd_origen(String prd_origen) {
        this.prd_origen = prd_origen;
    }

    public boolean getPrd_iva() {
        return prd_iva;
    }

    public void setPrd_iva(boolean prd_iva) {
        this.prd_iva = prd_iva;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    
}

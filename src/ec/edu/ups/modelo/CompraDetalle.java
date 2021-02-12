/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.modelo;

/**
 *
 * @author ronal
 */
public class CompraDetalle {
    private int codigo;
    private int cantidad;
    private int productos;
    private int compraProveedor;
    
    public CompraDetalle(){
        this.codigo=codigo;
        this.cantidad=cantidad;
        this.productos=productos;
        this.compraProveedor=compraProveedor;
    }

    public CompraDetalle(int codigo, int cantidad, int productos, int compraProveedor) {
        this.codigo = codigo;
        this.cantidad = cantidad;
        this.productos = productos;
        this.compraProveedor = compraProveedor;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getProductos() {
        return productos;
    }

    public void setProductos(int productos) {
        this.productos = productos;
    }

    public int getCompraProveedor() {
        return compraProveedor;
    }

    public void setCompraProveedor(int compraProveedor) {
        this.compraProveedor = compraProveedor;
    }

    @Override
    public String toString() {
        return "CompraDetalle{" + "codigo=" + codigo + ", cantidad=" +
                cantidad + ", productos=" + productos + ", compraProveedor=" + compraProveedor + '}';
    }
    
    
}

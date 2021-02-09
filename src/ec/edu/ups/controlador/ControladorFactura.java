/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.modelo.Cliente;
import ec.edu.ups.modelo.DetalleFactura;
import ec.edu.ups.modelo.Factura;
import ec.edu.ups.modelo.Producto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class ControladorFactura {

    private Cliente cliente;
    private ConexionBD conexion;
    private Producto producto;
    private Factura facCabecera;
    private DetalleFactura detalle;
    int r = 0;
    
    
    public int GuardarFacCabecera(){
        PreparedStatement pre = null;
        conexion = new ConexionBD();
        facCabecera = new Factura();
        
        String sql = "";
        sql += "INSERT INTO hip_factura_cabeceras VALUES (fac_cabeceras_seq.nextval,?,?,?,?,?,?,?,?)";
        
        try {
            conexion.conectar();
            pre = conexion.getConexion().prepareStatement(sql);

            pre.setString(1, facCabecera.getNumFactura());
            pre.setDate(2, (java.sql.Date) (Date) facCabecera.getFechaEmision());
            pre.setInt(3, facCabecera.getSubTotal());
            pre.setInt(4, facCabecera.getIva());
            pre.setInt(5, facCabecera.getTotal());
            pre.setBoolean(6, facCabecera.getAnulado());
            pre.setInt(7, facCabecera.getIdCliente());
            pre.setInt(8, facCabecera.getIdUsuario());
            pre.executeUpdate();

            conexion.getConexion().commit();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Fallo al guardar factura " + e.getMessage());
        }
        return r;
    }
    
    public int GuardarFacDetalle(){
        PreparedStatement pre = null;
        conexion = new ConexionBD();
        detalle = new DetalleFactura();
        
        String sql = "";
        sql += "INSERT INTO hip_factura_detalles VALUES (fac_detalles_seq.nextval,?,?,?,?,?,?)";
        
        try {
            conexion.conectar();
            pre = conexion.getConexion().prepareStatement(sql);

            pre.setInt(1, detalle.getCantidad());
            pre.setInt(2, detalle.getPrecio());
            pre.setInt(3, detalle.getSubTotal());
            pre.setInt(4, detalle.getIva());
            pre.setInt(5, detalle.getIdCabecera());
            pre.setInt(6, detalle.getIdProducto());
            
            conexion.getConexion().commit();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Fallo al guardar detalle " + e.getMessage());
        }
        
        return r;
    }
    
    public int IdFactura() {
        conexion = new ConexionBD();
        int idVenta = 0;

        String sql = "SELECT MAX(fac_cab_id) FROM HIP_FACTURA_CABECERAS";

        try {
            conexion.conectar();
            Statement sta = conexion.getConexion().createStatement();
            ResultSet respuesta = sta.executeQuery(sql);

            while (respuesta.next()) {
                idVenta = respuesta.getInt(1) + 1;
                System.out.println("id --- " + idVenta) ;
            }
            conexion.desconectar();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Fallo en la busqueda" + e.getMessage());
        }
        return idVenta;
    }

    public Cliente buscarCliente(String cedula) {
        conexion = new ConexionBD();
        try {
            cliente = new Cliente();
            String sql = "SELECT * FROM HIP_CLIENTES WHERE CLI_CEDULA = '" + cedula + "'";
            //System.out.println(sql);
            conexion.conectar();
            Statement sta = conexion.getConexion().createStatement();
            ResultSet respuesta = sta.executeQuery(sql);
            System.out.println(respuesta);

            while (respuesta.next()) {

                cliente.setCli_id(respuesta.getInt(1));
                cliente.setCli_cedula(respuesta.getString(2));
                cliente.setCli_nombre(respuesta.getString(3));
                cliente.setCli_apellido(respuesta.getString(4));
                cliente.setCli_fecha_registro(respuesta.getDate(5));
                cliente.setCli_direccion(respuesta.getString(6));
                cliente.setCli_tel_convencional(respuesta.getString(7));
                cliente.setCli_celular(respuesta.getString(8));
                cliente.setCli_correo_electronico(respuesta.getString(9));
            }
            conexion.desconectar();
            System.out.println("Persona: " + cliente.getCli_nombre());
            return cliente;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo encontrar a la persona");
            System.out.println("Error: " + ex);
        }
        return null;
    }

    public Producto buscarProducto(String codigo) {
        conexion = new ConexionBD();

        try {
            producto = new Producto();
            String sql = "SELECT * FROM HIP_PRODUCTOS WHERE PRD_CBARRA = '" + codigo + "'";
            System.out.println(sql);
            conexion.conectar();
            Statement sta = conexion.getConexion().createStatement();
            ResultSet respuesta = sta.executeQuery(sql);
            System.out.println(respuesta);

            while (respuesta.next()) {

                producto.setPrd_id(respuesta.getInt(1));
                producto.setPrd_cbarra(respuesta.getString(2));
                producto.setPrd_fecha_registro(respuesta.getDate(3));
                producto.setPrd_nombre(respuesta.getString(4));
                producto.setPrd_precio(respuesta.getDouble(5));
                producto.setPrd_stock(respuesta.getDouble(6));
                producto.setPrd_estado(respuesta.getString(7));
                producto.setPrd_unidad(respuesta.getString(8));
                producto.setPrd_origen(respuesta.getString(9));
                producto.setPrd_iva(respuesta.getBoolean(10));

            }
            conexion.desconectar();
            System.out.println("nombre pro : " + producto.getPrd_nombre());
            return producto;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Producto no encontrado");
            System.out.println("Error: " + ex);
        }
        return null;
    }

}

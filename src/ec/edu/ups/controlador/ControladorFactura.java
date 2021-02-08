/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.modelo.Cliente;
import ec.edu.ups.modelo.Producto;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class ControladorFactura {
    
    private Cliente cliente;
    private ConexionBD conexion;
    private Producto producto;
    
    public Cliente buscarCliente(String cedula) {
        conexion = new ConexionBD();
        System.out.println("metodo encontrado conrolador");
        try {
            cliente = new Cliente();
            String sql = "SELECT * FROM HIP_CLIENTES WHERE CLI_CEDULA = '" + cedula + "'";
            System.out.println(sql);
            conexion.conectar();
            Statement sta = conexion.getConexion().createStatement();
            ResultSet respuesta = sta.executeQuery(sql);
            System.out.println(respuesta);

            while (respuesta.next()) {
                
                cliente.setCli_id(respuesta.getInt(1));
                cliente.setCli_cedula(respuesta.getString(2));
                cliente.setCli_nombre(respuesta.getString(3));
                cliente.setCli_apellido(respuesta.getString(4));
                cliente.setCli_direccion(respuesta.getString(6));
                cliente.setCli_tel_convencional(respuesta.getString(7));
                cliente.setCli_celular(respuesta.getString(8));
                cliente.setCli_correo_electronico(respuesta.getString(9));
            }
            conexion.desconectar();
            System.out.println("Persona: " + cliente);
            return cliente;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo encontrar a la persona");
            System.out.println("Error: " + ex);
        }
        return null;
    }
    
    public Producto buscarProducto(String codigo) {
        conexion = new ConexionBD();
        System.out.println("metodo encontrado conrolador");
        try {
            producto = new Producto();
            String sql = "SELECT * FROM HIP_CLIENTES WHERE CLI_CEDULA = '" + codigo + "'";
            System.out.println(sql);
            conexion.conectar();
            Statement sta = conexion.getConexion().createStatement();
            ResultSet respuesta = sta.executeQuery(sql);
            System.out.println(respuesta);

            while (respuesta.next()) {
                
//                producto.setCli_id(respuesta.getInt(1));
//                producto.setCli_cedula(respuesta.getString(2));
//                producto.setCli_nombre(respuesta.getString(3));
//                producto.setCli_apellido(respuesta.getString(4));
//                producto.setCli_direccion(respuesta.getString(6));
                
            }
            conexion.desconectar();
            System.out.println("Persona: " + cliente);
            return producto;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo encontrar a la persona");
            System.out.println("Error: " + ex);
        }
        return null;
    }
    
    
    
}

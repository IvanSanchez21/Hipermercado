/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.modelo.Cliente;
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
    
    public Cliente buscarCliente(String cedula) {
        try {
            cliente = new Cliente();
            String sql = "SELECT * FROM PERSONA WHERE CEDULA = '" + cedula + "'";
            System.out.println(sql);
            conexion.conectar();
            Statement sta = conexion.getConexion().createStatement();
            ResultSet respuesta = sta.executeQuery(sql);
            System.out.println(respuesta);

            while (respuesta.next()) {
                cliente.setCli_nombre(respuesta.getString(1));
                cliente.setCli_apellido(respuesta.getString(2));
                cliente.setCli_direccion(respuesta.getString(3));
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
    
}

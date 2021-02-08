/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import ec.edu.ups.modelo.Cliente;

/**
 *
 * @author ASUS
 */
public class ControladorVenta {
    
    private Cliente cliente;
    private ConexionBD conexion;
    
    // este método es para búsqueda 
    public Cliente buscarPorCedula(String cedula) {
        try {
            cliente = new Cliente();
            String sql = "SELECT * FROM CLIENTES WHERE CEDULA = '" + cedula + "'";
            conexion.conectar();
            Statement sta = conexion.getConexion().createStatement();
            ResultSet r = sta.executeQuery(sql);
            while(r.next()){
                cliente.setCli_cedula(r.getString(1));
                cliente.setCli_nombre(r.getString(2));
                cliente.setCli_apellido(r.getString(3));
                cliente.setCli_direccion(r.getString(4));
            }
        } catch (Exception e) {
          JOptionPane.showMessageDialog(null, "Problema al buscar: " + e.getMessage(), "Información", JOptionPane.OK_OPTION);

        }
        return cliente;
    }
}
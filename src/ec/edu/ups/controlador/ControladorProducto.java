/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.conexion.Conexion;
import ec.edu.ups.modelo.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author José A. Ramírez C.
 */
public class ControladorProducto {

    public void buscarProducto() {

    }

    public int llenarIdProducto() {
        int llena = 0;
        Connection con = null;
        String sql = "SELECT MAX (prd_id) FROM hip_productos";
        String sql2 = "SELECT productos_seq.nextval FROM dual;";
        try {

            con = Conexion.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            PreparedStatement ps2 = con.prepareStatement(sql2);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                llena = rs.getInt(1) + 1;
                ps2.executeQuery();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            Conexion.close(con);
        }
        return llena;
    }

    public boolean crearProducto(Producto prd) {
        boolean cpb = false;
        return cpb;
    }

    public boolean editarProducto(Producto prd) {
        boolean epb = false;
        return epb;
    }

    public boolean cambiarEstadoProducto(Producto prd) {
        boolean bpb = false;
        return bpb;
    }
}

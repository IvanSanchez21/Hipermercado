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
public class ControladorCategoria {
    public void buscarCategoria() {

    }

    public int llenarIdCategoria() {
        int llena = 0;
        Connection con = null;
        String sql = "SELECT MAX (cat_id) FROM hip_categorias";
        String sql2 = "SELECT categorias_seq.nextval FROM dual;";
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

    public boolean crearCategoria(Producto prd) {
        boolean ccb = false;
        return ccb;
    }

    public boolean editarCategoria(Producto prd) {
        boolean ecb = false;
        return ecb;
    }

    public boolean eliminarCategoria(Producto prd) {
        boolean bcb = false;
        return bcb;
    }
}

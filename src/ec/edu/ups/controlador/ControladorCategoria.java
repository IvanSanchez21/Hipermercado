/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.conexion.ConexionBD;
import ec.edu.ups.modelo.Categoria;
import ec.edu.ups.modelo.Factura;
import ec.edu.ups.modelo.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author José A. Ramírez C.
 */
public class ControladorCategoria {

    private ConexionBD conexion;
    private Categoria categoria;

    public void buscarCategoria() {

    }

    public int llenarIdCategoria() {
        int llena = 0;
        Connection con = null;
        String sql = "SELECT MAX (cat_id) FROM hip_categorias";
        String sql2 = "SELECT categorias_seq.nextval FROM dual;";
        try {

            conexion.conectar();
            PreparedStatement ps = conexion.getConexion().prepareStatement(sql);
            PreparedStatement ps2 = con.prepareStatement(sql2);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                llena = rs.getInt(1) + 1;
                ps2.executeQuery();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            conexion.desconectar();
        }
        return llena;
    }

    public boolean crearCategoria(Categoria ctg) {
        boolean ccb = false;
        PreparedStatement pre = null;
        conexion = new ConexionBD();
        categoria = new Categoria();

        String sql = "";
        sql += "INSERT INTO hip_categorias VALUES (categorias_seq.nextval,?)";

        try {
            conexion.conectar();
            pre = conexion.getConexion().prepareStatement(sql);

            pre.setString(1, categoria.getCat_nombre());
            pre.executeUpdate();

            conexion.getConexion().commit();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al crear categoría:" + e.getMessage());
        }
        return ccb;
    }

    public boolean editarCategoria(Categoria ctg) {
        boolean ecb = false;
        PreparedStatement pre = null;
        conexion = new ConexionBD();
        categoria = new Categoria();

        String sql = "";
        sql += "UPDATE hip_categorias SET CAT_NOMBRE=? WHERE CAT_ID=?";

        try {
            conexion.conectar();
            pre = conexion.getConexion().prepareStatement(sql);

            pre.setString(1, categoria.getCat_nombre());
            pre.setInt(2, categoria.getCat_id());
            pre.executeUpdate();

            conexion.getConexion().commit();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al editar categoría:" + e.getMessage());
        }
        return ecb;
    }

    public boolean eliminarCategoria(Categoria ctg) {
        boolean bcb = false;
        PreparedStatement pre = null;
        conexion = new ConexionBD();
        categoria = new Categoria();

        String sql = "";
        sql += "DELETE FROM hip_categorias WHERE CAT_ID=?";

        try {
            conexion.conectar();
            pre = conexion.getConexion().prepareStatement(sql);

            pre.setInt(1, categoria.getCat_id());
            pre.executeUpdate();

            conexion.getConexion().commit();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar categoría:" + e.getMessage());
        }
        return bcb;
    }
}

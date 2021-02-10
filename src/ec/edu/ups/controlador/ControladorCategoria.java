/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.conexion.ConexionBD;
import ec.edu.ups.modelo.Categoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author José A. Ramírez C.
 */
public class ControladorCategoria {

    private ConexionBD conexion;

    public void buscarCategoria(DefaultTableModel dtm, Object[] o, String ctg) {
        conexion = new ConexionBD();
        try {
            String sql = "SELECT * FROM HIP_CATEGORIAS WHERE UPPER(CAT_NOMBRE) LIKE"
                    + " UPPER('" + ctg + "%') ORDER BY CAT_ID ASC";

            conexion.conectar();
            Statement sta = conexion.getConexion().createStatement();
            ResultSet rs = sta.executeQuery(sql);

            while (rs.next()) {

                o[0] = rs.getString("cat_id");
                o[1] = rs.getString("cat_nombre");

                dtm.addRow(o);

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Categoría no encontrada");
        } finally {
            conexion.desconectar();
        }
    }

    public void llenarTabla(DefaultTableModel dtm, Object[] o) {
        conexion = new ConexionBD();

        String sql = "SELECT * FROM HIP_CATEGORIAS ORDER BY CAT_ID ASC";
        try {
            conexion.conectar();
            PreparedStatement ps = conexion.getConexion().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                o[0] = rs.getString("cat_id");
                o[1] = rs.getString("cat_nombre");

                dtm.addRow(o);

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de llenado");
        } finally {
            conexion.desconectar();
        }
    }

    public int llenarIdCategoria() {
        int llena = 0;
        conexion = new ConexionBD();
        String sql = "SELECT MAX (cat_id) FROM hip_categorias";
        try {

            conexion.conectar();
            PreparedStatement ps = conexion.getConexion().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                llena = rs.getInt(1) + 1;

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Fallo en el autoID:" + ex.getMessage());
        } finally {
            conexion.desconectar();
        }
        return llena;
    }

    public boolean crearCategoria(Categoria ctg) {
        boolean ccb = false;
        PreparedStatement pre = null;
        conexion = new ConexionBD();

        String sql = "";
        sql += "INSERT INTO hip_categorias VALUES (categorias_seq.nextval,?)";

        try {
            conexion.conectar();
            pre = conexion.getConexion().prepareStatement(sql);

            pre.setString(1, ctg.getCat_nombre());
            pre.executeUpdate();

            conexion.getConexion().commit();
            ccb = true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al crear categoría:" + e.getMessage());
        }
        return ccb;
    }

    public boolean editarCategoria(Categoria ctg) {
        boolean ecb = false;
        PreparedStatement pre = null;
        conexion = new ConexionBD();

        String sql = "";
        sql += "UPDATE hip_categorias SET CAT_NOMBRE=? WHERE CAT_ID=?";

        try {
            conexion.conectar();
            pre = conexion.getConexion().prepareStatement(sql);

            pre.setString(1, ctg.getCat_nombre());
            pre.setInt(2, ctg.getCat_id());
            pre.executeUpdate();

            conexion.getConexion().commit();

            ecb = true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al editar categoría:" + e.getMessage());
        }
        return ecb;
    }

    public boolean eliminarCategoria(int ctg) {
        boolean bcb = false;
        PreparedStatement pre = null;
        conexion = new ConexionBD();

        String sql = "";
        sql += "DELETE FROM hip_categorias WHERE CAT_ID=?";

        try {
            conexion.conectar();
            pre = conexion.getConexion().prepareStatement(sql);

            pre.setInt(1, ctg);
            pre.executeUpdate();

            conexion.getConexion().commit();

            bcb = true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar categoría:" + e.getMessage());
        }
        return bcb;
    }
}

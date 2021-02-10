/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.conexion.ConexionBD;
import ec.edu.ups.modelo.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author José A. Ramírez C.
 */
public class ControladorProducto {

    private ConexionBD conexion;

    public void buscarProducto(DefaultTableModel dtm, Object[] o, String prd) {
        conexion = new ConexionBD();
        try {
            String sql = "SELECT * FROM HIP_PRODUCTOS WHERE UPPER(PRD_NOMBRE) LIKE"
                    + " UPPER('" + prd + "%') ORDER BY PRD_ID ASC";

            conexion.conectar();
            Statement sta = conexion.getConexion().createStatement();
            ResultSet rs = sta.executeQuery(sql);

            while (rs.next()) {

                o[0] = rs.getInt("prd_id");
                o[1] = rs.getString("prd_cbarra");
                o[2] = rs.getDate("prd_fecha_registro");
                o[3] = rs.getString("prd_nombre");
                o[4] = rs.getDouble("prd_precio");
                o[5] = rs.getDouble("prd_stock");
                o[6] = rs.getString("prd_estado");
                o[7] = rs.getString("prd_unidad");
                o[8] = rs.getString("prd_origen");
                o[9] = rs.getString("prd_iva");
                o[10] = rs.getInt("hip_categorias_cat_id");

                dtm.addRow(o);

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Producto no encontrado");
        } finally {
            conexion.desconectar();
        }
    }

    public void llenarTabla(DefaultTableModel dtm, Object[] o) {
        conexion = new ConexionBD();

        String sql = "SELECT * FROM HIP_PRODUCTOS ORDER BY PRD_ID ASC";
        try {
            conexion.conectar();
            PreparedStatement ps = conexion.getConexion().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                o[0] = rs.getInt("prd_id");
                o[1] = rs.getString("prd_cbarra");
                o[2] = rs.getDate("prd_fecha_registro");
                o[3] = rs.getString("prd_nombre");
                o[4] = rs.getDouble("prd_precio");
                o[5] = rs.getDouble("prd_stock");
                o[6] = rs.getString("prd_estado");
                o[7] = rs.getString("prd_unidad");
                o[8] = rs.getString("prd_origen");
                o[9] = rs.getString("prd_iva");
                o[10] = rs.getInt("hip_categorias_cat_id");

                dtm.addRow(o);

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de llenado");
        } finally {
            conexion.desconectar();
        }
    }

    public int llenarIdProducto() {
        int llena = 0;
        conexion = new ConexionBD();
        String sql = "SELECT MAX (prd_id) FROM hip_productos";
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

    public boolean crearProducto(Producto prd) {
        boolean cpb = false;
        PreparedStatement pre = null;
        conexion = new ConexionBD();

        String sql = "";
        sql += "INSERT INTO hip_productos VALUES (productos_seq.nextval,?,?,?,"
                + "?,?,?,?,?,?,?)";

        try {
            conexion.conectar();
            pre = conexion.getConexion().prepareStatement(sql);

            pre.setString(1, prd.getPrd_cbarra());
            pre.setDate(2, (java.sql.Date) (Date) prd.getPrd_fecha_registro());
            pre.setString(3, prd.getPrd_nombre());
            pre.setDouble(4, prd.getPrd_precio());
            pre.setDouble(5, prd.getPrd_stock());
            pre.setString(6, prd.getPrd_estado());
            pre.setString(7, prd.getPrd_unidad());
            pre.setString(8, prd.getPrd_origen());
            pre.setBoolean(9, prd.getPrd_iva());
            pre.setInt(10, prd.getCategoria().getCat_id());
            pre.executeUpdate();

            conexion.getConexion().commit();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al crear producto:"
                    + e.getMessage());
        }
        return cpb;
    }

    public boolean editarProducto(Producto prd) {
        boolean epb = false;
        PreparedStatement pre = null;
        conexion = new ConexionBD();
        String sql = "";
        sql += "UPDATE hip_productos SET PRD_CBARRA=?, PRD_NOMBRE=?, "
                + "PRD_PRECIO=?, PRD_STOCK=?, PRD_UNIDAD=?, PRD_ORIGEN=?,"
                + " PRD_IVA=?, HIP_CATEGORIAS_CAT_ID=? WHERE PRD_ID=?";

        try {
            conexion.conectar();
            pre = conexion.getConexion().prepareStatement(sql);

            pre.setString(1, prd.getPrd_cbarra());
            pre.setString(2, prd.getPrd_nombre());
            pre.setDouble(3, prd.getPrd_precio());
            pre.setDouble(4, prd.getPrd_stock());
            pre.setString(5, prd.getPrd_unidad());
            pre.setString(6, prd.getPrd_origen());
            pre.setBoolean(7, prd.getPrd_iva());
            pre.setInt(8, prd.getCategoria().getCat_id());
            pre.setInt(9, prd.getPrd_id());
            pre.executeUpdate();

            conexion.getConexion().commit();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al editar producto:"
                    + e.getMessage());
        }
        return epb;
    }

    public boolean cambiarEstadoProducto(int prd) {
        boolean bpb = false;
        PreparedStatement pre = null;
        conexion = new ConexionBD();

        String sql = "";
        sql += "UPDATE hip_productos SET PRD_ESTADO=? WHERE PRD_ID=?";

        try {
            conexion.conectar();
            pre = conexion.getConexion().prepareStatement(sql);

            pre.setString(1, "p");
            pre.setInt(2, prd);
            pre.executeUpdate();

            conexion.getConexion().commit();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al cambiar estado del"
                    + " producto:" + e.getMessage());
        }
        return bpb;
    }
}

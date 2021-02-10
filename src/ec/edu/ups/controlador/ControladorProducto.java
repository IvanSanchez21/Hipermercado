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
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author José A. Ramírez C.
 */
public class ControladorProducto {

    private ConexionBD conexion;
    private Producto producto;

    public void buscarProducto() {

    }

    public int llenarIdProducto() {
        int llena = 0;
        Connection con = null;
        String sql = "SELECT MAX (prd_id) FROM hip_productos";
        String sql2 = "SELECT productos_seq.nextval FROM dual;";
        try {

            conexion.conectar();
            PreparedStatement ps = conexion.getConexion().prepareStatement(sql);
            PreparedStatement ps2 = conexion.getConexion().prepareStatement(sql2);
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

    public boolean crearProducto(Producto prd) {
        boolean cpb = false;
        PreparedStatement pre = null;
        conexion = new ConexionBD();
        producto = new Producto();

        String sql = "";
        sql += "INSERT INTO hip_productos VALUES (productos_seq.nextval,?,?,?,"
                + "?,?,?,?,?,?,?)";

        try {
            conexion.conectar();
            pre = conexion.getConexion().prepareStatement(sql);

            pre.setString(1, producto.getPrd_cbarra());
            pre.setDate(2, (java.sql.Date) (Date) producto.getPrd_fecha_registro());
            pre.setString(3, producto.getPrd_nombre());
            pre.setDouble(4, producto.getPrd_precio());
            pre.setDouble(5, producto.getPrd_stock());
            pre.setString(6, producto.getPrd_estado());
            pre.setString(7, producto.getPrd_unidad());
            pre.setString(8, producto.getPrd_origen());
            pre.setBoolean(9, producto.getPrd_iva());
            pre.setInt(10, producto.getCategoria().getCat_id());
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
        producto = new Producto();
        String sql = "";
        sql += "UPDATE hip_productos SET PRD_CBARRA=?, PRD_NOMBRE=?, "
                + "PRD_PRECIO=?, PRD_STOCK=?, PRD_UNIDAD=?, PRD_ORIGEN=?,"
                + " PRD_IVA=?, HIP_CATEGORIAS_CAT_ID=? WHERE PRD_ID=?";

        try {
            conexion.conectar();
            pre = conexion.getConexion().prepareStatement(sql);

            pre.setString(1, producto.getPrd_cbarra());
            pre.setString(2, producto.getPrd_nombre());
            pre.setDouble(3, producto.getPrd_precio());
            pre.setDouble(4, producto.getPrd_stock());
            pre.setString(5, producto.getPrd_unidad());
            pre.setString(6, producto.getPrd_origen());
            pre.setBoolean(7, producto.getPrd_iva());
            pre.setInt(8, producto.getCategoria().getCat_id());
            pre.setInt(9, producto.getPrd_id());
            pre.executeUpdate();

            conexion.getConexion().commit();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al editar producto:" 
                    + e.getMessage());
        }
        return epb;
    }

    public boolean cambiarEstadoProducto(Producto prd) {
        boolean bpb = false;
        PreparedStatement pre = null;
        conexion = new ConexionBD();
        producto = new Producto();
        String sql = "";
        sql += "UPDATE hip_productos SET PRD_ESTADO=? WHERE PRD_ID=?";

        try {
            conexion.conectar();
            pre = conexion.getConexion().prepareStatement(sql);

            pre.setString(1, producto.getPrd_estado());
            pre.setInt(2, producto.getPrd_id());
            pre.executeUpdate();

            conexion.getConexion().commit();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al cambiar estado del"
                    + " producto:" + e.getMessage());
        }
        return bpb;
    }
}

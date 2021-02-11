/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.conexion.ConexionBD;
import ec.edu.ups.modelo.Proveedor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ronal
 */
public class controladorProveedor {
    private ConexionBD conexion;
    
    public boolean crearProveedor(Proveedor pro) {
        conexion = new ConexionBD();
        System.out.println(pro.getCodigo());
        System.out.println(pro.getRuc());
        System.out.println(pro.getRazon_social());
        System.out.println(pro.getCorreo());
        boolean r = false;
        String sql = "";
        sql += "INSERT INTO hip_proveedores VALUES (proveedores_seq.nextval,?,?,?,?)";

        try {
            conexion.conectar();
            PreparedStatement ps = conexion.getConexion().prepareStatement(sql);
            ps.setString(1, pro.getRuc());
            ps.setDate(2, (java.sql.Date) (Date) pro.getFecha_registro());
            ps.setString(3, pro.getRazon_social());
            ps.setString(4, pro.getCorreo());

            //ResultSet rs=ps.executeQuery();
            ps.executeQuery();
            //actualizarAuto(form.getAut_id(),nomSuc);
            r = true;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.desconectar();
        }

        return r;
    }
    
     public int llenarId() {
        int llena = 0;
        boolean ban = false;
        conexion = new ConexionBD();
        String sql = "SELECT MAX (pro_id) FROM hip_proveedores";
        try {

            conexion.conectar();
            PreparedStatement ps = conexion.getConexion().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                llena = rs.getInt(1) + 1;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            conexion.desconectar();
        }
        return llena;
    }
     
    public void llenarTabla(DefaultTableModel dtm, Object[] o) {
        conexion = new ConexionBD();

        String sql = "SELECT * FROM HIP_PROVEEDORES ORDER BY PRO_ID ASC";;
        try {
            conexion.conectar();
            PreparedStatement ps = conexion.getConexion().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                //String ObjetoS[]=new String [8];
                o[0] = rs.getString("pro_id");
                o[1] = rs.getString("pro_ruc");
                o[2] = rs.getDate("pro_fecha_registro");
                o[3] = rs.getString("pro_razon_social");
                o[4] = rs.getString("pro_correo_electronico");

                dtm.addRow(o);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.desconectar();
        }
    }
    
    public void filtroTabla(DefaultTableModel dtm, Object[] o) {
        conexion = new ConexionBD();

        try {
            String sql = "SELECT * FROM HIP_PROVEEDORES "+ " ORDER BY PRO_ID ASC";
            conexion.conectar();
            Statement sta = conexion.getConexion().createStatement();
            ResultSet rs = sta.executeQuery(sql);

            while (rs.next()) {

                o[0] = rs.getInt("pro_id");
                o[1] = rs.getString("pro_ruc");
                o[2] = rs.getDate("pro_fecha_registro");
                o[3] = rs.getString("pro_razon_social");
                o[4] = rs.getDouble("pro_correo_electronico");
                dtm.addRow(o);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Proveedor no encontrado");
        } finally {
            conexion.desconectar();
        }
    }
    
    public boolean actualizarProveedor(Proveedor pro) {

        System.out.println(pro.getCodigo());
        System.out.println(pro.getRuc());
        System.out.println(pro.getRazon_social());
        System.out.println(pro.getCorreo());
        boolean r = false;
        conexion = new ConexionBD();
        
        String sql = "";
        sql += "UPDATE hip_proveedores SET PRO_RUC=?, PRO_FECHA_REGISTRO=?, "
                + "PRO_RAZON_SOCIAL=?, PRO_CORREO_ELECTRONICO=?";
        try {
            conexion.conectar();
            PreparedStatement ps = conexion.getConexion().prepareStatement(sql);
            ps.setString(1, pro.getRuc());
            ps.setDate(2, (java.sql.Date) (Date) pro.getFecha_registro());
            ps.setString(3, pro.getRazon_social());
            ps.setString(4, pro.getCorreo());
            ResultSet rs = ps.executeQuery();

            r = true;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.desconectar();
        }

        return r;
    }
    
     public boolean eliminarProveedor(int prd) {
        boolean bpb = false;
        PreparedStatement pre = null;
        conexion = new ConexionBD();

        String sql = "";
        sql += "DELETE FROM hip_proveedores WHERE PRO_ID=?";

        try {
            conexion.conectar();
            pre = conexion.getConexion().prepareStatement(sql);

            pre.setInt(1, prd);
            pre.executeUpdate();

            conexion.getConexion().commit();

            bpb = true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar proveedor:"
                    + e.getMessage());
        }
        return bpb;
    }
}

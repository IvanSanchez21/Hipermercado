/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.conexion.ConexionBD;
import ec.edu.ups.modelo.Categoria;
import ec.edu.ups.modelo.Producto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author José A. Ramírez C.
 */
public class ControladorProducto {

    private ConexionBD conexion;
    private String sent;

    public String llenarCodBarras(Categoria categoria) {
        String cBarra = "";
        String inicio = "101";
        String numCat = String.format("%02d", categoria.getCat_id());
        int llena = 0;
        conexion = new ConexionBD();
        String sql = "SELECT COUNT (prd_id) FROM hip_productos"
                + " WHERE HIP_CATEGORIAS_CAT_ID = '" + categoria.getCat_id() + "'";
        try {

            conexion.conectar();
            PreparedStatement ps = conexion.getConexion().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                llena = rs.getInt(1) + 1;
                String cantPro = String.format("%04d", llena);

                cBarra = inicio + numCat + cantPro;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Fallo en el autoCodBarras:" + ex.getMessage());
        } finally {
            conexion.desconectar();
        }

        return cBarra;
    }

    public ArrayList<Categoria> llenarCombo() {

        conexion = new ConexionBD();

        try {
            String sql = "SELECT * FROM HIP_CATEGORIAS ORDER BY CAT_ID ASC";

            conexion.conectar();
            Statement sta = conexion.getConexion().createStatement();
            ResultSet rs = sta.executeQuery(sql);
            ArrayList<Categoria> dato = new ArrayList<>();

            if (rs.next()) {
                do {
                    Categoria listaTemp = new Categoria(rs.getInt(1), rs.getString(2));

                    dato.add(listaTemp);

                } while (rs.next());
                return dato;

            } else {
                return null;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al cargar categorías");
            return null;
        } finally {
            conexion.desconectar();
        }

    }

    public void buscarProducto(DefaultTableModel dtm, Object[] o, String prd) {
        conexion = new ConexionBD();
        try {
            String sql = "SELECT * FROM HIP_PRODUCTOS ";
            String sql2 = " UPPER(PRD_NOMBRE) LIKE"
                    + " UPPER('" + prd + "%') ORDER BY PRD_ID ASC";
            if (sent.isEmpty()) {
                sql = sql + sent + " WHERE " + sql2;
            } else {
                sql = sql + sent + " AND " + sql2;
            }

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
                if (rs.getString("prd_estado").equals("a")) {
                    o[6] = "Activo";
                } else {
                    o[6] = "Pasivo";
                }
                o[7] = rs.getString("prd_unidad");
                if (rs.getString("prd_origen").equals("n")) {
                    o[8] = "Nacional";
                } else {
                    o[8] = "Extranjero";
                }
                if (rs.getString("prd_iva").equals("t")) {
                    o[9] = "Si";
                } else {
                    o[9] = "No";
                }
                o[10] = rs.getInt("hip_categorias_cat_id");

                dtm.addRow(o);

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Producto no encontrado");
        } finally {
            conexion.desconectar();
        }
    }

    public void filtroTabla(DefaultTableModel dtm, Object[] o, String est, String iva) {
        conexion = new ConexionBD();
        sent = "";
        try {
            if (est.equalsIgnoreCase("activo") && iva.equalsIgnoreCase("todos")) {
                sent = " WHERE PRD_ESTADO = 'a' ";
            } else if (est.equalsIgnoreCase("PASIVO") && iva.equalsIgnoreCase("todos")) {
                sent = " WHERE PRD_ESTADO = 'p' ";
            } else if (est.equalsIgnoreCase("ACTIVO") && iva.equalsIgnoreCase("CON IVA")) {
                sent = " WHERE PRD_ESTADO = 'a' AND PRD_IVA = 't' ";
            } else if (est.equalsIgnoreCase("PASIVO") && iva.equalsIgnoreCase("CON IVA")) {
                sent = " WHERE PRD_ESTADO = 'p' AND PRD_IVA = 't' ";
            } else if (est.equalsIgnoreCase("TODOS") && iva.equalsIgnoreCase("CON IVA")) {
                sent = " WHERE PRD_IVA = 't' ";
            } else if (est.equalsIgnoreCase("ACTIVO") && iva.equalsIgnoreCase("SIN IVA")) {
                sent = " WHERE PRD_ESTADO = 'a' AND PRD_IVA = 'f' ";
            } else if (est.equalsIgnoreCase("PASIVO") && iva.equalsIgnoreCase("SIN IVA")) {
                sent = " WHERE PRD_ESTADO = 'p' AND PRD_IVA = 'f' ";
            } else if (est.equalsIgnoreCase("TODOS") && iva.equalsIgnoreCase("SIN IVA")) {
                sent = " WHERE PRD_IVA = 'f' ";
            } else {
                sent = "";
            }

            String sql = "SELECT * FROM HIP_PRODUCTOS " + sent + " ORDER BY PRD_ID ASC";
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
                if (rs.getString("prd_estado").equals("a")) {
                    o[6] = "Activo";
                } else {
                    o[6] = "Pasivo";
                }
                o[7] = rs.getString("prd_unidad");
                if (rs.getString("prd_origen").equals("n")) {
                    o[8] = "Nacional";
                } else {
                    o[8] = "Extranjero";
                }
                if (rs.getString("prd_iva").equals("t")) {
                    o[9] = "Si";
                } else {
                    o[9] = "No";
                }
                o[10] = rs.getInt("hip_categorias_cat_id");

                dtm.addRow(o);

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Productos no encontrados");
        } finally {
            conexion.desconectar();
        }
    }

//    public void llenarTabla(DefaultTableModel dtm, Object[] o) {
//        conexion = new ConexionBD();
//
//        String sql = "SELECT * FROM HIP_PRODUCTOS ORDER BY PRD_ID ASC";
//        try {
//            conexion.conectar();
//            PreparedStatement ps = conexion.getConexion().prepareStatement(sql);
//            ResultSet rs = ps.executeQuery();
//
//            while (rs.next()) {
//
//                o[0] = rs.getInt("prd_id");
//                o[1] = rs.getString("prd_cbarra");
//                o[2] = rs.getDate("prd_fecha_registro");
//                o[3] = rs.getString("prd_nombre");
//                o[4] = rs.getDouble("prd_precio");
//                o[5] = rs.getDouble("prd_stock");
//                if (rs.getString("prd_estado").equals("a")) {
//                    o[6] = "Activo";
//                } else {
//                    o[6] = "Pasivo";
//                }
//                o[7] = rs.getString("prd_unidad");
//                if (rs.getString("prd_origen").equals("n")) {
//                    o[8] = "Nacional";
//                } else {
//                    o[8] = "Extranjero";
//                }
//                if (rs.getString("prd_iva").equals("t")) {
//                    o[9] = "Si";
//                } else {
//                    o[9] = "No";
//                }
//                o[10] = rs.getInt("hip_categorias_cat_id");
//
//                dtm.addRow(o);
//
//            }
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Error de llenado");
//        } finally {
//            conexion.desconectar();
//        }
//    }
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
            if (prd.getPrd_iva() == true) {
                pre.setString(9, "t");
            } else {
                pre.setString(9, "f");
            }
            pre.setInt(10, prd.getCategoria().getCat_id());
            pre.executeUpdate();

            conexion.getConexion().commit();

            cpb = true;
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
            if (prd.getPrd_iva() == true) {
                pre.setString(7, "t");
            } else {
                pre.setString(7, "f");
            }
            pre.setInt(8, prd.getCategoria().getCat_id());
            pre.setInt(9, prd.getPrd_id());
            pre.executeUpdate();

            conexion.getConexion().commit();
            epb = true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al editar producto:"
                    + e.getMessage());
        }
        return epb;
    }

    public boolean cambiarEstadoProducto(Producto prd) {
        boolean cepb = false;
        PreparedStatement pre = null;
        conexion = new ConexionBD();

        String sql = "";
        sql += "UPDATE hip_productos SET PRD_ESTADO=? WHERE PRD_ID=?";

        try {
            conexion.conectar();
            pre = conexion.getConexion().prepareStatement(sql);

            if (prd.getPrd_estado().equalsIgnoreCase("activo")) {
                pre.setString(1, "p");
                pre.setInt(2, prd.getPrd_id());
                pre.executeUpdate();
            } else if (prd.getPrd_estado().equalsIgnoreCase("pasivo")) {
                pre.setString(1, "a");
                pre.setInt(2, prd.getPrd_id());
                pre.executeUpdate();
            }

            conexion.getConexion().commit();

            cepb = true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al cambiar estado del"
                    + " producto:" + e.getMessage());
        }
        return cepb;
    }

    public boolean eliminarProducto(int prd) {
        boolean bpb = false;
        PreparedStatement pre = null;
        conexion = new ConexionBD();

        String sql = "";
        sql += "DELETE FROM hip_productos WHERE PRD_ID=?";

        try {
            conexion.conectar();
            pre = conexion.getConexion().prepareStatement(sql);

            pre.setInt(1, prd);
            pre.executeUpdate();

            conexion.getConexion().commit();

            bpb = true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar producto:"
                    + e.getMessage());
        }
        return bpb;
    }
}

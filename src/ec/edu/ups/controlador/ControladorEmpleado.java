/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.conexion.ConexionBD;
import ec.edu.ups.modelo.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ronal
 */
public class ControladorEmpleado {

    private ConexionBD conexion;
    private String sent;

    public boolean crearUsuario(Usuario emp) {
        conexion = new ConexionBD();
        PreparedStatement ps = null;

        boolean r = false;
        String sql = "";
        sql += "INSERT INTO hip_usuarios VALUES (usuarios_seq.nextval,?,?,?,?,?,?,?,?)";

        try {
            conexion.conectar();
            ps = conexion.getConexion().prepareStatement(sql);
            ps.setString(1, emp.getUsu_cedula());
            ps.setString(2, emp.getUsu_nombre());
            ps.setString(3, emp.getUsu_apellido());
            ps.setString(4, emp.getUsu_direccion());
            ps.setString(5, emp.getUsu_usuario());
            ps.setString(6, emp.getUsu_contrasenia());
            if (emp.getUsu_admin().equalsIgnoreCase("administrador")) {
                ps.setString(7, "t");
            } else {
                ps.setString(7, "f");
            }
            ps.setString(8, "f");

            //ResultSet rs=ps.executeQuery();
            ps.executeUpdate();
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
        String sql = "SELECT MAX (usu_id) FROM hip_usuarios";
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

    public void llenarTabla(DefaultTableModel dtm, Object[] o, String est) {
        conexion = new ConexionBD();

        try {
            if (est.equalsIgnoreCase("activo")) {
                sent = " WHERE usu_estado = 'f' ";
            } else if (est.equalsIgnoreCase("PASIVO")) {
                sent = " WHERE usu_estado = 't' ";
            } else {
                sent = "";
            }

            String sql = " SELECT * FROM hip_usuarios " + sent + " order by usu_id asc";
            conexion.conectar();
            PreparedStatement ps = conexion.getConexion().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                //String ObjetoS[]=new String [8];
                o[0] = rs.getString(1);
                o[1] = rs.getString(2);
                o[2] = rs.getString(3);
                o[3] = rs.getString(4);
                o[4] = rs.getString(5);
                o[5] = rs.getString(6);
                if (rs.getString(8).equals("f")) {
                    o[6] = "Empleado";
                } else {
                    o[6] = "Administrador";
                }
                if (rs.getString(9).equals("f")) {
                    o[7] = "Activo";
                } else {
                    o[7] = "Pasivo";
                }

                dtm.addRow(o);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.desconectar();
        }
    }

    public void filtro(DefaultTableModel dtm, Object[] o, String emp) {
        System.out.println(emp);

        conexion = new ConexionBD();

        try {
            String sql = " SELECT * FROM hip_usuarios ";
            String sql2 = " UPPER(usu_cedula) LIKE"
                    + " UPPER('" + emp + "%') ORDER BY usu_id ASC";
            if (sent.isEmpty()) {
                sql = sql + sent + " WHERE " + sql2;
            } else {
                sql = sql + sent + " AND " + sql2;
            }
            conexion.conectar();
            PreparedStatement ps = conexion.getConexion().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                //String ObjetoS[]=new String [8];
                o[0] = rs.getString(1);
                o[1] = rs.getString(2);
                o[2] = rs.getString(3);
                o[3] = rs.getString(4);
                o[4] = rs.getString(5);
                o[5] = rs.getString(6);
                if (rs.getString(8).equals("f")) {
                    o[6] = "Empleado";
                } else {
                    o[6] = "Administrador";
                }
                if (rs.getString(9).equals("f")) {
                    o[7] = "Activo";
                } else {
                    o[7] = "Pasivo";
                }

                dtm.addRow(o);

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.desconectar();
        }
    }

    public boolean cambiarEstadoUsu(Usuario usu) {
        boolean cepb = false;
        PreparedStatement pre = null;
        conexion = new ConexionBD();

        String sql = "";
        sql += "UPDATE hip_usuarios SET USU_ESTADO=? WHERE USU_ID=?";

        try {
            conexion.conectar();
            pre = conexion.getConexion().prepareStatement(sql);

            if (usu.getUsu_estado().equalsIgnoreCase("activo")) {
                pre.setString(1, "t");
                pre.setInt(2, usu.getUsu_id());
                pre.executeUpdate();
            } else if (usu.getUsu_estado().equalsIgnoreCase("pasivo")) {
                pre.setString(1, "f");
                pre.setInt(2, usu.getUsu_id());
                pre.executeUpdate();
            }

            conexion.getConexion().commit();

            cepb = true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al cambiar estado del"
                    + " cliente:" + e.getMessage());
        }
        return cepb;
    }

    public boolean actualizarEmpleado(Usuario emp) {

        boolean r = false;
        conexion = new ConexionBD();

        String sql = "";
        sql += "UPDATE hip_usuarios SET USU_CEDULA=?, USU_NOMBRE=?, "
                + "USU_APELLIDO=?, USU_DIRECCION=?, USU_USUARIO=?, USU_CONTRASENIA=?,"
                + " USU_TIPO=?";
        try {
            conexion.conectar();
            PreparedStatement ps = conexion.getConexion().prepareStatement(sql);
            ps.setString(1, emp.getUsu_cedula());
            ps.setString(2, emp.getUsu_nombre());
            ps.setString(3, emp.getUsu_apellido());
            ps.setString(4, emp.getUsu_direccion());
            ps.setString(5, emp.getUsu_usuario());
            ps.setString(6, emp.getUsu_contrasenia());
            if (emp.getUsu_admin().equalsIgnoreCase("Administrador")) {
                ps.setString(7, "t");
            } else if (emp.getUsu_admin().equalsIgnoreCase("Empleado")){
                ps.setString(7, "f");
            }
            ResultSet rs = ps.executeQuery();

            r = true;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.desconectar();
        }

        return r;

    }

    public boolean eliminarEmpleado(int prd) {
        boolean bpb = false;
        PreparedStatement pre = null;
        conexion = new ConexionBD();

        String sql = "";
        sql += "DELETE FROM hip_usuarios WHERE USU_ID=?";

        try {
            conexion.conectar();
            pre = conexion.getConexion().prepareStatement(sql);

            pre.setInt(1, prd);
            pre.executeUpdate();

            conexion.getConexion().commit();

            bpb = true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar EMPLEADO:"
                    + e.getMessage());
        }
        return bpb;
    }

    public static boolean valida(String x) {
        System.out.println(x);
        int suma = 0;
        if (x.length() == 9) {
            System.out.println("Ingrese su cedula de 10 digitos");
            return false;
        } else {
            int a[] = new int[x.length() / 2];
            int b[] = new int[(x.length() / 2)];
            int c = 0;
            int d = 1;
            for (int i = 0; i < x.length() / 2; i++) {
                a[i] = Integer.parseInt(String.valueOf(x.charAt(c)));
                c = c + 2;
                if (i < (x.length() / 2) - 1) {
                    b[i] = Integer.parseInt(String.valueOf(x.charAt(d)));
                    d = d + 2;
                }
            }

            for (int i = 0; i < a.length; i++) {
                a[i] = a[i] * 2;
                if (a[i] > 9) {
                    a[i] = a[i] - 9;
                }
                suma = suma + a[i] + b[i];
            }
            int aux = suma / 10;
            int dec = (aux + 1) * 10;
            if ((dec - suma) == Integer.parseInt(String.valueOf(x.charAt(x.length() - 1)))) {
                return true;
            } else if (suma % 10 == 0 && x.charAt(x.length() - 1) == '0') {
                return true;
            } else {
                return false;
            }

        }
    }
}

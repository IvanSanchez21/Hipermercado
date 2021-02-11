/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.conexion.ConexionBD;
import ec.edu.ups.modelo.Cliente;
import ec.edu.ups.modelo.Empleado;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ronal
 */
public class ControladorEmpleado {
    private ConexionBD conexion;
    
    public boolean crearEmpleado(Empleado emp) {
        conexion = new ConexionBD();
        PreparedStatement ps = null;
        System.out.println(emp.getCodigo());
        System.out.println(emp.getNombres());
        System.out.println(emp.getApellidos());
        System.out.println(emp.getUsuario());
        boolean r = false;
        String sql = "";
        sql += "INSERT INTO hip_usuarios VALUES (usuarios_seq.nextval,?,?,?,?,?,?,?)";

        try {
            conexion.conectar();
            ps = conexion.getConexion().prepareStatement(sql);
            ps.setString(1, emp.getCedula());
            ps.setString(2, emp.getNombres());
            ps.setString(3, emp.getApellidos());
            ps.setString(4, emp.getDireccion());
            ps.setString(5, emp.getUsuario());
            ps.setString(6, emp.getContrasenia());
            ps.setString(7, emp.getTipo());

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
     
    public void llenarTabla(DefaultTableModel dtm, Object[] o) {
        conexion = new ConexionBD();

        String sql = "SELECT * FROM HIP_USUARIOS ORDER BY USU_ID ASC";;
        try {
            conexion.conectar();
            PreparedStatement ps = conexion.getConexion().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                //String ObjetoS[]=new String [8];
                o[0] = rs.getString("usu_id");
                o[1] = rs.getString("usu_cedula");
                o[2] = rs.getString("usu_nombre");
                o[3] = rs.getString("usu_apellido");
                o[4] = rs.getString("usu_direccion");
                o[5] = rs.getString("usu_usuario");
                o[6] = rs.getString("usu_tipo");

                dtm.addRow(o);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.desconectar();
        }
    }
    
    public void filtro(DefaultTableModel dtm, Object[] o, Empleado emp) {
        System.out.println(emp);

        conexion = new ConexionBD();

        String sql = " SELECT *"
                + " FROM hip_usuarios where usu_cedula=?";
        try {
            conexion.conectar();
            PreparedStatement ps = conexion.getConexion().prepareStatement(sql);
            ps.setString(1, emp.getCedula());
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                //String ObjetoS[]=new String [8];
                o[0] = rs.getString("codigo");
                o[1] = rs.getString("cedula");
                o[2] = rs.getString("nombres");
                o[3] = rs.getString("apellidos");
                o[4] = rs.getString("direccion");
                o[5] = rs.getString("usuario");
                o[6] = rs.getString("contrasenia");
                o[7] = rs.getString("tipo");

                dtm.addRow(o);

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.desconectar();
        }
    }
    
    public boolean actualizarEmpleado(Empleado emp) {

        System.out.println(emp.getCodigo());
        System.out.println(emp.getApellidos());
        System.out.println(emp.getCedula());
        System.out.println(emp.getNombres());
        boolean r = false;
        conexion = new ConexionBD();
        
        String sql = "";
        sql += "UPDATE hip_usuarios SET USU_CEDULA=?, USU_NOMBRE=?, "
                + "USU_APELLIDO=?, USU_DIRECCION=?, USU_USUARIO=?, USU_CONTRASENIA=?,"
                + " USU_TIPO=?";
        try {
            conexion.conectar();
            PreparedStatement ps = conexion.getConexion().prepareStatement(sql);
            ps.setString(1, emp.getCedula());
            ps.setString(2, emp.getNombres());
            ps.setString(3, emp.getApellidos());
            ps.setString(4, emp.getDireccion());
            ps.setString(5, emp.getUsuario());
            ps.setString(6, emp.getContrasenia());
            ps.setString(7, emp.getTipo());
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.table.DefaultTableModel;
import modelo.Cliente;

/**
 *
 * @author Johnny
 */
public class controladorCliente {

    public void buscarCliente() {

    }

    public boolean anadirCliente(Cliente cli) {
        System.out.println(cli.getCli_id());
        System.out.println(cli.getCli_apellido());
        System.out.println(cli.getCli_cedula());
        System.out.println(cli.getCli_fecha_registro());
        boolean r = false;
        Connection con = null;
        String t = "to_Date";
        String sql = "Insert Into hip_clientes (cli_id,cli_cedula,cli_nombre,cli_apellido,cli_fecha_registro,cli_direccion,"
                + "cli_tel_convencional,cli_celular,cli_correo_electronico)"
                + " VALUES(?,?,?,?,?,?,?,?,?)";
        /*      + "Values("+fac.getFac_id()
                                                    +",'"+fin2
                                                    +"',"+fac.getFac_subTotal()
                                                    +","+fac.getFac_iva()
                                                    +","+fac.getFac_subTotal()
                                                    +","+fac.getSuc_id()
                                                    +",'"+fac.getCli_id()
                                                    +"','"+fac.getFac_estado()
                                                    +"')";*/

        try {
            con = Conexion.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, cli.getCli_id());
            ps.setString(2, cli.getCli_cedula());
            ps.setString(3, cli.getCli_nombre());
            ps.setString(4, cli.getCli_apellido());
            ps.setDate(5, cli.getCli_fecha_registro());
            ps.setString(6, cli.getCli_direccion());
            ps.setString(7, cli.getCli_tel_convencional());
            ps.setString(8, cli.getCli_celular());
            ps.setString(9, cli.getCli_correo_electronico());

            //ResultSet rs=ps.executeQuery();
            ps.executeQuery();
            //actualizarAuto(form.getAut_id(),nomSuc);
            r = true;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Conexion.close(con);
        }

        return r;
    }

    public int llenarId() {
        int llena = 0;
        boolean ban = false;
        Connection con = null;
        String sql = "SELECT count(*)"
                + "from hip_clientes";
        try {

            con = Conexion.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                llena = rs.getInt(1) + 1;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            Conexion.close(con);
        }
        return llena;
    }

    public void llenarTabla(DefaultTableModel dtm, Object[] o) {
        Connection con = null;

        String sql = " SELECT *"
                + " FROM hip_clientes";
        try {
            con = Conexion.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                //String ObjetoS[]=new String [8];
                o[0] = rs.getString("cli_id");
                o[1] = rs.getString("cli_cedula");
                o[2] = rs.getString("cli_nombre");
                o[3] = rs.getString("cli_apellido");
                o[4] = rs.getDate("cli_fecha_registro");
                o[5] = rs.getString("cli_direccion");
                o[6] = rs.getString("cli_tel_convencional");
                o[7] = rs.getString("cli_celular");
                o[8] = rs.getString("cli_correo_electronico");

                dtm.addRow(o);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Conexion.close(con);
        }
    }

    public boolean actualizarCliente(Cliente cli) {

        System.out.println(cli.getCli_id());
        System.out.println(cli.getCli_apellido());
        System.out.println(cli.getCli_cedula());
        System.out.println(cli.getCli_fecha_registro());
        boolean r = false;
        Connection con = null;

        String sql = "UPDATE hip_clientes SET cli_cedula= ?, cli_nombre=?, cli_apellido=?, cli_fecha_registro=?, cli_direccion=?"
                + ", cli_tel_convencional=?, cli_celular=?, cli_correo_electronico=?"
                + " WHERE cli_id = ?";
        try {
            con = Conexion.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, cli.getCli_cedula());
            ps.setString(2, cli.getCli_nombre());
            ps.setString(3, cli.getCli_apellido());
            ps.setDate(4, cli.getCli_fecha_registro());
            ps.setString(5, cli.getCli_direccion());
            ps.setString(6, cli.getCli_tel_convencional());
            ps.setString(7, cli.getCli_celular());
            ps.setString(8, cli.getCli_correo_electronico());
            ps.setInt(9, cli.getCli_id());
            ResultSet rs = ps.executeQuery();

            r = true;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Conexion.close(con);
        }

        return r;

    }

    public boolean eliminarCliente(int id) {
        boolean r = false;
        Connection con = null;

        String sql = "DELETE FROM  hip_clientes WHERE cli_id = " + id;
        try {
            con = Conexion.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            r = true;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Conexion.close(con);
        }

        return r;
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

    public static boolean validarEmail(String email) {
        System.out.println(email);
        // Patrón para validar el email
        Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

        // El email a validar
        String e = email;

        Matcher mather = pattern.matcher(e);

        if (mather.find() == true) {
            return true;
        } else {
            return false;
        }
    }
}

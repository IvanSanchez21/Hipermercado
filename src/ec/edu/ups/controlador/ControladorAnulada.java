/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.conexion.ConexionBD;
import ec.edu.ups.modelo.Cliente;
import ec.edu.ups.modelo.DetalleFactura;
import ec.edu.ups.modelo.Factura;
import ec.edu.ups.modelo.Producto;
import ec.edu.ups.modelo.Usuario;
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
public class ControladorAnulada {

    private ConexionBD conexion;
    private Factura factura;
    private Cliente cliente;
    private Usuario usuario;
    private DetalleFactura detalleFactura;

    public boolean anularFactura(Factura factura) {
        boolean anf = false;
        PreparedStatement pre = null;
        conexion = new ConexionBD();

        String sql = "";
        sql += "UPDATE HIP_FACTURA_CABECERAS SET FAC_ANULADO=?"
                + " WHERE FAC_CAB_NUM=?";

        try {
            conexion.conectar();
            pre = conexion.getConexion().prepareStatement(sql);

            if (factura.getAnulado().equalsIgnoreCase("f")) {
                pre.setString(1, "t");
                pre.setString(2, factura.getNumFactura());
                pre.executeUpdate();
            }

            conexion.getConexion().commit();

            anf = true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al anular"
                    + " factura:" + e.getMessage());
        }
        return anf;
    }

    public Factura buscarFactura(String codigo) {
        conexion = new ConexionBD();

        try {
            factura = new Factura();
            String sql = "SELECT * FROM HIP_FACTURA_CABECERAS WHERE FAC_CAB_NUM = '"
                    + codigo + "' AND FAC_ANULADO = 'f'";
            conexion.conectar();
            Statement sta = conexion.getConexion().createStatement();
            ResultSet respuesta = sta.executeQuery(sql);

            while (respuesta.next()) {
                factura.setIdCabecera(respuesta.getInt(1));
                factura.setNumFactura(respuesta.getString(2));
                factura.setFechaEmision(respuesta.getDate(3));
                factura.setSubTotal(respuesta.getDouble(4));
                factura.setIva(respuesta.getDouble(5));
                factura.setTotal(respuesta.getDouble(6));
                factura.setAnulado(respuesta.getString(7));
                factura.setIdCliente(respuesta.getInt(8));
                factura.setIdUsuario(respuesta.getInt(9));

            }
            conexion.desconectar();
            return factura;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Factura no encontrada");
        }
        return null;
    }

    public Cliente buscarCliente(int numCli) {
        conexion = new ConexionBD();

        try {
            cliente = new Cliente();
            String sql = "SELECT * FROM HIP_CLIENTES WHERE CLI_ID = '" + numCli + "'";
            conexion.conectar();
            Statement sta = conexion.getConexion().createStatement();
            ResultSet respuesta = sta.executeQuery(sql);

            while (respuesta.next()) {
                cliente.setCli_cedula(respuesta.getString(2));
                cliente.setCli_nombre(respuesta.getString(3));
                cliente.setCli_apellido(respuesta.getString(4));
                cliente.setCli_direccion(respuesta.getString(6));
                cliente.setCli_tel_convencional(respuesta.getString(7));
                cliente.setCli_celular(respuesta.getString(8));

            }
            conexion.desconectar();
            return cliente;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Cliente no encontrado");
        }
        return null;
    }

    public Usuario buscarUsuario(int numUsu) {
        conexion = new ConexionBD();

        try {
            usuario = new Usuario();
            String sql = "SELECT * FROM HIP_USUARIOS WHERE USU_ID = '" + numUsu + "'";
            conexion.conectar();
            Statement sta = conexion.getConexion().createStatement();
            ResultSet respuesta = sta.executeQuery(sql);

            while (respuesta.next()) {
                usuario.setUsu_usuario(respuesta.getString(6));

            }
            conexion.desconectar();
            return usuario;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Usuario no encontrado");
        }
        return null;
    }

    public String buscarProducto(int numPro) {
        conexion = new ConexionBD();
        String nomPro = "";
        try {
            String sql = "SELECT PRD_NOMBRE FROM HIP_PRODUCTOS "
                    + "WHERE PRD_ID = '" + numPro + "'";

            conexion.conectar();
            Statement sta = conexion.getConexion().createStatement();
            ResultSet rs = sta.executeQuery(sql);

            while (rs.next()) {

                nomPro = rs.getString(1);

            }
            return nomPro;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Producto no encontrado");
        } finally {
            conexion.desconectar();
        }
        return null;
    }

    public void buscarDetalle(DefaultTableModel dtm, Object[] o, int numFac) {
        conexion = new ConexionBD();

        try {
            String sql = "SELECT * FROM HIP_FACTURA_DETALLES "
                    + "WHERE HIP_FAC_CAB_ID = '" + numFac + "'";

            conexion.conectar();
            Statement sta = conexion.getConexion().createStatement();
            ResultSet rs = sta.executeQuery(sql);

            while (rs.next()) {

                o[0] = rs.getInt(8);
                o[1] = buscarProducto(rs.getInt(8));
                o[2] = rs.getDouble(2);
                o[3] = rs.getDouble(3);
                o[4] = rs.getDouble(4);
                o[5] = rs.getDouble(5);
                o[6] = rs.getDouble(6);

                dtm.addRow(o);

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Producto no encontrado");
        } finally {
            conexion.desconectar();
        }
    }
}

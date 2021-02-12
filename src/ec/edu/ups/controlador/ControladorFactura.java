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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class ControladorFactura {

    private Cliente cliente;
    private ConexionBD conexion;
    private Producto producto;
    private Factura facCabecera;
    //private DetalleFactura detalle;
    int idCap;
    int r;

    
    public void listar(JTable tabla) {
        DefaultTableModel model;
        String[] columnas = {"pet_anu_id", "pet_anu_estado", "APELpet_anu_fechaLIDO", "pet_fac_id", "pet_usu_id",};
        model = new DefaultTableModel(null, columnas);

        String sql = "SELECT * FROM hip_peticiones_anulacion";
        String[] filas = new String[5];
        try {
            conexion.conectar();
            Statement sta = conexion.getConexion().createStatement();
            ResultSet respuesta = sta.executeQuery(sql);
            while (respuesta.next()) {
                for (int i = 0; i < 7; i++) {
                    filas[i] = respuesta.getString(i + 1);
                }
                model.addRow(filas);
            }tabla.setModel(model);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error");
        }
    }
    
    public String numerarFactura() {
        String numFac = "";
        String numEst = "001";
        String numFtrdor = "001";
        String recolecto = "";
        conexion = new ConexionBD();

        String sql = "SELECT MAX(fac_cab_num) FROM HIP_FACTURA_CABECERAS";

        try {
            conexion.conectar();
            Statement sta = conexion.getConexion().createStatement();
            ResultSet respuesta = sta.executeQuery(sql);

            while (respuesta.next()) {
                numFac = respuesta.getString(1);
            }
            conexion.desconectar();
            for (int i = 6; i < numFac.length(); i++) {
                if (numFac.charAt(i) != 0) {
                    recolecto = recolecto + numFac.charAt(i);
                }
            }
            int valorFain = Integer.parseInt(recolecto);
            recolecto = String.format("%09d", valorFain + 1);
            numFac = numEst + numFtrdor + recolecto;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Fallo en la numeración" + e.getMessage());
        }
        return numFac;
    }

    /*
        * Método para actualizar el stock, una vez que el empleado registre la factura.
     */
    public int actualizarStock(double cant, int idProd) {

        PreparedStatement pre = null;
        conexion = new ConexionBD();

        String sql = "";
        sql += "UPDATE hip_productos SET prd_stock = ? ";
        sql += "WHERE prd_id = " + idProd;
        try {
            conexion.conectar();
            pre = conexion.getConexion().prepareStatement(sql);
            pre.setDouble(1, cant);
            pre.executeUpdate();
            conexion.getConexion().commit();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Problemas al actualizar Stock!! " + e.getMessage());
        }
        conexion.desconectar();

        return r;
    }

    public void GuardarFacCabecera(Factura facCabecera) {
        System.out.println("........" + facCabecera.getIdCabecera());
        PreparedStatement pre = null;
        conexion = new ConexionBD();
        //facCabecera = new Factura();

        String sql = "";
        sql += "INSERT INTO hip_factura_cabeceras VALUES (fac_cabeceras_seq.nextval,?,?,?,?,?,?,?,?)";

        try {
            conexion.conectar();
            pre = conexion.getConexion().prepareStatement(sql);

            pre.setString(1, facCabecera.getNumFactura());
            pre.setDate(2, (java.sql.Date) (Date) facCabecera.getFechaEmision());
            pre.setDouble(3, facCabecera.getSubTotal());
            pre.setDouble(4, facCabecera.getIva());
            pre.setDouble(5, facCabecera.getTotal());
            pre.setString(6, facCabecera.getAnulado());
            pre.setInt(7, facCabecera.getIdCliente());
            pre.setInt(8, facCabecera.getIdUsuario());
            pre.executeUpdate();
            conexion.getConexion().commit();
            conexion.desconectar();

            JOptionPane.showMessageDialog(null, "Factura registrada", "Correcto", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Fallo al guardar factura " + e.getMessage());
        }

    }

    public void GuardarFacDetalle(DetalleFactura detalle) {
        int idCap = recuperarNunFacturaCab();

        PreparedStatement pre = null;
        conexion = new ConexionBD();
        //detalle = new DetalleFactura();

        String sql = "";
        sql += "INSERT INTO hip_factura_detalles VALUES (fac_detalles_seq.nextval,?,?,?,?,?,?,?)";

        try {
            conexion.conectar();
            pre = conexion.getConexion().prepareStatement(sql);
            pre.setDouble(1, detalle.getCantidad());
            pre.setDouble(2, detalle.getPrecio());
            pre.setDouble(3, detalle.getSubTotal());
            pre.setDouble(4, detalle.getIva());
            pre.setDouble(5, detalle.getTotal());
            pre.setInt(6, idCap);
            pre.setInt(7, detalle.getIdProducto());
            pre.executeUpdate();

            conexion.getConexion().commit();
            conexion.desconectar();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Fallo al guardar detalle " + e.getMessage());
        }
    }

    public int recuperarNunFacturaCab() {
        conexion = new ConexionBD();
        int idVenta = 0;

        String sql = "SELECT MAX(fac_cab_id) FROM HIP_FACTURA_CABECERAS";

        try {
            conexion.conectar();
            Statement sta = conexion.getConexion().createStatement();
            ResultSet respuesta = sta.executeQuery(sql);

            while (respuesta.next()) {
                idVenta = respuesta.getInt(1);
            }
            conexion.desconectar();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Fallo en la busqueda" + e.getMessage());
        }
        return idVenta;
    }

    public int NunFacturaCab() {
        conexion = new ConexionBD();
        int idVenta = 0;

        String sql = "SELECT MAX(fac_cab_id) FROM HIP_FACTURA_CABECERAS";

        try {
            conexion.conectar();
            Statement sta = conexion.getConexion().createStatement();
            ResultSet respuesta = sta.executeQuery(sql);

            while (respuesta.next()) {
                idVenta = respuesta.getInt(1) + 1;
                System.out.println("id --- " + idVenta);
            }
            conexion.desconectar();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Fallo en la busqueda" + e.getMessage());
        }
        return idVenta;
    }

    public Cliente buscarCliente(String cedula) {
        conexion = new ConexionBD();
        try {
            cliente = new Cliente();
            String sql = "SELECT * FROM HIP_CLIENTES WHERE CLI_CEDULA = '" + cedula + "'";
            conexion.conectar();
            Statement sta = conexion.getConexion().createStatement();
            ResultSet respuesta = sta.executeQuery(sql);
            System.out.println(respuesta);

            while (respuesta.next()) {

                cliente.setCli_id(respuesta.getInt(1));
                cliente.setCli_cedula(respuesta.getString(2));
                cliente.setCli_nombre(respuesta.getString(3));
                cliente.setCli_apellido(respuesta.getString(4));
                cliente.setCli_fecha_registro(respuesta.getDate(5));
                cliente.setCli_direccion(respuesta.getString(6));
                cliente.setCli_tel_convencional(respuesta.getString(7));
                cliente.setCli_celular(respuesta.getString(8));
                cliente.setCli_correo_electronico(respuesta.getString(9));
            }
            conexion.desconectar();
            //System.out.println("Persona: " + cliente.getCli_nombre());
            return cliente;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo encontrar a la persona");
            //System.out.println("Error: " + ex);
        }
        return null;
    }

    public Producto buscarProducto(String codigo) {
        conexion = new ConexionBD();

        try {
            producto = new Producto();
            String sql = "SELECT * FROM HIP_PRODUCTOS WHERE PRD_CBARRA = '"
                    + codigo + "' OR UPPER(PRD_NOMBRE) LIKE UPPER('" + codigo + "%')"
                    + " AND PRD_ESTADO = 'a'";
            System.out.println(sql);
            conexion.conectar();
            Statement sta = conexion.getConexion().createStatement();
            ResultSet respuesta = sta.executeQuery(sql);
            System.out.println(respuesta);

            while (respuesta.next()) {

                producto.setPrd_id(respuesta.getInt(1));
                producto.setPrd_cbarra(respuesta.getString(2));
                producto.setPrd_fecha_registro(respuesta.getDate(3));
                producto.setPrd_nombre(respuesta.getString(4));
                producto.setPrd_precio(respuesta.getDouble(5));
                producto.setPrd_stock(respuesta.getDouble(6));
                producto.setPrd_estado(respuesta.getString(7));
                producto.setPrd_unidad(respuesta.getString(8));
                producto.setPrd_origen(respuesta.getString(9));
                producto.setPrd_iva(respuesta.getBoolean(10));

            }
            conexion.desconectar();
            return producto;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Producto no encontrado");
        }
        return null;
    }

    /*
        *Este método me sirve para poder actualizar el stock del producto al momento de 
        *registrar una factura.
     */
    public Producto buscarIdProducto(int id) {
        conexion = new ConexionBD();
        try {
            producto = new Producto();
            String sql = "SELECT * FROM HIP_PRODUCTOS WHERE PRD_ID = '" + id + "'";
            //System.out.println(sql);

            conexion.conectar();
            Statement sta = conexion.getConexion().createStatement();
            ResultSet respuesta = sta.executeQuery(sql);
            System.out.println(respuesta);

            while (respuesta.next()) {

                producto.setPrd_id(respuesta.getInt(1));
                producto.setPrd_cbarra(respuesta.getString(2));
                producto.setPrd_fecha_registro(respuesta.getDate(3));
                producto.setPrd_nombre(respuesta.getString(4));
                producto.setPrd_precio(respuesta.getDouble(5));
                producto.setPrd_stock(respuesta.getDouble(6));
                producto.setPrd_estado(respuesta.getString(7));
                producto.setPrd_unidad(respuesta.getString(8));
                producto.setPrd_origen(respuesta.getString(9));
                producto.setPrd_iva(respuesta.getBoolean(10));

            }
            conexion.desconectar();
            //System.out.println("nombre pro : " + producto.getPrd_nombre());
            return producto;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Producto no encontrado");
            //System.out.println("Error: " + ex);
        }
        return null;
    }

}

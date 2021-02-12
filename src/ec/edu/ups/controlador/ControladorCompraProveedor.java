/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;
import ec.edu.ups.conexion.ConexionBD;
import ec.edu.ups.modelo.Cliente;
import ec.edu.ups.modelo.CompraDetalle;
import ec.edu.ups.modelo.CompraProveedor;
import ec.edu.ups.modelo.DetalleFactura;
import ec.edu.ups.modelo.Factura;
import ec.edu.ups.modelo.Producto;
import ec.edu.ups.modelo.Proveedor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author ronal
 */
public class ControladorCompraProveedor {
     private Proveedor proveedor;
    private ConexionBD conexion;
    private Producto producto;
    private CompraProveedor facCabecera;
    private CompraDetalle facDetalle;
    int idCap;
    int r;
    
    public String numerarFactura() {
        String numFac = "";
        String numEst = "001";
        String numFtrdor = "001";
        String recolecto = "";
        conexion = new ConexionBD();

        String sql = "SELECT MAX(fcp_num_fac) FROM HIP_ENCABEZADOS_COMPRAS";

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
    
    public void GuardarFacCabecera(CompraProveedor facCabecera) {
        System.out.println("codigo........" + facCabecera.getCodigo());
        PreparedStatement pre = null;
        conexion = new ConexionBD();
        //facCabecera = new Factura();

        String sql = "";
        sql += "INSERT INTO hip_encabezados_compras VALUES (fac_cabeceras_seq.nextval,?,?,?)";

        try {
            conexion.conectar();
            pre = conexion.getConexion().prepareStatement(sql);
            pre.setString(1, "48");
            pre.setDate(2, (java.sql.Date) facCabecera.getfEmision());
            pre.setInt(3, facCabecera.getProveedor());
            pre.executeUpdate();
            conexion.getConexion().commit();
            conexion.desconectar();

            JOptionPane.showMessageDialog(null, "Compra registrada", "Correcto", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Fallo al guardar Compra " + e.getMessage());
        }
    }
        
        public void GuardarFacDetalle(CompraDetalle detalle) {
        int idCap = recuperarNunFacturaCab();

        PreparedStatement pre = null;
        conexion = new ConexionBD();
        //detalle = new DetalleFactura();

        String sql = "";
        sql += "INSERT INTO hip_detalles_compras VALUES (det_compras_seq.nextval,?,?,?)";

        try {
            conexion.conectar();
            pre = conexion.getConexion().prepareStatement(sql);
            pre.setInt(1, detalle.getCantidad());
            pre.setInt(2, detalle.getProductos());
            pre.setInt(3, detalle.getCompraProveedor());
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

        String sql = "SELECT MAX(fcp_id) FROM HIP_ENCABEZADOS_COMPRAS";

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

        String sql = "SELECT MAX(fcp_id) FROM HIP_ENCABEZADOS_COMPRAS";

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
        
        public Proveedor buscarProveedor(String cedula) {
        conexion = new ConexionBD();
        try {
            proveedor = new Proveedor();
            String sql = "SELECT * FROM HIP_PROVEEDORES WHERE PRO_RUC = '" + cedula + "'";
            conexion.conectar();
            Statement sta = conexion.getConexion().createStatement();
            ResultSet respuesta = sta.executeQuery(sql);
            System.out.println(respuesta);

            while (respuesta.next()) {

                proveedor.setCodigo(respuesta.getInt(1));
                proveedor.setRuc(respuesta.getString(2));
                proveedor.setFecha_registro(respuesta.getDate(3));
                proveedor.setRazon_social(respuesta.getString(4));
                proveedor.setCorreo(respuesta.getString(5));
            }
            conexion.desconectar();
            //System.out.println("Persona: " + cliente.getCli_nombre());
            return proveedor;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo encontrar al proveedor");
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

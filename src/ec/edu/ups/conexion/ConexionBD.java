package ec.edu.ups.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author Iván
 */
public class ConexionBD {

    private Connection conexion = null;
    private String usuario = "hipermercado";
    private String contrasena = "hipermercado";
    private String url = "jdbc:oracle:thin:@localhost:1521:xe";

    public ConexionBD() {
    }

    public Connection getConexion() {
        return conexion;
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }

    public void conectar() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conexion = DriverManager.getConnection(url, usuario, contrasena);
            conexion.setAutoCommit(false);
            System.out.println("conectado...");

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    }

    public void desconectar() {
        try {
            conexion.close();
            System.out.println("desconectado...");

        } catch (SQLException ex) {

        }
    }

}

package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author ASUS
 */
public class ConexionBD {

    private Connection conexion = null;
    private String usuario = "Hipermercado";
    private String contrasena = "123";
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

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    }

    public void desconectar() {
        try {
            conexion.close();
           
        } catch (SQLException ex) {

        }
    }


    public boolean iniciarSesion(String usuario, String contrasena) throws SQLException {

        boolean respuesta;

        String sql = "SELECT USUARIO,CONTRASENA FROM USUARIOS "
                + "WHERE USUARIO='" + usuario + "' AND CONTRASENA='" + contrasena + "'";
        conectar();
        Statement sta = getConexion().createStatement();
        ResultSet res = sta.executeQuery(sql);

        respuesta = res.next();
        desconectar();

        return respuesta;
    }

}

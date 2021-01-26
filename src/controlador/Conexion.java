/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Johnny
 */
public class Conexion {
    public static void main(String[] args) {
     
        /* Llamar al método (Close) para cerrar la base de datos */
        close(getConnection());
        
    }
    
    
    /*°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°
            Método para ingresar a la base de datos
                Usuario: 
                Clave: 
    °°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°*/
    public static Connection getConnection() {
        try {
        	Class.forName("oracle.jdbc.driver.OracleDriver");  
        	Connection con = DriverManager.getConnection(  
                    "jdbc:oracle:thin:@localhost:1521:xe", "hpprueba","hp123");  
        	System.out.println("Conectado");
            return con;
           
        } catch (Exception ex) {
            System.out.println("Database.getConnection() Error -->" + ex.getMessage());
            return null;
        }
    }
 
    /*°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°
        Método que se usa para cerrar la base datos para prevenir 
        el colapso de información. 
    °°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°*/
    public static void close(Connection con) {
        try {
            con.close();
            System.out.println("Cerrado");
        } catch (Exception ex) {
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.conexion.ConexionBD;
import ec.edu.ups.modelo.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author José
 */
public class ControladorUsuario {
    
    private ConexionBD conexion;
    private Usuario usuario;
    
    public String VerificarUsuario(String usernam, String contraseña){
        String conf = "";
        conexion=new ConexionBD();
        try {                    
            usuario= new Usuario();
            String sql="SELECT * FROM HIP_USUARIOS WHERE USU_USUARIO='"+usernam+"' AND USU_CONTRASENIA='"+contraseña+"'";
            conexion.conectar();
            Statement sta = conexion.getConexion().createStatement();
            ResultSet rs = sta.executeQuery(sql);
            System.out.println(rs);
            while(rs.next()){
                 conf=rs.getString(8);                
            }
            System.out.println(conf);
            conexion.desconectar();                                                  
        } catch (SQLException e) {
            e.printStackTrace();
        }        
        return conf;        
    }   
    
    
}

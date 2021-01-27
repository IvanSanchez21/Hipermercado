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
import modelo.Cliente;


/**
 *
 * @author Johnny
 */
public class controladorCliente {
    
    public void buscarCliente(){
        
    }
     public boolean anadirCliente(Cliente cli){
        boolean r = false;
        Connection con = null;
       String txt= "to_date";
        String sql = "Insert Into HIP_CLIENTES Values("+cli.getCli_id()
                +",'"+cli.getCli_cedula()
                +"','"+cli.getCli_nombre()
                +"','"+cli.getCli_apellido()
                +"','21/12/2020','"+cli.getCli_direccion()
                +"','"+cli.getCli_tel_convencional()
                +"','"+cli.getCli_celular()
                +"','"+cli.getCli_correo_electronico()
                +"');";
        try{
            
            con =Conexion.getConnection();
            PreparedStatement ps= con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            
            r=true;
	    
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Conexion.close(con);
        }

        return r;
    }
    
}

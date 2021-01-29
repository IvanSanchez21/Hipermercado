/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.modelo;

import java.sql.Date;

/**
 *
 * @author Johnny
 */
public class Cliente {
    private int cli_id;
    private String cli_cedula;
    private String cli_nombre;
    private String cli_apellido;
    private Date cli_fecha_registro;
    private String cli_direccion;
    private String cli_tel_convencional;
    private String cli_celular;
    private String cli_correo_electronico;
    
    
    public Cliente() {
    }

 

    public int getCli_id() {
        return cli_id;
    }

    public void setCli_id(int cli_id) {
        this.cli_id = cli_id;
    }

    public String getCli_cedula() {
        return cli_cedula;
    }

    public void setCli_cedula(String cli_cedula) {
        this.cli_cedula = cli_cedula;
    }

    public String getCli_nombre() {
        return cli_nombre;
    }

    public void setCli_nombre(String cli_nombre) {
        this.cli_nombre = cli_nombre;
    }

    public String getCli_apellido() {
        return cli_apellido;
    }

    public void setCli_apellido(String cli_apellido) {
        this.cli_apellido = cli_apellido;
    }

    public Date getCli_fecha_registro() {
        return cli_fecha_registro;
    }

    public void setCli_fecha_registro(Date cli_fecha_registro) {
        this.cli_fecha_registro = cli_fecha_registro;
    }

    public String getCli_direccion() {
        return cli_direccion;
    }

    public void setCli_direccion(String cli_direccion) {
        this.cli_direccion = cli_direccion;
    }

    public String getCli_tel_convencional() {
        return cli_tel_convencional;
    }

    public void setCli_tel_convencional(String cli_tel_convencional) {
        this.cli_tel_convencional = cli_tel_convencional;
    }

    public String getCli_celular() {
        return cli_celular;
    }

    public void setCli_celular(String cli_celular) {
        this.cli_celular = cli_celular;
    }

    public String getCli_correo_electronico() {
        return cli_correo_electronico;
    }

    public void setCli_correo_electronico(String cli_correo_electronico) {
        this.cli_correo_electronico = cli_correo_electronico;
    }

    
    
    
}

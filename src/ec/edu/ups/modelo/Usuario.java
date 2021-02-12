/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.modelo;

/**
 *
 * @author José
 */
public class Usuario {

    private int usu_id;
    private String usu_cedula;
    private String usu_nombre;
    private String usu_apellido;
    private String usu_direccion;
    private String usu_usuario;
    private String usu_contrasenia;
    private String usu_admin;
    private String usu_estado;

    public Usuario() {
    }

    public Usuario(int usu_id, String usu_cedula, String usu_nombre, String usu_apellido, String usu_direccion, String usu_usuario, String usu_contrasenia, String usu_admin) {
        this.usu_id = usu_id;
        this.usu_cedula = usu_cedula;
        this.usu_nombre = usu_nombre;
        this.usu_apellido = usu_apellido;
        this.usu_direccion = usu_direccion;
        this.usu_usuario = usu_usuario;
        this.usu_contrasenia = usu_contrasenia;
        this.usu_admin = usu_admin;
    }

    public int getUsu_id() {
        return usu_id;
    }

    public String getUsu_cedula() {
        return usu_cedula;
    }

    public String getUsu_nombre() {
        return usu_nombre;
    }

    public String getUsu_apellido() {
        return usu_apellido;
    }

    public String getUsu_direccion() {
        return usu_direccion;
    }

    public String getUsu_usuario() {
        return usu_usuario;
    }

    public String getUsu_contrasenia() {
        return usu_contrasenia;
    }

    public String getUsu_admin() {
        return usu_admin;
    }

    public String getUsu_estado() {
        return usu_estado;
    }

    public void setUsu_estado(String usu_estado) {
        this.usu_estado = usu_estado;
    }

    public void setUsu_id(int usu_id) {
        this.usu_id = usu_id;
    }

    public void setUsu_cedula(String usu_cedula) {
        this.usu_cedula = usu_cedula;
    }

    public void setUsu_nombre(String usu_nombre) {
        this.usu_nombre = usu_nombre;
    }

    public void setUsu_apellido(String usu_apellido) {
        this.usu_apellido = usu_apellido;
    }

    public void setUsu_direccion(String usu_direccion) {
        this.usu_direccion = usu_direccion;
    }

    public void setUsu_usuario(String usu_usuario) {
        this.usu_usuario = usu_usuario;
    }

    public void setUsu_contrasenia(String usu_contrasenia) {
        this.usu_contrasenia = usu_contrasenia;
    }

    public void setUsu_admin(String usu_admin) {
        this.usu_admin = usu_admin;
    }

}

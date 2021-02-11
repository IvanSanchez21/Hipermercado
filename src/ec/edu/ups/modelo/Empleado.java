/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.modelo;

/**
 *
 * @author ronal
 */
public class Empleado {
    private int codigo;
    private String cedula;
    private String nombres;
    private String apellidos;
    private String direccion;
    private String usuario;
    private String contrasenia;
    private String tipo;
    
    public Empleado(){
        this.codigo=codigo;
        this.cedula=cedula;
        this.nombres=nombres;
        this.apellidos=apellidos;
        this.direccion=direccion;
        this.usuario=usuario;
        this.contrasenia=contrasenia;
        this.tipo=tipo;
    }
    
    public Empleado(int codigo, String cedula, String nombres, String apellidos, String direccion, String usuario, String contrasenia, String tipo) {
        this.codigo = codigo;
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.tipo = tipo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Empleado{" + "codigo=" + codigo + ", cedula=" + cedula + ", nombres=" + nombres 
                + ", apellidos=" + apellidos + ", direccion=" + direccion + ", usuario=" + usuario 
                + ", contrasenia=" + contrasenia + ", tipo=" + tipo + '}';
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import java.sql.ResultSet;

/**
 *
 * @author mike
 */
public class Usuario {
    private int id;
    private int cedula;
    private String nombre;
    private String apellido;
    private String tipo;
    private String user;
    private String pass;

    public Usuario() {
    }
    public Usuario(int cedula, String nombre, String apellido, String tipo, String user, String pass) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipo = tipo;
        this.user = user;
        this.pass = pass;
    }
    public Usuario(ResultSet rs) {
        try{
            id              = rs.getInt("id");
            cedula          = rs.getInt("cedula");
            nombre          = rs.getString("nombre");
            apellido        = rs.getString("apellido");
            tipo            = rs.getString("tipo");
            user            = rs.getString("user");
            pass            = rs.getString("pass");
                    
        }catch (Exception e){
            
        }
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    
}

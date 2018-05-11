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
public class Admin extends Usuario{
    private int id;
    private int idUsuario;

    public Admin() {
    }
    public Admin(int idUsuario) {
        this.idUsuario = idUsuario;
    }
//    public Admin(int id, int idUsuario, ResultSet rs) {
//        super(rs);
//        this.id = id;
//        this.idUsuario = idUsuario;
//    }
    public Admin(ResultSet rs) {
        try{
            id                  = rs.getInt("id");
            idUsuario           = rs.getInt("idUsuario");
        }catch (Exception e){      
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    
}

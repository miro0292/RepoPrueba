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
public class Cliente extends Usuario{
    private int id;
    private int idUsuario;
    private String direccion;
    private String ciudad;
    private String region;
    private String pais;

    public Cliente() {
    }

    public Cliente(int idUsuario, String direccion, String ciudad, String region, String pais) {
        this.idUsuario = idUsuario;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.region = region;
        this.pais = pais;
    }

//    public Cliente(int id, int idUsuario, String direccion, String ciudad, String region, String pais, ResultSet rs) {
//        super(rs);
//        this.id = id;
//        this.idUsuario = idUsuario;
//        this.direccion = direccion;
//        this.ciudad = ciudad;
//        this.region = region;
//        this.pais = pais;
//    }
    public Cliente(ResultSet rs) {
        try{
            id                  = rs.getInt("id");
            idUsuario           = rs.getInt("idUsuario");
            direccion           = rs.getString("direccion");
            ciudad              = rs.getString("ciudad");
            region              = rs.getString("region");
            pais                = rs.getString("pais");      
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
}

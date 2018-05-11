/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;
import BD.UsuarioJDBC;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
/**
 *
 * @author mike
 */
@ManagedBean
public class Autenticacion {

    private String usuario;
    private String pass;
    private int aux=0;
    public void validarUsuario(){
        aux=usuario.indexOf("@");
        if(aux!=-1){
            if(pass.length()>0 && pass.length()<5){
                UsuarioJDBC lo = new UsuarioJDBC();
                Cliente cliente = new Cliente();
                cliente = lo.autenticacion(usuario, pass);
                if(cliente != null){
                    if (lo.BuscarTipo(usuario).equals("1")) {
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Acceso Correcto", "Acceso correctamente"));
                    } else if (lo.BuscarTipo(usuario).equals("2")) {
                        
                    }
                } else {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "validarUsuario", "No se encontro usuario"));
                }
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "validarUsuario", "Usuario y contraseña correctos"));
            }else{
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "validarUsuario", "contraseña debe ser de minimo 1 valor y maximo 4"));
            }
        }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "validarUsuario", "Usuario Incorrecto es necesario un @"));
        }        
    }    

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getAux() {
        return aux;
    }

    public void setAux(int aux) {
        this.aux = aux;
    }    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.royalmaster.royalmaster.beans;

import com.royalmaster.royalmaster.controller.Controller;
import com.royalmaster.royalmaster.entities.Usuarios;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

/**
 *
 * @author blas
 */
@ManagedBean(name="update_usuario")
@SessionScoped
public class UpdateUsuarioBean implements Serializable {
    private Usuarios selected;
    private String repetirPass;
    private Controller<Usuarios> cu;

    public Usuarios getSelected() {
        return selected;
    }

    public void setSelected(Usuarios selected) {
        this.selected = selected;
    }
    
    public String getRepetirPass() {
        return repetirPass.trim();
    }

    public void setRepetirPass(String repetirPass) {
        this.repetirPass = repetirPass;
    }   
    
    @PostConstruct
    public void init(){
        repetirPass = new String();
        selected = new Usuarios();
        cu = new Controller(Usuarios.class);
    }
    
    public void volver(){
        RequestContext.getCurrentInstance().closeDialog(selected);
    }
    
    public void update(){
        if (cu.update(selected)) {
                volver();
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage(null, new FacesMessage("Correcto!",  "Contraseña cambiada") );                
            }
            else{
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage(null, new FacesMessage("Problemas!",  "Error en la modificación") );
            }
    
    }
    
    public void reset(){
        this.selected.setContrasenaUsuario(this.selected.getNombreUsuario());
        if (cu.update(selected)) {
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage(null, new FacesMessage("Correcto!",  "Contraseña reseteada") );
                volver();
            }
            else{
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage(null, new FacesMessage("Problemas!",  "Error en la modificación") );
            }
    }
}
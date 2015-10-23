/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.royalmaster.royalmaster.beans;

import java.io.IOException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import com.royalmaster.royalmaster.controller.LoginController;
import com.royalmaster.royalmaster.entities.Usuarios;

/**
 *
 * @author luciano
 */
@ManagedBean
@RequestScoped
public class MbLogin {
 
    private String usuario;
    private String contrasenia;
    private boolean admin;
    private Usuarios user;
    private final HttpServletRequest httpServletRequest;
    private final FacesContext faceContext;
    private FacesMessage facesMessage;

    public Usuarios getUser() {
        return user;
    }

    public void setUser(Usuarios user) {
        this.user = user;
    }

    
    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
    
    public MbLogin() throws IOException 
    {
        faceContext=FacesContext.getCurrentInstance();
        httpServletRequest=(HttpServletRequest)faceContext.getExternalContext().getRequest();
        if(httpServletRequest.getSession().getAttribute("sessionUsuario")!=null)
        {
            facesMessage=new FacesMessage(FacesMessage.SEVERITY_INFO, "Primero debe iniciar sesión", null);
            faceContext.addMessage(null, facesMessage);
            faceContext.getExternalContext().redirect("acceso.xhtml");
        }
    }
     
    public String login()
    {
        Usuarios loginUser = LoginController.login(usuario, contrasenia);
        if(loginUser != null)
        {
            httpServletRequest.getSession().setAttribute("sessionUsuario", usuario);
            httpServletRequest.getSession().setAttribute("perfilUsuario", loginUser.getPerfiles());
            httpServletRequest.getSession().setAttribute("user", loginUser);
            return "acceso";
        }
        else
        {
            facesMessage=new FacesMessage(FacesMessage.SEVERITY_ERROR, "Contraseña o usuario incorrecto. Su usuario puede estar inactivo", null);
            faceContext.addMessage(null, facesMessage);
            return "index";
        }
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
    
    public void changePassword(){
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Second Message", "Additional Message Detail"));
    }
}
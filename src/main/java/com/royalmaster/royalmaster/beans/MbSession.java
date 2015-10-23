/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.royalmaster.royalmaster.beans;

import java.io.IOException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author luciano
 */
@ManagedBean
@RequestScoped
public class MbSession {
    
    private String usuario;
    private HttpServletRequest httpServletRequest;
    private final FacesContext faceContext;
    private FacesMessage facesMessage;
     
    public MbSession() throws IOException 
    {
        faceContext=FacesContext.getCurrentInstance();
        httpServletRequest=(HttpServletRequest)faceContext.getExternalContext().getRequest();
        if(httpServletRequest.getSession().getAttribute("sessionUsuario")!=null)
        {
            usuario=httpServletRequest.getSession().getAttribute("sessionUsuario").toString();
        }
        else{
            facesMessage=new FacesMessage(FacesMessage.SEVERITY_INFO, "Primero debe iniciar sesión", null);
            faceContext.addMessage(null, facesMessage);
            faceContext.getExternalContext().redirect(faceContext.getExternalContext().getRequestContextPath());
        }
    }
     
    public String cerrarSession()
    {
        httpServletRequest.getSession().removeAttribute("sessionUsuario");
        facesMessage=new FacesMessage(FacesMessage.SEVERITY_INFO, "Session cerrada correctamente", null);
        faceContext.addMessage(null, facesMessage);
        return "index";
    }
 
    public String getUsuario() {
        return usuario;
    }
 
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }    
    
    public void checkSession() throws IOException{
        httpServletRequest=(HttpServletRequest)faceContext.getExternalContext().getRequest();
        if(httpServletRequest.getSession().getAttribute("sessionUsuario")==null)
        {
            faceContext.getExternalContext().redirect(faceContext.getExternalContext().getRequestContextPath());
        }
    }
    
    public boolean isAdmin() throws IOException{
        boolean admin = false;
        httpServletRequest=(HttpServletRequest)faceContext.getExternalContext().getRequest();
        if(httpServletRequest.getSession().getAttribute("sessionUsuario")!=null)
        {
            admin = httpServletRequest.getSession().getAttribute("perfilUsuario").toString().trim().equals("ADMINISTRADOR");
        }
        return admin;
    }
}

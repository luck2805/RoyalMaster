/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.royalmaster.royalmaster.beans;

import com.royalmaster.royalmaster.controller.Controller;
import com.royalmaster.royalmaster.entities.Perfiles;
import com.royalmaster.royalmaster.entities.Usuarios;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import org.primefaces.context.RequestContext;

/**
 *
 * @author blas
 */
@ManagedBean(name="usuarios")
@ViewScoped
public class UsuariosBean implements Serializable{
    
    private List<Usuarios> lista;
    private Usuarios nuevo;
    private Usuarios selected;
    private Controller<Usuarios> cu;
    @ManagedProperty(value="#{update_usuario}")
    private UpdateUsuarioBean updateUsuario;

    public UpdateUsuarioBean getUpdateCentros() {
        return updateUsuario;
    }

    public void setUpdateUsuario(UpdateUsuarioBean updateUsuario) {
        this.updateUsuario = updateUsuario;
    }

    public List<Usuarios> getLista() {
       // SessionFactory sf = HibernateUtil.getSessionFactory();
       // Session s = sf.openSession();
        //this.lista = s.createCriteria(Usuario.class).list();
        return lista;
    }

    public void setNuevo (Usuarios nuevo){
        this.nuevo = nuevo;
    }
    
    public Usuarios getNuevo (){
        return nuevo;
    }
    
    public void setLista(List<Usuarios> lista) {
        this.lista = lista;
    }

    public Usuarios getSelected() {
        return selected;
    }

    public void setSelected(Usuarios selected) {
        this.selected = selected;
    }
    
    @PostConstruct
    public void init(){
        this.nuevo = new Usuarios();
        this.selected = new Usuarios();
        cu = new Controller(Usuarios.class);
        //params.put("activo", true);
    }
    
    public String selectUser(AjaxBehaviorEvent event){
        System.out.println(selected.getNombreUsuario());
        return "";
    }
    
    
   
    
    public void add(Usuarios usu){
        Perfiles perfil = new Perfiles();
        perfil.setIdPerfil(2);
        usu.setPerfiles(perfil);
        try {
            if (cu.add(usu)) {
                 FacesContext context = FacesContext.getCurrentInstance();
                 context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Excelente! Usuario agregado",  "Se agregó el Usuario") );
                 nuevo = new Usuarios();
                 
                 RequestContext ctx = RequestContext.getCurrentInstance();
                 ctx.execute("PF('nuevo').hide()");
                 RequestContext.getCurrentInstance().reset("form2");
            }else{
                 FacesContext context = FacesContext.getCurrentInstance();
                 context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error al agregar el usuario",  "  ") );
             }
         } catch (Exception e) {
             FacesContext context = FacesContext.getCurrentInstance();
             context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,"Error Grave",  "Ocurrió una excepción al intentar agregar el usuario") );
         }
    }
    
  
    
    
    
  
    
    public void volver(){
    RequestContext.getCurrentInstance().closeDialog(null);
    }
    
    public Usuarios obtener(String login){
        Usuarios exist = cu.byId("username", login);
        FacesContext context = FacesContext.getCurrentInstance();
        return exist;
    }
    
    
        
}

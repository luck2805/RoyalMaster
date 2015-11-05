/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.royalmaster.royalmaster.beans;

import com.royalmaster.royalmaster.controller.Controller;
import com.royalmaster.royalmaster.entities.Peliculas;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author luciano
 */
@ManagedBean(name="acceso")
@SessionScoped
public class AccesoBean implements Serializable {
    private List<Peliculas> peliculas;
    private Controller<Peliculas> cp;
    
    public List<Peliculas> getPeliculas(){
        cp = new Controller(Peliculas.class);
        this.peliculas = cp.all();
        return peliculas;
    }
    
    public void setPeliculas(List<Peliculas> peliculas){
        this.peliculas = peliculas;
    }
    
    @PostConstruct
    public void init(){
        getPeliculas();
    }
    
}

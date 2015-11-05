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
import javax.faces.bean.ViewScoped;

/**
 *
 * @author luciano
 */
@ManagedBean(name="ver")
@ViewScoped
public class VisualizarPeliculaBean implements Serializable{
    private Peliculas nuevo;
    
    public Peliculas getNuevo(){
        return nuevo;
    }
    
    public void setNuevo(Peliculas nuevo){
        this.nuevo = nuevo;
    }
    
    @PostConstruct
    public void init(){
        nuevo = new Peliculas();   
    }    
    
    public String visualizar(Peliculas unaPeli){
        this.nuevo = unaPeli;
        return "visualizarPelicula";
    }    
    
    
}

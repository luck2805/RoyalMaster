package com.royalmaster.royalmaster.entities;
// Generated 23/10/2015 10:18:54 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Categorias generated by hbm2java
 */
@Entity
@Table(name="categorias"
    ,catalog="RoyalMaster"
)
public class Categorias  implements java.io.Serializable {


     private Integer idCategoria;
     private String nombreCategoria;
     private String descripcionCategoria;
     private Set peliculases = new HashSet(0);

    public Categorias() {
    }

	
    public Categorias(String nombreCategoria, String descripcionCategoria) {
        this.nombreCategoria = nombreCategoria;
        this.descripcionCategoria = descripcionCategoria;
    }
    public Categorias(String nombreCategoria, String descripcionCategoria, Set peliculases) {
       this.nombreCategoria = nombreCategoria;
       this.descripcionCategoria = descripcionCategoria;
       this.peliculases = peliculases;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idCategoria", unique=true, nullable=false)
    public Integer getIdCategoria() {
        return this.idCategoria;
    }
    
    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    
    @Column(name="nombreCategoria", nullable=false, length=45)
    public String getNombreCategoria() {
        return this.nombreCategoria;
    }
    
    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    
    @Column(name="descripcionCategoria", nullable=false, length=300)
    public String getDescripcionCategoria() {
        return this.descripcionCategoria;
    }
    
    public void setDescripcionCategoria(String descripcionCategoria) {
        this.descripcionCategoria = descripcionCategoria;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="categorias")
    public Set getPeliculases() {
        return this.peliculases;
    }
    
    public void setPeliculases(Set peliculases) {
        this.peliculases = peliculases;
    }




}


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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.primefaces.showcase.view.csv.Email;

/**
 * Usuarios generated by hbm2java
 */
@Entity
@Table(name="usuarios"
    ,catalog="RoyalMaster"
)
public class Usuarios  implements java.io.Serializable {


     private Integer idUsuario;
     private Perfiles perfiles;
     private String nombreUsuario;
     private String contrasenaUsuario;
     @Email(message = "must be a valid email")
     private String email;
     private Set peliculasXclientes = new HashSet(0);

    public Usuarios() {
        
    }

	
    public Usuarios(Perfiles perfiles, String nombreUsuario, String contrasenaUsuario, String email) {
        this.perfiles = perfiles;
        this.nombreUsuario = nombreUsuario;
        this.contrasenaUsuario = contrasenaUsuario;
        this.email = email;
    }
    public Usuarios(Perfiles perfiles, String nombreUsuario, String contrasenaUsuario, String email, Set peliculasXclientes) {
       this.perfiles = perfiles;
       this.nombreUsuario = nombreUsuario;
       this.contrasenaUsuario = contrasenaUsuario;
       this.email = email;
       this.peliculasXclientes = peliculasXclientes;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)
     
    
    @Column(name="idUsuario", unique=true, nullable=false)
    public Integer getIdUsuario() {
        return this.idUsuario;
    }
    
    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idPerfil", nullable=false, insertable=false, updatable=false)
    public Perfiles getPerfiles() {
        return this.perfiles;
    }
    
    public void setPerfiles(Perfiles perfiles) {
        this.perfiles = perfiles;
    }

    
    @Column(name="nombreUsuario", nullable=false, length=45)
    public String getNombreUsuario() {
        return this.nombreUsuario;
    }
    
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    
    @Column(name="contrasenaUsuario", nullable=false, length=45)
    public String getContrasenaUsuario() {
        return this.contrasenaUsuario;
    }
    
    public void setContrasenaUsuario(String contrasenaUsuario) {
        this.contrasenaUsuario = contrasenaUsuario;
    }

    
    @Column(name="email", nullable=true, length=100)
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="usuarios")
    public Set getPeliculasXclientes() {
        return this.peliculasXclientes;
    }
    
    public void setPeliculasXclientes(Set peliculasXclientes) {
        this.peliculasXclientes = peliculasXclientes;
    }




}


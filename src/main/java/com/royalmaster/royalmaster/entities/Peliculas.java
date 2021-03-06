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

/**
 * Peliculas generated by hbm2java
 */
@Entity
@Table(name="peliculas"
    ,catalog="RoyalMaster"
)
public class Peliculas  implements java.io.Serializable {


     private Integer idPelicula;
     private Categorias categorias;
     private Directores directores;
     private String nombrePelicula;
     private int anioEstreno;
     private double precioPelicula;
     private String sinopsis;
     private String video;
     private String imagen;
     private String imagengrande;
     private Set peliculasXclientes = new HashSet(0);

    public Peliculas() {
    }

	
    public Peliculas(Categorias categorias, Directores directores, String nombrePelicula, int anioEstreno, double precioPelicula, String sinopsis) {
        this.categorias = categorias;
        this.directores = directores;
        this.nombrePelicula = nombrePelicula;
        this.anioEstreno = anioEstreno;
        this.precioPelicula = precioPelicula;
        this.sinopsis = sinopsis;
    }
    public Peliculas(Categorias categorias, Directores directores, String nombrePelicula, int anioEstreno, double precioPelicula, String sinopsis, Set peliculasXclientes) {
       this.categorias = categorias;
       this.directores = directores;
       this.nombrePelicula = nombrePelicula;
       this.anioEstreno = anioEstreno;
       this.precioPelicula = precioPelicula;
       this.sinopsis = sinopsis;
       this.peliculasXclientes = peliculasXclientes;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idPelicula", unique=true, nullable=false)
    public Integer getIdPelicula() {
        return this.idPelicula;
    }
    
    public void setIdPelicula(Integer idPelicula) {
        this.idPelicula = idPelicula;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idCategoria", nullable=false)
    public Categorias getCategorias() {
        return this.categorias;
    }
    
    public void setCategorias(Categorias categorias) {
        this.categorias = categorias;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idDirector", nullable=false)
    public Directores getDirectores() {
        return this.directores;
    }
    
    public void setDirectores(Directores directores) {
        this.directores = directores;
    }

    
    @Column(name="nombrePelicula", nullable=false, length=100)
    public String getNombrePelicula() {
        return this.nombrePelicula;
    }
    
    public void setNombrePelicula(String nombrePelicula) {
        this.nombrePelicula = nombrePelicula;
    }

    
    @Column(name="anioEstreno", nullable=false)
    public int getAnioEstreno() {
        return this.anioEstreno;
    }
    
    public void setAnioEstreno(int anioEstreno) {
        this.anioEstreno = anioEstreno;
    }

    
    @Column(name="precioPelicula", nullable=false, precision=22, scale=0)
    public double getPrecioPelicula() {
        return this.precioPelicula;
    }
    
    public void setPrecioPelicula(double precioPelicula) {
        this.precioPelicula = precioPelicula;
    }

    
    @Column(name="sinopsis", nullable=false, length=300)
    public String getSinopsis() {
        return this.sinopsis;
    }
    
    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    @Column(name="imagen", nullable=false, length=100)
    public String getImagen() {
        return this.imagen;
    }
    
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    @Column(name="video", nullable=false, length=100)
    public String getVideo() {
        return this.video;
    }
    
    public void setVideo(String video){
        this.video = video;
    }

    @Column(name="imagengrande", nullable=false, length=500)
    public String getImagengrande() {
        return imagengrande;
    }

    public void setImagengrande(String imagengrande) {
        this.imagengrande = imagengrande;
    }    
    
    @OneToMany(fetch=FetchType.LAZY, mappedBy="peliculas")
    public Set getPeliculasXclientes() {
        return this.peliculasXclientes;
    }
    
    public void setPeliculasXclientes(Set peliculasXclientes) {
        this.peliculasXclientes = peliculasXclientes;
    }




}



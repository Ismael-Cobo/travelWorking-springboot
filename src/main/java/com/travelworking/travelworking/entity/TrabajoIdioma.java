package com.travelworking.travelworking.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class TrabajoIdioma implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "trabajo_id")
    private Trabajo trabajo;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idioma_id")
    private Idioma idioma;
    
    private String nivel;
    
    public TrabajoIdioma() {
    }
    
    public TrabajoIdioma(Long id, String nivel) {
        this.id = id;
        this.nivel = nivel;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getNivel() {
        return nivel;
    }
    
    public void setNivel(String nivel) {
        this.nivel = nivel;
    }
    
    public Trabajo getTrabajo() {
        return trabajo;
    }
    
    public void setTrabajo(Trabajo trabajo) {
        this.trabajo = trabajo;
    }
    
    public Idioma getIdioma() {
        return idioma;
    }
    
    public void setIdioma(Idioma idioma) {
        this.idioma = idioma;
    }
}

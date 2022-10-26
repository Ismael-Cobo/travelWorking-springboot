package com.travelworking.travelworking.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "idiomas")
public class Idioma implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String idioma;
    
    
    public Idioma() {
    }
    
    public Idioma(Long id, String idioma) {
        this.id = id;
        this.idioma = idioma;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getIdioma() {
        return idioma;
    }
    
    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }
}

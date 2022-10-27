package com.travelworking.travelworking.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "trabajos")
public class Trabajo implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long trabajoId;
    
    @Column(name = "fecha_inicio")
    private Date fechaInicio;
    
    @Column(name = "fecha_fin")
    private Date fechaFin;
    
    @Column(length = 1000)
    private String descripcion;
    
    @Column(length = 1000)
    private String ayuda;
    
    @Column(length = 1000)
    private String aprender;
    
    @Column(name = "pais_residencia")
    private String paisResidencia;
    
    @Column(name = "lugar_residencia")
    private String lugarResidencia;
    
//    @ManyToMany(mappedBy = "trabajosCliente")
//    private List<Cliente> clientes;

    @OneToMany(mappedBy = "trabajo")
    private List<TrabajoIdioma> trabajoIdiomas;
    
    public Trabajo() {
    }
    
    public Trabajo(
        Long trabajoId,
        Date fechaInicio,
        Date fechaFin,
        String descripcion,
        String ayuda,
        String aprender,
        String paisResidencia,
        String lugarResidencia
    ) {
        this.trabajoId = trabajoId;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.descripcion = descripcion;
        this.ayuda = ayuda;
        this.aprender = aprender;
        this.paisResidencia = paisResidencia;
        this.lugarResidencia = lugarResidencia;
    }
    
    public Long getTrabajoId() {
        return trabajoId;
    }
    
    public void setTrabajoId(Long trabajoId) {
        this.trabajoId = trabajoId;
    }
    
    public Date getFechaInicio() {
        return fechaInicio;
    }
    
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
    
    public Date getFechaFin() {
        return fechaFin;
    }
    
    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }
    
    public String getDescipicion() {
        return descripcion;
    }
    
    public void setDescipicion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public String getAyuda() {
        return ayuda;
    }
    
    public void setAyuda(String ayuda) {
        this.ayuda = ayuda;
    }
    
    public String getAprender() {
        return aprender;
    }
    
    public void setAprender(String aprender) {
        this.aprender = aprender;
    }
    
    public String getPaisResidencia() {
        return paisResidencia;
    }
    
    public void setPaisResidencia(String paisResidencia) {
        this.paisResidencia = paisResidencia;
    }
    
    public String getLugarResidencia() {
        return lugarResidencia;
    }
    
    public void setLugarResidencia(String lugarResidencia) {
        this.lugarResidencia = lugarResidencia;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public List<TrabajoIdioma> getTrabajoIdiomas() {
        return trabajoIdiomas;
    }
    
    public void setTrabajoIdiomas(List<TrabajoIdioma> trabajoIdiomas) {
        this.trabajoIdiomas = trabajoIdiomas;
    }
}

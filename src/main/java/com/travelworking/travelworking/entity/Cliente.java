package com.travelworking.travelworking.entity;

import com.travelworking.travelworking.enums.TipoCliente;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "clientes")
public class Cliente implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clienteId;
    
    @Column(nullable = false, unique = true)
    private String dni;
    private String nombre;
    private String apellidos;
    @Column(nullable = false, unique = true)
    private String email;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_cliente")
    private TipoCliente tiposCliente;
    
    
//    @ManyToMany
//    @JoinTable(
//            name = "cliente_trabajo",
//            joinColumns = { @JoinColumn(name = "clienteId") },
//            inverseJoinColumns = { @JoinColumn(name = "trabajoId") }
//    )
//    private List<Trabajo> trabajosCliente;
//
    public Cliente() {
    }
    
    public Cliente(
            Long clienteId,
            String dni,
            String nombre,
            String apellidos,
            String email,
            TipoCliente tiposCliente
    ) {
        this.clienteId = clienteId;
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.tiposCliente = tiposCliente;
    }
    
    public Long getClienteId() {
        return clienteId;
    }
    
    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }
    
    public String getDni() {
        return dni;
    }
    
    public void setDni(String dni) {
        this.dni = dni;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getApellidos() {
        return apellidos;
    }
    
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public TipoCliente getTiposCliente() {
        return tiposCliente;
    }
    
    public void setTiposCliente(TipoCliente tiposCliente) {
        this.tiposCliente = tiposCliente;
    }
}

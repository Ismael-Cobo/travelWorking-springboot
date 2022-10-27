package com.travelworking.travelworking.controller;

import com.travelworking.travelworking.entity.Idioma;
import com.travelworking.travelworking.handler.ResponseHandler;
import com.travelworking.travelworking.service.idioma.IdiomaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/idioma")
public class IdiomasController {
    
    private final IdiomaService idiomaService;
    
    public IdiomasController(IdiomaService idiomaService) {
        this.idiomaService = idiomaService;
    }
    
    @GetMapping
    public ResponseEntity<Object> getAllIdiomas() {
        try {
            
            return ResponseHandler.generateResponse(
                    "Datos recibidos correctamente",
                    HttpStatus.OK,
                    idiomaService.findAll(),
                    true
            );
        } catch (Exception e) {
            return ResponseHandler.generateResponse(
                    "Los datos no se han podido recuperar",
                    HttpStatus.BAD_REQUEST,
                    null,
                    false
            );
        }
    }
    
    
    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneById(@PathVariable("id") Long id) {
        
        try {
            return ResponseHandler.generateResponse(
                    "El idioma " + id + " se ha recuperado",
                    HttpStatus.OK,
                    idiomaService.findOneById(id),
                    true
            );
            
        } catch (Exception e) {
            return ResponseHandler.generateResponse(
                    e.getMessage(),
                    HttpStatus.BAD_REQUEST,
                    null,
                    false
            );
        }
    }
    
    @PostMapping
    public ResponseEntity<Object> save(@RequestBody Idioma idioma) {
        
        try {
            
            return ResponseHandler.generateResponse(
                    "El idioma se ha podido guardar",
                    HttpStatus.OK,
                    idiomaService.saveIdioma(idioma),
                    true
            );
        } catch (Exception e) {
            return ResponseHandler.generateResponse(
                    e.getMessage(),
                    HttpStatus.BAD_REQUEST,
                    null,
                    false
            );
        }
    }
    
    @PutMapping
    public ResponseEntity<Object> update(@RequestBody Idioma idioma) {
        
        try {
            
            return ResponseHandler.generateResponse(
                    "El idioma se ha actualizado",
                    HttpStatus.OK,
                    idiomaService.updateIdioma(idioma),
                    true
            );
            
            
        } catch (Exception e) {
            return ResponseHandler.generateResponse(
                    e.getMessage(),
                    HttpStatus.BAD_REQUEST,
                    null,
                    false
            );
        }
        
    }
}

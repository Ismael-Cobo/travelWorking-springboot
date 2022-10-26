package com.travelworking.travelworking.controller;

import com.travelworking.travelworking.entity.Idioma;
import com.travelworking.travelworking.handler.ResponseHandler;
import com.travelworking.travelworking.service.idioma.IdiomaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
            List<Idioma> idiomas = idiomaService.findAll();
            return ResponseHandler.generateResponse(
                    "Datos recibidos correctamente",
                    HttpStatus.OK,
                    idiomas,
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
            
            Optional<Idioma> optionalIdioma = idiomaService.findOneById(id);
            
            if (optionalIdioma.isEmpty())
                return ResponseHandler.generateResponse(
                        "El idioma " + id + " no existe",
                        HttpStatus.NOT_FOUND,
                        null,
                        false
                );
            
            return ResponseHandler.generateResponse(
                    "El idioma " + id + " se ha recuperado",
                    HttpStatus.OK,
                    optionalIdioma.get(),
                    true
            );
            
        } catch (Exception e) {
            return ResponseHandler.generateResponse(
                    "El idioma " + id + " no se ha podido recuperar",
                    HttpStatus.BAD_REQUEST,
                    null,
                    false
            );
        }
    }
    
    @PostMapping
    public ResponseEntity<Object> save(@RequestBody Idioma idioma) {
        
        try {
            
            Idioma idiomaSaved = idiomaService.saveIdioma(idioma);
            
            return ResponseHandler.generateResponse(
                    "El idioma se ha podido guardar",
                    HttpStatus.OK,
                    idiomaSaved,
                    true
            );
        } catch (Exception e) {
            return ResponseHandler.generateResponse(
                    "El idioma no se ha podido guardar",
                    HttpStatus.BAD_REQUEST,
                    null,
                    false
            );
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable("id") Long id, @RequestBody Idioma idioma) {
        
        try {
            
            Optional<Idioma> optionalIdioma = idiomaService.findOneById(id);
            if (optionalIdioma.isEmpty())
                return ResponseHandler.generateResponse(
                        "El idioma no se ha encontrado",
                        HttpStatus.NOT_FOUND,
                        null,
                        false
                );
    
            return ResponseHandler.generateResponse(
                    "El idioma se ha actualizado",
                    HttpStatus.OK,
                    idiomaService.saveIdioma(idioma),
                    true
            );
            
            
        } catch (Exception e) {
            return ResponseHandler.generateResponse(
                    "El idioma no se ha podido actualizar",
                    HttpStatus.BAD_REQUEST,
                    null,
                    false
            );
        }
        
    }
}

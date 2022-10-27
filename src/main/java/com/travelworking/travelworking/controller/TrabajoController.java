package com.travelworking.travelworking.controller;

import com.travelworking.travelworking.entity.Trabajo;
import com.travelworking.travelworking.service.trabajo.TrabajoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trabajo")
public class TrabajoController {
    
    private final TrabajoService trabajoService;
    
    public TrabajoController(TrabajoService trabajoService) {
        this.trabajoService = trabajoService;
    }
    
    @GetMapping
    public ResponseEntity<List<Trabajo>> findAll() {
        return ResponseEntity.ok(trabajoService.findAll());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Trabajo> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(trabajoService.findById(id));
    }
    
    @PostMapping
    public ResponseEntity<Trabajo> save(@RequestBody Trabajo trabajo) {
        return ResponseEntity.ok(trabajoService.save(trabajo));
    }
}

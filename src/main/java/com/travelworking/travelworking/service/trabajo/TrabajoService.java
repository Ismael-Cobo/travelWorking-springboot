package com.travelworking.travelworking.service.trabajo;


import com.travelworking.travelworking.entity.Trabajo;

import java.util.List;

public interface TrabajoService {
    
    
    List<Trabajo> findAll();
    
    Trabajo findById(Long id);
    Trabajo save(Trabajo trabajo);
    
    
    
}

package com.travelworking.travelworking.service.idioma;

import com.travelworking.travelworking.entity.Idioma;

import java.util.List;
import java.util.Optional;

public interface IdiomaService {
    
    List<Idioma> findAll();
    
    List<Idioma> findAllById(List<Long> ids);
    
    Idioma findOneById(Long id);
    
    Idioma saveIdioma(Idioma idioma);
    
    Idioma updateIdioma(Idioma idioma);
    
}

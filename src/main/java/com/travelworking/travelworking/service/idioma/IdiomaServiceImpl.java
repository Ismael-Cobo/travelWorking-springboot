package com.travelworking.travelworking.service.idioma;

import com.travelworking.travelworking.entity.Idioma;
import com.travelworking.travelworking.exceptions.NoSuchIdiomaExistsException;
import com.travelworking.travelworking.repository.IdiomaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IdiomaServiceImpl implements IdiomaService {
    
    private final IdiomaRepository idiomaRepository;
    
    public IdiomaServiceImpl(IdiomaRepository idiomaRepository) {
        this.idiomaRepository = idiomaRepository;
    }
    
    @Override
    public List<Idioma> findAll() {
        return idiomaRepository.findAll();
    }
    
    @Override
    public List<Idioma> findAllById(List<Long> ids) {
        return idiomaRepository.findAllById(ids);
    }
    
    @Override
    public Idioma findOneById(Long id) {
        return idiomaRepository.findById(id)
                .orElseThrow(() -> new NoSuchIdiomaExistsException("El idioma " + id + " no existe"));
    }
    
    @Override
    public Idioma saveIdioma(Idioma idioma) {
        if (idioma == null)
            throw new IllegalArgumentException("El idioma es obligatorio");
        
        return idiomaRepository.save(idioma);
    }
    
    @Override
    public Idioma updateIdioma(Idioma idioma) {
        if(idioma.getId() == null || !idiomaRepository.existsById(idioma.getId()))
            throw new NoSuchIdiomaExistsException("El idioma no existe.");
        
        return idiomaRepository.save(idioma);
        
    }
    
}

package com.travelworking.travelworking.service.idioma;

import com.travelworking.travelworking.entity.Idioma;
import com.travelworking.travelworking.exceptions.ApiRequestExceptions;
import com.travelworking.travelworking.repository.IdiomaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IdiomaServiceImpl implements IdiomaService{
    
    private final IdiomaRepository idiomaRepository;
    
    public IdiomaServiceImpl(IdiomaRepository idiomaRepository) {
        this.idiomaRepository = idiomaRepository;
    }
    
    @Override
    public List<Idioma> findAll() {
        return idiomaRepository.findAll();
    }
    
    @Override
    public Optional<Idioma> findOneById(Long id) {
        
        return idiomaRepository.existsById(id)
                ? idiomaRepository.findById(id)
                : Optional.empty();
    }
    
    @Override
    public Idioma saveIdioma(Idioma idioma) {
        if(idioma == null)
            throw new ApiRequestExceptions("El idioma es obligatorio");
        
        return idiomaRepository.save(idioma);
    }
    
}

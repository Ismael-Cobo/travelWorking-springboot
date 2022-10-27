package com.travelworking.travelworking.service.trabajo;

import com.travelworking.travelworking.entity.Idioma;
import com.travelworking.travelworking.entity.Trabajo;
import com.travelworking.travelworking.entity.TrabajoIdioma;
import com.travelworking.travelworking.exceptions.NoSuchTrabajoExistsException;
import com.travelworking.travelworking.repository.TrabajoIdiomaRepository;
import com.travelworking.travelworking.repository.TrabajoRepository;
import com.travelworking.travelworking.service.idioma.IdiomaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrabajoServiceImpl implements TrabajoService {
    
    private final TrabajoRepository trabajoRepository;
    private final TrabajoIdiomaRepository trabajoIdiomaRepository;
    private final IdiomaService idiomaService;
    
    public TrabajoServiceImpl(
            TrabajoRepository trabajoRepository,
            TrabajoIdiomaRepository trabajoIdiomaRepository,
            IdiomaService idiomaService
    ) {
        this.trabajoRepository = trabajoRepository;
        this.trabajoIdiomaRepository = trabajoIdiomaRepository;
        this.idiomaService = idiomaService;
    }
    
    @Override
    public List<Trabajo> findAll() {
        return trabajoRepository.findAll();
    }
    
    @Override
    public Trabajo findById(Long id) {
        return trabajoRepository.findById(id)
                .orElseThrow(() -> new NoSuchTrabajoExistsException("El trabajo no" + id + "existe"));
    }
    
    @Override
    public Trabajo save(Trabajo trabajo) {
        
        Trabajo trabajoDB = trabajoRepository.save(trabajo);
//
//        List<Idioma> idiomas = trabajoDB.getTrabajoIdiomas().stream().map(TrabajoIdioma::getIdioma).toList();
//
//        List<Long> idiomasIds = idiomas.stream().map(Idioma::getId).toList();
//
//        List<Idioma> idiomaList = idiomaService.findAllById(idiomasIds);
//

        
//        trabajoIdiomaRepository.saveAll(trabajoDB.getTrabajoIdiomas());
        return trabajoDB;
    }
}

package com.tp_backend.ms_comercial.service.impl;

import com.tp_backend.ms_comercial.model.Contenedor;
import com.tp_backend.ms_comercial.repository.ContenedorRepository;
import com.tp_backend.ms_comercial.service.ContenedorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContenedorServiceImpl implements ContenedorService {

    private final ContenedorRepository contenedorRepository;

    public ContenedorServiceImpl(ContenedorRepository contenedorRepository) {
        this.contenedorRepository = contenedorRepository;
    }

    @Override
    public List<Contenedor> findAll() {
        return contenedorRepository.findAll();
    }

    @Override
    public Contenedor findById(Long id) {
        return contenedorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contenedor no encontrado"));
    }

    @Override
    public Contenedor save(Contenedor contenedor) {
        return contenedorRepository.save(contenedor);
    }

    @Override
    public Contenedor update(Long id, Contenedor contenedor) {
        Contenedor existing = findById(id);
        contenedor.setId(existing.getId());
        return contenedorRepository.save(contenedor);
    }

    @Override
    public void delete(Long id) {
        contenedorRepository.deleteById(id);
    }
}


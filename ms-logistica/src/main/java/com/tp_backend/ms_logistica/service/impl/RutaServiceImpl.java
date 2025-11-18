package com.tp_backend.ms_logistica.service.impl;

import com.tp_backend.ms_logistica.model.Ruta;
import com.tp_backend.ms_logistica.repository.RutaRepository;
import com.tp_backend.ms_logistica.service.RutaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RutaServiceImpl implements RutaService {

    private final RutaRepository rutaRepository;

    public RutaServiceImpl(RutaRepository rutaRepository) {
        this.rutaRepository = rutaRepository;
    }

    @Override
    public List<Ruta> findAll() {
        return rutaRepository.findAll();
    }

    @Override
    public Ruta findById(Long id) {
        return rutaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ruta no encontrada"));
    }

    @Override
    public Ruta save(Ruta ruta) {
        return rutaRepository.save(ruta);
    }

    @Override
    public Ruta update(Long id, Ruta ruta) {
        Ruta existing = findById(id);
        ruta.setId(existing.getId());
        return rutaRepository.save(ruta);
    }

    @Override
    public void delete(Long id) {
        rutaRepository.deleteById(id);
    }
}


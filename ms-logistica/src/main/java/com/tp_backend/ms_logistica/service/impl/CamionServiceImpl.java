package com.tp_backend.ms_logistica.service.impl;

import com.tp_backend.ms_logistica.model.Camion;
import com.tp_backend.ms_logistica.repository.CamionRepository;
import com.tp_backend.ms_logistica.service.CamionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CamionServiceImpl implements CamionService {

    private final CamionRepository camionRepository;

    public CamionServiceImpl(CamionRepository camionRepository) {
        this.camionRepository = camionRepository;
    }

    @Override
    public List<Camion> findAll() {
        return camionRepository.findAll();
    }

    @Override
    public Camion findById(Long id) {
        return camionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Camion no encontrado"));
    }

    @Override
    public Camion save(Camion camion) {
        return camionRepository.save(camion);
    }

    @Override
    public Camion update(Long id, Camion camion) {
        Camion existing = findById(id);
        camion.setId(existing.getId());
        return camionRepository.save(camion);
    }

    @Override
    public void delete(Long id) {
        camionRepository.deleteById(id);
    }
}


package com.tp_backend.ms_logistica.service;

import com.tp_backend.ms_logistica.model.Camion;

import java.util.List;

public interface CamionService {
    List<Camion> findAll();
    Camion findById(Long id);
    Camion save(Camion camion);
    Camion update(Long id, Camion camion);
    void delete(Long id);
}


package com.tp_backend.ms_logistica.service;

import com.tp_backend.ms_logistica.model.Ruta;

import java.util.List;

public interface RutaService {
    List<Ruta> findAll();
    Ruta findById(Long id);
    Ruta save(Ruta ruta);
    Ruta update(Long id, Ruta ruta);
    void delete(Long id);
}


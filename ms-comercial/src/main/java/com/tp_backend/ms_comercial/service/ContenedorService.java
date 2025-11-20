package com.tp_backend.ms_comercial.service;

import com.tp_backend.ms_comercial.model.Contenedor;
import java.util.List;

public interface ContenedorService {

    List<Contenedor> findAll();
    Contenedor findById(Long id);
    Contenedor save(Contenedor contenedor);
    Contenedor update(Long id, Contenedor contenedor);
    void delete(Long id);
}


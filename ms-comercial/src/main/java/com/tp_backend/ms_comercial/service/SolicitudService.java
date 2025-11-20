package com.tp_backend.ms_comercial.service;

import com.tp_backend.ms_comercial.model.Solicitud;
import com.tp_backend.ms_comercial.dto.SolicitudDTO;
import com.tp_backend.ms_comercial.dto.CreateSolicitudRequest;
import java.util.List;

public interface SolicitudService {

    List<Solicitud> findAll();
    Solicitud findById(Long id);
    Solicitud save(CreateSolicitudRequest dto);
    Solicitud update(Long id, SolicitudDTO dto);
    void delete(Long id);
}


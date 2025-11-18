package com.tp_backend.ms_logistica.service;

import com.tp_backend.ms_logistica.model.Tramo;
import com.tp_backend.ms_logistica.dto.TramoDTO;
import com.tp_backend.ms_logistica.dto.CreateTramoRequest;



import java.util.List;

public interface TramoService {
    List<Tramo> findAll();
    Tramo findById(Long id);
    Tramo save(CreateTramoRequest dto);
    Tramo update(Long id, TramoDTO dto);
    void delete(Long id);
}


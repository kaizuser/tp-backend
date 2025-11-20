package com.tp_backend.ms_comercial.service;

import com.tp_backend.ms_comercial.model.Tarifa;
import com.tp_backend.ms_comercial.dto.TarifaDTO;
import com.tp_backend.ms_comercial.dto.CreateTarifaRequest;
import java.util.List;

public interface TarifaService {

    List<Tarifa> findAll();
    Tarifa findById(Long id);
    Tarifa save(CreateTarifaRequest dto);
    Tarifa update(Long id, TarifaDTO dto);
    void delete(Long id);
}


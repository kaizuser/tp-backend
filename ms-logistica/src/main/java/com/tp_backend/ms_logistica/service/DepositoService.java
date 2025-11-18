package com.tp_backend.ms_logistica.service;

import com.tp_backend.ms_logistica.model.Deposito;

import java.util.List;

public interface DepositoService {
    List<Deposito> findAll();
    Deposito findById(Long id);
    Deposito save(Deposito deposito);
    Deposito update(Long id, Deposito deposito);
    void delete(Long id);
}


package com.tp_backend.ms_logistica.service.impl;

import com.tp_backend.ms_logistica.model.Deposito;
import com.tp_backend.ms_logistica.repository.DepositoRepository;
import com.tp_backend.ms_logistica.service.DepositoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepositoServiceImpl implements DepositoService {

    private final DepositoRepository depositoRepository;

    public DepositoServiceImpl(DepositoRepository depositoRepository) {
        this.depositoRepository = depositoRepository;
    }

    @Override
    public List<Deposito> findAll() {
        return depositoRepository.findAll();
    }

    @Override
    public Deposito findById(Long id) {
        return depositoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Deposito no encontrado"));
    }

    @Override
    public Deposito save(Deposito deposito) {
        return depositoRepository.save(deposito);
    }

    @Override
    public Deposito update(Long id, Deposito deposito) {
        Deposito existing = findById(id);
        deposito.setId(existing.getId());
        return depositoRepository.save(deposito);
    }

    @Override
    public void delete(Long id) {
        depositoRepository.deleteById(id);
    }
}


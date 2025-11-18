package com.tp_backend.ms_logistica.repository;

import com.tp_backend.ms_logistica.model.Camion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CamionRepository extends JpaRepository<Camion, Long> {
}


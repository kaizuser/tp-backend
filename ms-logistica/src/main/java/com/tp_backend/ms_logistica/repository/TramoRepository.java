package com.tp_backend.ms_logistica.repository;

import com.tp_backend.ms_logistica.model.Tramo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TramoRepository extends JpaRepository<Tramo, Long> {
}


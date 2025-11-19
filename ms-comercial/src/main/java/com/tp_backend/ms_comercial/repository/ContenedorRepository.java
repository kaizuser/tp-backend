package com.tp_backend.ms_comercial.repository;

import com.tp_backend.ms_comercial.model.Contenedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContenedorRepository extends JpaRepository<Contenedor, Long> {
}


package com.tp_backend.api_gateway.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestRolesController {

    @GetMapping("/cliente")
    @PreAuthorize("hasRole('CLIENTE')")
    public ResponseEntity<String> testCliente() {
        return ResponseEntity.ok("OK. Sos CLIENTE");
    }

    @GetMapping("/empleado")
    @PreAuthorize("hasRole('EMPLEADO')")
    public ResponseEntity<String> testEmpleado() {
        return ResponseEntity.ok("OK. Sos EMPLEADO");
    }

}
package com.tp_backend.ms_logistica;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/gestion-logistica/test")
    public String test() {
        return "MS Logistica funcionando!";
    }
}

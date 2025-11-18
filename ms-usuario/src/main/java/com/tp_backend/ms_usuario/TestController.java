package com.tp_backend.ms_usuario;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/gestion-usuario/test")
    public String test() {
        return "MS Usuario funcionando!";
    }
}

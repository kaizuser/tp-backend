package com.tp_backend.ms_comercial;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/gestion-comercial/test")
    public String test() {
        return "MS Comercial funcionando!";
    }
}

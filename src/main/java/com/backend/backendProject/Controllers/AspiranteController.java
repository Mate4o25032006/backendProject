package com.backend.backendProject.Controllers;

import com.backend.backendProject.Entities.Aspirante;
import com.backend.backendProject.Services.AspiranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AspiranteController {
    @Autowired
    AspiranteService aspiranteService;

    //Petición GET de prueba
    @GetMapping("/aspirantes")
    public String index(){
        return "CONECTADO EXITOSAMENTE";
    }

    //Petición POST
    @PostMapping("/aspirantes")
    public String registrarAspirante(@RequestBody Aspirante aspirante){
        return aspiranteService.registrarAspirante(aspirante);
    }
}

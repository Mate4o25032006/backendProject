package com.backend.backendProject.Controllers;

import com.backend.backendProject.Entities.Aspirante;
import jakarta.validation.Valid;
import com.backend.backendProject.Services.AspiranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1")
public class AspiranteController {
    @Autowired
    AspiranteService aspiranteService;

    //Petición GET de prueba
    @GetMapping()
    public String index(){
        return "Conectado Exactamente";
    }

    //Endpoint para traer listado completo de Aspirantes
    @GetMapping("/aspirantes")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Aspirante> obtenerAspirantes(){
        return aspiranteService.obtenerAspirantes();
    }

    //Endpoint para traer un Aspirante específico
    @GetMapping("/aspirantes/{numDocumento}")
    @PreAuthorize("hasRole('ADMIN')")
    public Optional<Aspirante> obtenerAspiranteById(@PathVariable("numDocumento") String numDocumento){
        return aspiranteService.obtenerAspiranteById(numDocumento);
    }

    //Petición POST
    @PostMapping("/registroaspirantes")
    public ResponseEntity<String> registrarAspirante(@RequestBody @Valid Aspirante aspirante){
        return aspiranteService.registrarAspirante(aspirante);
    }

    //Petición DELETE
    @DeleteMapping("/aspirantes/{numDocumento}")
    @PreAuthorize("hasRole('ADMIN')")
    public String eliminarAspirante(@PathVariable("numDocumento") String numDocumento){
        return aspiranteService.eliminarAspirante(numDocumento);
    }
}
/*package com.backend.backendProject.Controllers;

import com.backend.backendProject.Entities.Aspirante;
import com.backend.backendProject.Entities.Usuario;
import com.backend.backendProject.Services.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    //Petición GET de prueba
    @GetMapping()
    public String index(){
        return "CONECTADO EXITOSAMENTE AL CONTROLLER DE USUARIOS";
    }

    //Petición POST
    @PostMapping("/usuarios")
    public ResponseEntity<String> registrarAspirante(@RequestBody @Valid Usuario usuario){
        return usuarioService.guardarUsuario(usuario);
    }
}
*/

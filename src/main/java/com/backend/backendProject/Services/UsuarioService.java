package com.backend.backendProject.Services;

import com.backend.backendProject.Entities.Usuario;
import com.backend.backendProject.Exceptions.DatabaseException;
import com.backend.backendProject.Exceptions.InfoExistenteException;
import com.backend.backendProject.Repositories.UsuarioRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class UsuarioService {
    @Autowired
    PasswordEncoder passwordEncoder;
    private final UsuarioRepository usuarioRepository;
    private final RolService rolService;

    public UsuarioService(UsuarioRepository usuarioRepository, RolService rolService) {
        this.usuarioRepository = usuarioRepository;
        this.rolService = rolService;
    }

    //Método para registrar un Usuario
    @Transactional
    public ResponseEntity<String> guardarUsuario(@RequestBody @Valid Usuario usuario){
        try {
            Usuario validUsuario = usuarioRepository.findByEmail(usuario.getEmail());
            if (validUsuario != null){
                throw new InfoExistenteException("El correo ya existe.");
            }else{
                usuario.setEmail(usuario.getEmail());
                usuario.setContrasenia(passwordEncoder.encode(usuario.getContrasenia()));
                rolService.registrarRol(usuario.getRol());

                usuarioRepository.save(usuario);
            }

            return new ResponseEntity<>("Usuario guardado correctamente", HttpStatus.CREATED);
        } catch (Exception e) {
            throw new DatabaseException("Error al guardar Usuario.");
        }
    }

}

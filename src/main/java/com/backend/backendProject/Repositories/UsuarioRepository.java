package com.backend.backendProject.Repositories;

import com.backend.backendProject.Entities.Aspirante;
import com.backend.backendProject.Entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository  extends JpaRepository<Usuario, Long> {
    public Usuario findByEmail(String email);
}

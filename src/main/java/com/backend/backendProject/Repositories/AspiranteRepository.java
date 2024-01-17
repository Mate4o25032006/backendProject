package com.backend.backendProject.Repositories;

import com.backend.backendProject.Entities.Aspirante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AspiranteRepository extends JpaRepository<Aspirante, String> {
    public Aspirante findByCorreo(String correo);
}

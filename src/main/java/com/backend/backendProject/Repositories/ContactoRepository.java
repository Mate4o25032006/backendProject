package com.backend.backendProject.Repositories;

import com.backend.backendProject.Entities.Contacto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactoRepository extends JpaRepository<Contacto, Long> {
}

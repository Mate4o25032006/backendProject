package com.backend.backendProject.Repositories;

import com.backend.backendProject.Entities.Aspirante;
import com.backend.backendProject.Entities.Rol;
import com.backend.backendProject.Entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolRepository extends JpaRepository<Rol, Long> {
}

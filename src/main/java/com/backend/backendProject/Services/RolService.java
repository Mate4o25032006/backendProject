package com.backend.backendProject.Services;

import com.backend.backendProject.Entities.Rol;
import com.backend.backendProject.Repositories.RolRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class RolService {
    private final RolRepository rolRepository;

    public RolService(RolRepository rolRepository) {
        this.rolRepository = rolRepository;
    }

    public String registrarRol(@RequestBody Rol rol) {
        rolRepository.save(rol);
        return "Rol Saved Successfully";
    }
}

package com.backend.backendProject.Services;

import com.backend.backendProject.Entities.Ubicacion;
import com.backend.backendProject.Repositories.UbicacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class UbicacionService {
    @Autowired
    private UbicacionRepository ubicacionRepository;

    public String guardarUbicacion(@RequestBody Ubicacion ubicacion){
        ubicacionRepository.save(ubicacion);
        return "Ubication Saved Successfully";
    }
}

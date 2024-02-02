package com.backend.backendProject.Services;

import com.backend.backendProject.Entities.Programa;
import com.backend.backendProject.Entities.SocioEconomia;
import com.backend.backendProject.Repositories.SocioeconomiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class SocioEconomiaService {
    @Autowired
    private SocioeconomiaRepository socioeconomiaRepository;

    public String guardarSocioeconomia(@RequestBody SocioEconomia socioEconomia){
        socioeconomiaRepository.save(socioEconomia);
        return "Socioeconomia Guardada Exitosamente";
    }
}

package com.backend.backendProject.Services;

import com.backend.backendProject.Entities.Programa;
import com.backend.backendProject.Repositories.ProgramaRepository;
import org.aspectj.apache.bcel.util.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class ProgramaService {
    @Autowired
    private ProgramaRepository programaRepository;

    public String guardarPrograma(@RequestBody Programa programa){
        programaRepository.save(programa);
        return "Program Saved Successfully";
    }
}

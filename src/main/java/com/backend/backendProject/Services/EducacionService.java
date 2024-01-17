package com.backend.backendProject.Services;

import com.backend.backendProject.Entities.Educacion;
import com.backend.backendProject.Entities.Programa;
import com.backend.backendProject.Repositories.EducacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class EducacionService {
    @Autowired
    private EducacionRepository educacionRepository;

    public String guardarEducacion(@RequestBody Educacion educacion){
        educacionRepository.save(educacion);
        return "Education Saved Successfully";
    }
}

package com.backend.backendProject.Services;

import com.backend.backendProject.Entities.Contacto;
import com.backend.backendProject.Entities.Ubicacion;
import com.backend.backendProject.Repositories.ContactoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class ContactoService {
    @Autowired
    private ContactoRepository contactoRepository;

    public String guardarContacto(@RequestBody Contacto contacto){
        contactoRepository.save(contacto);
        return "Contacto Guardado Exitosamente";
    }
}

package com.backend.backendProject.Services;

import com.backend.backendProject.Entities.Aspirante;
import com.backend.backendProject.Entities.Programa;
import com.backend.backendProject.Entities.Ubicacion;
import com.backend.backendProject.Repositories.AspiranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class AspiranteService {
    @Autowired
    private AspiranteRepository aspiranteRepository;

    public String registrarAspirante(@RequestBody Aspirante aspirante){
        aspirante.setNumDocumento(aspirante.getNumDocumento());
        aspirante.setTipoDocumento(aspirante.getTipoDocumento());
        aspirante.setNombre(aspirante.getNombre());
        aspirante.setGenero(aspirante.getGenero());
        aspirante.setEdad(aspirante.getEdad());
        aspirante.setFechaNacimiento(aspirante.getFechaNacimiento());
        aspirante.setCelular(aspirante.getCelular());
        aspirante.setCorreo(aspirante.getCorreo());
        aspirante.setNacionalidad(aspirante.getNacionalidad());
        aspirante.setBootcampInfo(aspirante.getBootcampInfo());
        aspirante.setSuma(aspirante.getSuma());

        Programa aspirantePrograma = aspirante.getPrograma();
        Programa programa = new Programa();
        programa.setNombre(aspirantePrograma.getNombre());


        Ubicacion aspiranteUbicacion = aspirante.getUbicacion();
        Ubicacion ubicacion = new Ubicacion();
        ubicacion.setDepartamento(aspiranteUbicacion.getDepartamento());
        ubicacion.setCiudad(aspiranteUbicacion.getCiudad());
        ubicacion.setDireccion(aspiranteUbicacion.getDireccion());

        return "Saved Successfully";
    }


}

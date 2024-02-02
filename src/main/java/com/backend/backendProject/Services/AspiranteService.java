package com.backend.backendProject.Services;

import com.backend.backendProject.Entities.*;
import com.backend.backendProject.Exceptions.AspiranteNoEncontradoException;
import com.backend.backendProject.Exceptions.DatabaseException;
import com.backend.backendProject.Exceptions.InfoExistenteException;
import com.backend.backendProject.Repositories.AspiranteRepository;
import com.backend.backendProject.TestGorilla.TestGorillaInvitation;
import com.backend.backendProject.TestGorilla.TestGorillaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.*;

@Service
public class AspiranteService {
    private final AspiranteRepository aspiranteRepository;
    private final ProgramaService programaService;
    private final UbicacionService ubicacionService;
    private final EducacionService educacionService;
    private final ContactoService contactoService;
    private final SocioEconomiaService socioEconomiaService;
    private final TestGorillaService testGorillaService;

    //Inyección de dependencias a través del constructor
    public AspiranteService(AspiranteRepository aspiranteRepository, ProgramaService programaService, UbicacionService ubicacionService, EducacionService educacionService, ContactoService contactoService, SocioEconomiaService socioEconomiaService, TestGorillaService testGorillaService) {
        this.aspiranteRepository = aspiranteRepository;
        this.programaService = programaService;
        this.ubicacionService = ubicacionService;
        this.educacionService = educacionService;
        this.contactoService = contactoService;
        this.socioEconomiaService = socioEconomiaService;
        this.testGorillaService = testGorillaService;
    }

    //Método para traer listado de Aspirantes
    public List<Aspirante> obtenerAspirantes(){
        try {
            return aspiranteRepository.findAll();
        } catch (Exception e) {
            throw new DatabaseException("Error al obtener la lista de aspirantes");
        }
    }

    //Método para obtener Aspirante en específico
    public Optional<Aspirante> obtenerAspiranteById(String numDocumento){
        try {
            Optional<Aspirante> aspirante = aspiranteRepository.findById(numDocumento);
            if (!aspirante.isPresent()) {
                throw new AspiranteNoEncontradoException("Aspirante con documento " + numDocumento + " no encontrado");
            }
            return aspirante;
        } catch (Exception e) {
            throw new DatabaseException("Error al obtener el aspirante con documento " + numDocumento);
        }
    }

    //Método de Registro de Aspirantes
    @Transactional
    public ResponseEntity<String> registrarAspirante(@RequestBody @Valid Aspirante aspirante){
        try {
            Aspirante validAspirante = aspiranteRepository.findByCorreo(aspirante.getCorreo());
            if (validAspirante != null){
                throw new InfoExistenteException("El correo ya existe.");
            }else{
                contactoService.guardarContacto(aspirante.getDatosContactoExterno());
                programaService.guardarPrograma(aspirante.getPrograma());
                ubicacionService.guardarUbicacion(aspirante.getUbicacion());
                educacionService.guardarEducacion(aspirante.getDatosEducativos());
                socioEconomiaService.guardarSocioeconomia(aspirante.getDatosSocioeconomia());

                //TestGorillaInvitation invitation = testGorillaService.enviarInvitacion(aspirante.getCorreo());
                //aspirante.setTesttakerId(invitation.getTesttaker_id());

                aspiranteRepository.save(aspirante);

            }
            return new ResponseEntity<>("Se registró Correctamente", HttpStatus.CREATED);
        } catch (Exception e) {
            throw new DatabaseException("Ha ocurrido un error en el registro.");
        }
    }

    //Método para eliminar Aspirante
    public String eliminarAspirante(@PathVariable String numDocumento){
        try {
            Optional<Aspirante> aspiranteEliminado = aspiranteRepository.findById(numDocumento);
            if (!aspiranteEliminado.isPresent()) {
                throw new AspiranteNoEncontradoException("Aspirante con documento " + numDocumento + " no encontrado");
            }
            aspiranteRepository.delete(aspiranteEliminado.get());
            return "Aspirante Eliminado Correctamente";
        } catch (Exception e) {
            throw new DatabaseException("Error al eliminar el aspirante con documento " + numDocumento);
        }
    }

}


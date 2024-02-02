package com.backend.backendProject.Services;

import com.backend.backendProject.Entities.Programa;
import com.backend.backendProject.Repositories.ProgramaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
class ProgramaServiceTest {

    @InjectMocks
    private ProgramaService programaService;

    @Mock
    private ProgramaRepository programaRepository;


    @BeforeEach
    void beforeEach() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    void guardarProgramaDebeGuardarProgramaExitosamenteCuandoSeIngresaNuevoPrograma() {
        // Arrange
        Programa programa = new Programa();
        // Act
        String resultado = programaService.guardarPrograma(programa);


        // Assert
        verify(programaRepository, times(1)).save(programa);
        assertEquals("Programa Guardado Exitosamente", resultado);
    }

    @Test
    void guardarProgramaDebeGuardarProgramaCorrectamenteEnLaBaseDeDatos() {
        // Arrange
        Programa programa = new Programa();
        programa.setNombre("Programa de prueba");

        Mockito.when(programaRepository.findAll()).thenReturn(List.of(programa));

        // Act
        programaService.guardarPrograma(programa);

        // Assert
        verify(programaRepository, times(1)).save(programa);

        Programa programaGuardado = programaRepository.findAll().get(0);
        assertEquals(programa.getNombre(), programaGuardado.getNombre());
    }
}

package com.backend.backendProject.Services;

import com.backend.backendProject.Entities.SocioEconomia;


import com.backend.backendProject.Repositories.SocioeconomiaRepository;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;


import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
class SocioEconomiaServiceTest {

    @InjectMocks
    private SocioEconomiaService socioEconomiaService;

    @Mock
    private SocioeconomiaRepository socioeconomiaRepository;

    @BeforeEach
    void beforeEach() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    void guardarSocioeconomia_ConDatosValidos_DebeRetornarMensajeExitoso() {
        // Arrange
        SocioEconomia socioEconomia = new SocioEconomia();
        // Configura los datos del socioEconomia según lo que se considere válido

        // Act
        String mensaje = socioEconomiaService.guardarSocioeconomia(socioEconomia);

        // Assert
        assertEquals("Socioeconomia Guardada Exitosamente", mensaje);

        // Verificar que se intentó guardar el socioEconomia en el repositorio
        verify(socioeconomiaRepository).save(socioEconomia);
    }

}
package com.backend.backendProject.Services;

import com.backend.backendProject.Entities.Ubicacion;
import static org.mockito.ArgumentMatchers.any;

import com.backend.backendProject.Repositories.UbicacionRepository;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

class UbicacionServiceTest {
    @InjectMocks
    private UbicacionService ubicacionService;

    @Mock
    private UbicacionRepository ubicacionRepository;

    @BeforeEach
    void beforeEach() {
        MockitoAnnotations.openMocks(this);

    }



    @Test
    void guardarUbicacion_ConDatosInvalidos_DebeRetornarMensajeDeError() {
        // Arrange
        Ubicacion ubicacion = null;

        // Act
        String mensaje = ubicacionService.guardarUbicacion(ubicacion);

        // Assert
        assertEquals("Ubicación Guardada Exitosamente", mensaje);

        // Verificar que no se intentó guardar la ubicación en el repositorio
        verify(ubicacionRepository, never()).save(any(Ubicacion.class));
    }

    @Test
    void guardarUbicacion_ConDatosValidos_DebeRetornarMensajeExitoso() {
        // Arrange
        Ubicacion ubicacion = new Ubicacion();
        // Configura los datos de la ubicación de manera válida

        // Act
        String mensaje = ubicacionService.guardarUbicacion(ubicacion);

        // Assert
        assertEquals("Ubicación Guardada Exitosamente", mensaje);

        // Verificar que se intentó guardar la ubicación en el repositorio
        verify(ubicacionRepository).save(any(Ubicacion.class));
    }

}

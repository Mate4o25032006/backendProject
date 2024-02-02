package com.backend.backendProject.Services;

import com.backend.backendProject.Entities.Contacto;
import com.backend.backendProject.Repositories.ContactoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
class ContactoServiceTest {

    @InjectMocks
    private ContactoService contactoService;

    @Mock
    private ContactoRepository contactoRepository;

    @BeforeEach
    void beforeEach() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void guardarContactoDebeGuardarContactoExitosamenteCuandoSeIngresaUnNuevoContacto() {
        // Arrange
        Contacto contacto = new Contacto();

        // Act
        String resultado = contactoService.guardarContacto(contacto);

        // Assert
        verify(contactoRepository, times(1)).save(contacto);
        assertEquals("Contacto Guardado Exitosamente", resultado);
    }


    @Test
    void guardarContactoDebeLanzarExcepcionSiNoSePuedeGuardarElContacto() {
        // Arrange
        doThrow(new RuntimeException("Error al guardar contacto")).when(contactoRepository).save(any());

        Contacto contacto = new Contacto();

        // Act & Assert
        try {
            contactoService.guardarContacto(contacto);
        } catch (RuntimeException e) {
            // Assert
            assertEquals("Error al guardar contacto", e.getMessage());
        }

        verify(contactoRepository, times(1)).save(contacto);
    }
}


package com.backend.backendProject.Services;

import com.backend.backendProject.Entities.Educacion;
import com.backend.backendProject.Repositories.EducacionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class EducacionServiceTest {

    @InjectMocks
    private EducacionService educacionService;

    @Mock
    private EducacionRepository educacionRepository;

    @Mock
    private EducacionService educacionServiceMock;

    @BeforeEach
    void beforeEach() {
        MockitoAnnotations.openMocks(this);
        educacionServiceMock = mock(EducacionService.class);

    }
    @Test
    void guardarEducacion_DeberiaManejarExcepcionAlGuardar() {
        // Arrange
        Educacion educacion = new Educacion();
        doThrow(new RuntimeException("Error al guardar educación")).when(educacionRepository).save(educacion);

        // Act y Assert
        assertThrows(RuntimeException.class, () -> educacionService.guardarEducacion(educacion));
        verify(educacionRepository, times(1)).save(educacion);
    }

    @Test
    void guardarEducacion_DeberiaGuardarEducacionExitosamente() {
        // Arrange
        Educacion educacion = new Educacion();

        // Act
        String resultado = educacionService.guardarEducacion(educacion);

        // Assert
        verify(educacionRepository, times(1)).save(educacion);
        assertEquals("Educación Guardada Exitosamente", resultado);
    }
}
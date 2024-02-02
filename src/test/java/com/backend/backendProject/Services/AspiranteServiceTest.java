package com.backend.backendProject.Services;

import com.backend.backendProject.Entities.Aspirante;
import com.backend.backendProject.Exceptions.AspiranteNoEncontradoException;
import com.backend.backendProject.Exceptions.DatabaseException;
import com.backend.backendProject.Repositories.AspiranteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;


import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
class AspiranteServiceTest {

    @InjectMocks
    private AspiranteService aspiranteService;

    @Mock
    private AspiranteRepository aspiranteRepository;
    @Mock
    private ContactoService contactoService;
    @Mock
    private ProgramaService programaService;
    @Mock
    private UbicacionService ubicacionService;
    @Mock
    private SocioEconomiaService socioEconomiaService;
    @Mock
    private EducacionService educacionService;

    @BeforeEach
    void beforeEach() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void obtenerUnAspiranteDebeArrojarUnErrorCuandoElAspiranteBuscadoNoEstaEnLaLista() {
        // Arrange (organizar)
        List<Aspirante> listaAspirantesMock = new ArrayList<>();
        when(aspiranteRepository.findAll()).thenReturn(listaAspirantesMock);

        // Act (actuar)
        // Llamar al método del servicio
        List<Aspirante> resultado = aspiranteService.obtenerAspirantes();

        // Assert (afirmar)
        // Verificar que el método del repositorio fue llamado exactamente una vez
        verify(aspiranteRepository, times(1)).findAll();

        // Verificar que el resultado del servicio es el mismo que el mock del repositorio
        assertSame(listaAspirantesMock, resultado);

        // Verificar que el resultado del servicio no es nulo
        assertNotNull(resultado);

        // Verificar que el método finAll no se llame más de una vez
        verify(aspiranteRepository, times(1)).findAll();
    }


    @Test
    void obtenerUnAspiranteDebeMostrarLosAspirantesExistentesEnlaListaCuandoSeRealizaLaPeticion() {
        // Arrange (organizar)
        List<Aspirante> listaAspirantesExistentes = Arrays.asList(
                new Aspirante(),
                new Aspirante()
        );

        when(aspiranteRepository.findAll()).thenReturn(listaAspirantesExistentes);

        // Act (actuar)
        List<Aspirante> resultado = aspiranteService.obtenerAspirantes();

        // Assert (afirmar)
        // Verificar que el método del repositorio fue llamado exactamente una vez
        verify(aspiranteRepository, times(1)).findAll();

        // Verificar que el resultado del servicio es el mismo que la lista de aspirantes existentes
        assertEquals(listaAspirantesExistentes, resultado);

        // Verificar que el resultado del servicio no es nulo
        assertNotNull(resultado);

    }

    @Test
    void obtenerAspirantePorIdDebeLanzarExcepcionCuandoElNumeroDeDocumentoNoEstaEnLaLista() {
        // Arrange (organizar)
        String numDocumentoNoExistente = "documentoNoExistente";
        when(aspiranteRepository.findById(numDocumentoNoExistente)).thenReturn(Optional.empty());

        // Act (actuar) y Assert (afirmar)
        assertThrows(RuntimeException.class, () ->
                aspiranteService.obtenerAspiranteById(numDocumentoNoExistente)
        );
    }

    @Test
    void obtenerAspirantePorIdDebeRetornarElAspiranteCuandoExisteEnElRepositorio() {
        // Arrange (organizar)
        String numDocumentoExistente = "documentoExistente";

        Aspirante aspiranteExistente = new Aspirante(); // Crear un objeto Aspirante simulado

        // Configuramos el comportamiento del mock del repositorio para retornar un Optional con el aspirante existente
        when(aspiranteRepository.findById(numDocumentoExistente)).thenReturn(Optional.of(aspiranteExistente));

        // Act (actuar)
        Optional<Aspirante> resultado = aspiranteService.obtenerAspiranteById(numDocumentoExistente);

        // Assert (afirmar)
        // Verificamos que el resultado no sea nulo y sea el mismo que el aspirante existente
        assertNotNull(resultado);
        assertSame(aspiranteExistente, resultado.orElse(null));
    }


    @Test
    void registrarAspiranteDebeLanzarExcepcionCuandoElCorreoYaExiste() {
        // Arrange (organizar)
        Aspirante aspiranteExistente = new Aspirante();

        // Configurar el comportamiento del mock del repositorio para simular un correo existente
        when(aspiranteRepository.findByCorreo(aspiranteExistente.getCorreo())).thenReturn(aspiranteExistente);

        // Act y Assert (actuar y afirmar)
        // Verificar que al intentar registrar un aspirante con un correo existente se lanza una excepción
        assertThrows(RuntimeException.class, () ->
                aspiranteService.registrarAspirante(aspiranteExistente)
        );
    }

    @Test
    void testRegistrarAspiranteDebeRegistrarExitosamenteUnAspiranteCuandoSeProporcionanDatosValidos() {
        // Arrange
        Aspirante aspirante = new Aspirante();
        when(aspiranteRepository.findByCorreo(anyString())).thenReturn(null);

        // Act
        ResponseEntity<String> response = aspiranteService.registrarAspirante(aspirante);

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("Se registró Correctamente", response.getBody());

        // Verifica que los métodos de los servicios fueron llamados
        verify(contactoService, times(1)).guardarContacto(any());
        verify(programaService, times(1)).guardarPrograma(any());
        verify(ubicacionService, times(1)).guardarUbicacion(any());
        verify(educacionService, times(1)).guardarEducacion(any());
        verify(socioEconomiaService, times(1)).guardarSocioeconomia(any());
    }


    @Test
    public void eliminarAspiranteDebeLanzarExcepcionAlEliminarAspiranteInexistente() {
        // Arrange (organizar)
        String numDocumento = "98128743"; // Reemplaza con un documento válido
        when(aspiranteRepository.findById(numDocumento)).thenReturn(Optional.empty());

        // Act y Assert (Actuar y Afirmar)
        DatabaseException excepcion = assertThrows(DatabaseException.class,
                () -> aspiranteService.eliminarAspirante(numDocumento));

        assertEquals("Error al eliminar el aspirante con documento " + numDocumento, excepcion.getMessage());
    }

    @Test
    public void eliminarAspirante_DeberiaEliminarAspiranteExistente() {
        // Arrange (Organizar)
        String numDocumento = "123456789";
        Aspirante aspiranteExistente = new Aspirante();
        when(aspiranteRepository.findById(numDocumento)).thenReturn(Optional.of(aspiranteExistente));

        // Act (Actuar)
        String resultado = aspiranteService.eliminarAspirante(numDocumento);

        // Assert (Afirmar)
        verify(aspiranteRepository).delete(aspiranteExistente); // Verifica que se llamó al método delete con el aspirante existente
        assertEquals("Aspirante Eliminado Correctamente", resultado);
    }
}

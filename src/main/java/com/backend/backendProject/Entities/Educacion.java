package com.backend.backendProject.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.validation.annotation.Validated;

@Data
@Validated
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Educacion {
    @Id
    //JPA genera la clave primaria con la anotación de abajo
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "educacion_id")
    private Long educacionId;

    @NotBlank
    @Column(name = "ultimo_titulo", nullable = false, length = 50)
    private String ultimoTitulo;

    @NotBlank
    @Column(name = "empleo_actual", nullable = false, length = 50)
    private String empleoActual;

    @NotBlank
    @Column(name = "nivel_educativo", nullable = false, length = 50)
    private String nivelEducativo;

    //UN registro de DatosEducativos está asociado a UN Aspirante
    @OneToOne(mappedBy = "datosEducativos", cascade = CascadeType.ALL)
    @JsonIgnore
    private Aspirante aspirante;

}

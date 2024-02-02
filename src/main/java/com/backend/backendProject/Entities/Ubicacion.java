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
public class Ubicacion {
    @Id
    //JPA genera la clave primaria con la anotación de abajo
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ubicacion_id")
    private Long ubicacionId;

    @NotBlank
    @Column(nullable = false, length = 50)
    private String departamento;

    @NotBlank
    @Column(nullable = false, length = 50)
    private String ciudad;

    @NotBlank
    @Column(nullable = false, length = 50)
    private String direccion;

    @OneToOne(mappedBy = "ubicacion", cascade = CascadeType.PERSIST)
    @JsonIgnore
    private Aspirante aspirante;
}

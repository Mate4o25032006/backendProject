package com.backend.backendProject.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Aspirante {
    @Id
    @Column(name = "num_documento", nullable = false, unique = true)
    private String numDocumento;

    @Column(name = "tipo_documento", nullable = false, length = 50)
    private String tipoDocumento;

    @Column(nullable = false, length = 50)
    private String nombre;

    @Column(nullable = false, length = 50)
    private String genero;

    @Column(nullable = false, length = 50)
    private int edad;

    @Column(name = "fecha_nacimiento", columnDefinition = "DATE", nullable = false)
    private LocalDate fechaNacimiento;

    @Column(nullable = false, length = 50)
    private String celular;

    @Column(nullable = false, length = 60)
    private String correo;

    @Column(nullable = false, length = 50)
    private String nacionalidad;

    @Column(name = "bootcamp_info", nullable = false, length = 100)
    private String bootcampInfo;

    @Column(length = 50)
    private String organizacion;

    private int suma;
}

package com.backend.backendProject.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Data
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Aspirante {
    @NotNull
    @Id
    @Column(name = "num_documento", nullable = false, unique = true)
    private String numDocumento;

    @NotNull
    @Column(name = "tipo_documento", nullable = false, length = 50)
    private String tipoDocumento;

    @NotNull
    @Column(nullable = false, length = 50)
    private String nombre;

    @NotNull
    @Column(nullable = false, length = 50)
    private String genero;

    @NotNull
    @Column(nullable = false, length = 50)
    private int edad;

    @NotNull
    @Column(name = "fecha_nacimiento", columnDefinition = "DATE", nullable = false)
    private LocalDate fechaNacimiento;

    @NotNull
    @Column(nullable = false, length = 50)
    private String celular;

    @NotBlank
    @Email
    @Column(nullable = false, length = 60)
    private String correo;

    @NotNull
    @Column(nullable = false, length = 50)
    private String nacionalidad;

    @NotNull
    @Column(name = "bootcamp_info", nullable = false, length = 100)
    private String bootcampInfo;

    @Column(length = 50)
    private String organizacion;

    private int suma;

    //MUCHOS Aspirantes pertenecen a UN Programa
    @ManyToOne(targetEntity = Programa.class)
    private Programa programa;

    //UN Aspirante está asociado a UNA Ubicación
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ubicacion_id")
    private Ubicacion ubicacion;


    //Clave para las demás entidades
    //UN Aspirante está asociado con UN registro de Educación
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "educacion_id")
    private Educacion datosEducativos;

    //UN Aspirante está asociado con UN registro de Contacto Externo
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contacto_id")
    private Contacto datosContactoExterno;

    //UN Aspirante está asociado con UN registro de Socioeconomía
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "socioeconomico_id")
    private SocioEconomia datosSocioeconomia;
}

package com.backend.backendProject.Entities;

import jakarta.persistence.*;
import lombok.*;

@Data
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

    @Column(nullable = false, length = 50)
    private String departamento;

    @Column(nullable = false, length = 50)
    private String ciudad;

    @Column(nullable = false, length = 50)
    private String direccion;

    @OneToOne(mappedBy = "ubicacion", cascade = CascadeType.PERSIST)
    private Aspirante aspirante;
}

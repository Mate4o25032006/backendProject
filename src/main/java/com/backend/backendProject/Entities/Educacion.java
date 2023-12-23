package com.backend.backendProject.Entities;

import jakarta.persistence.*;
import lombok.*;

@Data
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

    @Column(name = "ultimo_titulo", nullable = false, length = 50)
    private String ultimoTitulo;

    @Column(name = "empleo_actual", nullable = false, length = 50)
    private String empleoActual;

    @Column(name = "nivel_educativo", nullable = false, length = 50)
    private String nivelEducativo;

    //UN registro de DatosEducativos está asociado a UN Aspirante
    @OneToOne
    @JoinColumn(name = "num_documento")
    private Aspirante aspirante;
}

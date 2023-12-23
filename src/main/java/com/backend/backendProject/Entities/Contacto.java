package com.backend.backendProject.Entities;

import jakarta.persistence.*;
import lombok.*;

@Data
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Contacto {
    @Id
    //JPA genera la clave primaria con la anotación de abajo
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contacto_id")
    private Long contactoId;

    @Column(nullable = false, length = 50)
    private String nombre;

    @Column(nullable = false, length = 50)
    private String telefono;

    @Column(nullable = false, length = 50)
    private String correo;

    //UN registro de DatosContactoExterno está asociado a UN Aspirante
    @OneToOne
    @JoinColumn(name = "num_documento")
    private Aspirante aspirante;
}

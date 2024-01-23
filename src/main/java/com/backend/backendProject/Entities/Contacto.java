package com.backend.backendProject.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.validation.annotation.Validated;

@Data
@Validated
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

    @NotBlank
    @Column(nullable = false, length = 50)
    private String nombre;

    @NotBlank
    @Column(nullable = false, length = 50)
    private String telefono;

    @NotBlank
    @Email
    @Column(nullable = false, length = 50)
    private String correo;

    //UN registro de DatosContactoExterno está asociado a UN Aspirante
    @OneToOne(mappedBy = "datosContactoExterno", cascade = CascadeType.ALL)
    @JsonIgnore
    private Aspirante aspirante;
}

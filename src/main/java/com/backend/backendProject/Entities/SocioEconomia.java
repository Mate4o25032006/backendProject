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
public class SocioEconomia {
    @Id
    //JPA genera la clave primaria con la anotación de abajo
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "socioeconomico_id")
    private Long socioeconomicoId;

    @NonNull
    @Column(nullable = false, length = 10)
    private int estrato;

    @NotBlank
    @Column(nullable = false, length = 50)
    private String etnia;

    @NotBlank
    @Column(nullable = false, length = 50)
    private String discapacidad;

    @NotBlank
    @Column(nullable = false, length = 50)
    private String poblacion;

    @NonNull
    @Column(nullable = false, length = 50)
    private int salario;

    @NotBlank
    @Column(nullable = false, length = 50)
    private String ocupacion;

    //UN registro de SocioEconomia está asociado a UN Aspirante
    @OneToOne(mappedBy = "datosSocioeconomia",   cascade = CascadeType.ALL)
    @JsonIgnore
    private Aspirante aspirante;
}

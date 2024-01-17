package com.backend.backendProject.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Data
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

    @Column(nullable = false, length = 10)
    private int estrato;

    @Column(nullable = false, length = 50)
    private String etnia;

    @Column(nullable = false, length = 50)
    private String discapacidad;

    @Column(nullable = false, length = 50)
    private String poblacion;

    @Column(nullable = false, length = 50)
    private int salario;

    @Column(nullable = false, length = 50)
    private String ocupacion;

    //UN registro de SocioEconomia está asociado a UN Aspirante
    @OneToOne(mappedBy = "datosSocioeconomia",   cascade = CascadeType.ALL)
    @JsonIgnore
    private Aspirante aspirante;
}

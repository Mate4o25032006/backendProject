package com.backend.backendProject.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Data
@Validated
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Programa {
    @Id
    //JPA genera la clave primaria con la anotación de abajo
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "programa_id")
    private Long programaId;

    @NotBlank
    @Column(nullable = false, length = 50)
    private String nombre;

    //UN Programa puede tener MUCHOS Aspirantes
    @OneToMany(targetEntity = Aspirante.class, fetch = FetchType.LAZY, mappedBy = "programa")
    @JsonIgnore
    private List<Aspirante> aspirantes;
}

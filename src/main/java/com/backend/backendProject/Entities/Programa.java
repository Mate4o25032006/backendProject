package com.backend.backendProject.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
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

    @Column(nullable = false, length = 50)
    private String nombre;

    //UN Programa puede tener MUCHOS Aspirantes
    @OneToMany(targetEntity = Aspirante.class, fetch = FetchType.LAZY, mappedBy = "programa")
    @JsonIgnore
    private List<Aspirante> aspirantes;
}

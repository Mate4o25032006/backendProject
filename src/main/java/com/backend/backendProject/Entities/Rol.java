package com.backend.backendProject.Entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "roles")
@Entity
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String nombre;

    //UN Rol puede pertenecer a varios USUARIOS
    @OneToMany(targetEntity = Usuario.class, fetch = FetchType.LAZY, mappedBy = "rol")
    @JsonIgnore
    private List<Usuario> usuarios;
}


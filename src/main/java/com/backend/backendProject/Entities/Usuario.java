package com.backend.backendProject.Entities;

import jakarta.persistence.*;
import lombok.*;

@Data
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "usuarios")
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String email;

    @Column(nullable = false, length = 60)
    private String contrasenia;

    //VARIOS usuarios poseen UN Rol
    @ManyToOne(targetEntity = Rol.class)
    private Rol rol;
}

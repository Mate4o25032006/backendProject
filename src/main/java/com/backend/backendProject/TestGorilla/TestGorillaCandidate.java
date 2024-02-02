package com.backend.backendProject.TestGorilla;

import lombok.Data;

import java.time.LocalDateTime;
import lombok.*;

//Recuperar Datos del Candidato
@Data
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class TestGorillaCandidate {
    private int avg_score;
    private LocalDateTime created;
    private String email;
    private String full_name;
    private int id;
    private String invitation_uuid;
    private boolean is_hired;
    private String personality_algorithm;
    private String personality;
    private Integer rating;
    private String review;
    private String stage;
    private String status;
    private int testtaker_id;
    private String invitation_link;
}

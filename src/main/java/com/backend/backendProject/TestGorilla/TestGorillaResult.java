package com.backend.backendProject.TestGorilla;

import lombok.*;

import java.util.List;

//Respuesta de TestGorilla
@Data
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class TestGorillaResult {
    private Long id;
    private String name;
    private Integer score;
    private String status;
    private Boolean completed;
    private Long testId;
    private List<String> customQuestions;
    private String algorithm;
    private Boolean isCodeTest;
    private String scoreDisplay;
}

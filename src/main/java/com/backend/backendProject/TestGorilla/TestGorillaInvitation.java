package com.backend.backendProject.TestGorilla;

import lombok.*;

import java.time.LocalDateTime;

//Invitación para la reali zación del Test
@Data
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class TestGorillaInvitation {
    private Long id;
    private Long assessment;
    private String email;
    private String invitation_uuid;
    private LocalDateTime created;
    private int testtaker_id;
    private String status;
}

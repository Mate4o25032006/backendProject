package com.backend.backendProject.TestGorilla;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class TestGorillaService {
    private final RestTemplate restTemplate;

    @Autowired
    public TestGorillaService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    //Método para enviar la invitación
    public TestGorillaInvitation enviarInvitacion(String correo) {
        String token = "ABN981loUJA09pabTRE";

        //Se crea el cuerpo de la solicitud con el correo del aspirante (Clave valor)
        Map<String, String> body = new HashMap<>();
        body.put("email", correo);

        //Se crea el encabezado de la solicitud
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Token " + token);
        headers.add("content-type", "application/json");

        //Se crea el objeto de entidad
        HttpEntity<Map<String, String>> entity = new HttpEntity<>(body, headers);

        //Se realiza el llamado POST a la API
        return restTemplate.postForObject(
                "https://app.testgorilla.com/api/assessments/<ASSESSMENT_ID>/invite_candidate/",
                entity,
                TestGorillaInvitation.class);
    }


    //Método para obtener el listado de Aspirantes Invitados a realizar la evaluación
    public List<TestGorillaCandidate> obtenerCandidatosInvitados() {
        String token = "ABN981loUJA09pabTRE";

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Token " + token);
        headers.add("content-type", "application/json");

        HttpEntity<String> entity = new HttpEntity<>(headers);

        TestGorillaCandidate[] candidates = restTemplate.getForObject(
                "https://app.testgorilla.com/api/assessments/candidature?assessment=<ASSESSMENT_ID>",
                TestGorillaCandidate[].class,
                entity
        );

        assert candidates != null;
        return Arrays.asList(candidates);
    }


    //Método para obtener evaluación de un candidato en específico
    public List<TestGorillaResult> obtenerResultadosEvaluacion(String testTakerId) {
        String token = "ABN981loUJA09pabTRE";
        String url = "https://app.testgorilla.com/api/assessments/results/?candidature__assessment=<ASSESSMENT_ID>&candidature__test_taker=" + testTakerId;

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Token " + token);

        HttpEntity<String> entity = new HttpEntity<>(headers);

        TestGorillaResult [] resultsArray = restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                TestGorillaResult [].class
        ).getBody();

        if (resultsArray != null) {
            return Arrays.asList(resultsArray);
        } else {
            return Collections.emptyList();
        }
    }

}

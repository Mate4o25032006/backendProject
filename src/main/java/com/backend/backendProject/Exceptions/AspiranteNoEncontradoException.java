package com.backend.backendProject.Exceptions;

import org.springframework.http.HttpStatus;

public class AspiranteNoEncontradoException extends RuntimeException {
    public AspiranteNoEncontradoException(String message) {
        super(message);
    }
}

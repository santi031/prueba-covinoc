package com.covinoc.prueba.controllers;

import com.covinoc.prueba.exceptions.GlobalExceptionHandler;
import com.covinoc.prueba.models.Error;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {

    /**
     * Metodo para manejar las excepciones que surgan en los metodos de los servicios
     * */
    @ExceptionHandler(value = GlobalExceptionHandler.class)
    public ResponseEntity<Error> requestExceptionHandler(GlobalExceptionHandler e) {
        Error error = Error.builder().code(e.getCode()).message(e.getMessage()).build();
        return new ResponseEntity<>(error, e.getStatus());
    }
}

package com.covinoc.prueba.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class GlobalExceptionHandler extends RuntimeException{

    private String code;
    private HttpStatus status;

    public GlobalExceptionHandler(String code, HttpStatus status, String message) {
        super(message);
        this.code = code;
        this.status = status;
    }
}

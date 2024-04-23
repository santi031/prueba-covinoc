package com.covinoc.prueba.utils;

import org.springframework.http.HttpStatus;

import java.util.HashMap;

public class Utils {

    /**
     * Metodo para gestionar la respuesta del servicio
     * */
    public HashMap<String, Object> manageResponse(HttpStatus httpStatus, Object obj, String message) {
        HashMap<String, Object> data = new HashMap<>();
        data.put("code", httpStatus);
        data.put("data", obj);
        data.put("message", message);
        return data;
    }
}

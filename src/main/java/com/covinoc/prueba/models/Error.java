package com.covinoc.prueba.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Error {
    String code;
    String message;
}

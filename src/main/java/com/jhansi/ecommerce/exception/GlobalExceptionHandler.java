package com.jhansi.ecommerce.exception;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public Map<String, String> handleRuntimeException(
            RuntimeException ex) {

        Map<String, String> error =
                new HashMap<>();

        error.put("message",
                ex.getMessage());

        return error;
    }
    @ExceptionHandler(Exception.class)
    public Map<String, String> handleException(
            Exception ex) {

        Map<String, String> error =
                new HashMap<>();

        error.put("message",
                ex.getMessage());

        return error;
    }
}

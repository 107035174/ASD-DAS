package edu.miu.cs489.dentalappointment.advice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class NotFoundExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> handleNotFoundException(Exception notFoundException) {
        Map<String, String> errorMessageMap = new HashMap<>();
        errorMessageMap.put("errorMessage", notFoundException.getMessage());
        return errorMessageMap;
    }
}

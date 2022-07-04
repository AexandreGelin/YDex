package com.j2ee.sorties.controllers;

import com.j2ee.sorties.dto.ValidationError;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice(annotations = RestController.class)
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers, HttpStatus status, WebRequest request) {
        Map<String, String> fieldErrors = new HashMap<String, String>();
        List<FieldError> listErrors = ex.getBindingResult().getFieldErrors();
        String errMessage = new String();
        for(FieldError error : listErrors){
            fieldErrors.put(error.getField(), error.getCode());
            errMessage = error.getDefaultMessage();

        }
        ValidationError error = new ValidationError(errMessage, fieldErrors );
        return new ResponseEntity<>(error, status);
    }

}

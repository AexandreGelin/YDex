package com.j2ee.sorties.dto;

import org.springframework.context.annotation.Bean;

import java.util.Map;


public class ValidationError {

    private String errorMessage;

    private Map<String, String> fieldErrors;

    public ValidationError(String errorMessage, Map<String, String> fieldErrors) {
        this.errorMessage = errorMessage;
        this.fieldErrors = fieldErrors;
    }

    public ValidationError() {
    }

    public String getErrorMessage() { return errorMessage; }

    public void setErrorMessage(String errorMessage) { this.errorMessage = errorMessage; }

    public Map<String, String> getFieldErrors() { return fieldErrors; }

    public void setFieldErrors(Map<String, String> fieldErrors) { this.fieldErrors = fieldErrors; }
}

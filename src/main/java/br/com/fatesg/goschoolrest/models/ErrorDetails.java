package br.com.fatesg.goschoolrest.models;

import lombok.Data;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.Map;

@Data
public class ErrorDetails {

    private String messageError;
    private Map<String, String> fieldError;

    public ErrorDetails(BindingResult bindingResult) {
        this.loadFieldError(bindingResult);
    }

    public ErrorDetails(String messageError) {
        this.messageError = messageError;
    }

    private void loadFieldError(BindingResult bindingResult) {
        this.fieldError = new HashMap<>();
        for (FieldError field : bindingResult.getFieldErrors()) {
            this.fieldError.put(field.getField(), field.getDefaultMessage());
        }
    }

}
package br.com.fatesg.goschoolrest.models;

import lombok.Data;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@MappedSuperclass
public abstract class Person extends DefaultModel {

    @NotNull(message = "Required field")
    @Size(max = 250, message = "Maximum size is 250 characters")
    private String fullName;
    @Size(max = 100, message = "Maximum size is 100 characters")
    private String street;
    @Size(max = 100, message = "Maximum size is 100 characters")
    private String neighborhood;
    @Size(max = 50, message = "Maximum size is 50 characters")
    private String city;
    private String state;
    @NotNull(message = "Required field")
    private String postalCode;

}

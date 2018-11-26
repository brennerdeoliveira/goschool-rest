package br.com.fatesg.goschoolrest.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Entity
public class Student extends NaturalPerson {

    @NotNull(message = "Required field")
    @Size(max = 50, message = "Maximum size is 50 characters")
    private String enrollment;
    private String latitude;
    private String longitude;

}

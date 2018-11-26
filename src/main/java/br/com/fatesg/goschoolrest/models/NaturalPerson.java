package br.com.fatesg.goschoolrest.models;

import lombok.Data;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@MappedSuperclass
public class NaturalPerson extends Person {

    @NotNull(message = "Required field")
    private String socialSecurityNumber;
    @NotNull(message = "Required field")
    private String nationalIdentityCard;
    @NotNull(message = "Required field")
    private LocalDate dateBirth;

}

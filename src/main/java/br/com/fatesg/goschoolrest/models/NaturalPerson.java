package br.com.fatesg.goschoolrest.models;

import lombok.Data;

import javax.persistence.MappedSuperclass;
import java.time.LocalDate;

@Data
@MappedSuperclass
public class NaturalPerson extends Person {

    private String socialSecurityNumber;
    private String nationalIdentityCard;
    private LocalDate dateBirth;
}

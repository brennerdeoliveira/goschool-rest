package br.com.fatesg.goschoolrest.models;

import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class Student extends NaturalPerson {

    private String enrollment;
    private String latitude;
    private String longitude;
}

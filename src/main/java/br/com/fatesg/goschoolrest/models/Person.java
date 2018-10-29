package br.com.fatesg.goschoolrest.models;

import lombok.Data;

import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
public abstract class Person extends DefaultModel {

    private String fullName;
    private String street;
    private String neighborhood;
    private String city;
    private String state;

}

package br.com.fatesg.goschoolrest.models;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
public class DefaultModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

}

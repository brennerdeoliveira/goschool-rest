package br.com.fatesg.goschoolrest.models;

import lombok.Data;

import javax.persistence.*;

@Data
@MappedSuperclass
public class DefaultModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

}

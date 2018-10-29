package br.com.fatesg.goschoolrest.interfaces;

import java.util.List;

public interface GenericOperations<E> {

    E post(E entity);
    List<E> get();
    void put(E entity);
    void delete(E entity);

}

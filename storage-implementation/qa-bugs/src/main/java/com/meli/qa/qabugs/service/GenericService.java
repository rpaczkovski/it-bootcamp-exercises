package com.meli.qa.qabugs.service;

import java.util.List;

public interface GenericService<U extends Number, T>{
    T save(T entity);
    T findById(U id);
    List<T> findAll();
    T update(U id, T entity);
    void delete(U id);
}

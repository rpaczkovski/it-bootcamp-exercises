package com.meli.movies.service;
import java.util.List;

public interface MainService<U extends Number, T> {
    T create(T entity);
    T findById(U id);
    List<T> findAll();
    T update(U id, T entity);
    void delete(U id);
}

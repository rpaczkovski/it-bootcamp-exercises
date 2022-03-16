package application.repositories.intefaces;

import java.util.List;

public interface IRepository<U, T> {
    T create(T obj);
    T findById(U id);
    void deleteById(U id);
    List<T> findAll();
}

package ru.endrysan.java.library_app.dao;

import java.util.List;

import ru.endrysan.java.library_app.model.Entity;

public interface GenericDAO<T extends Entity> {

    void save(T entity);
    
    void delete(T entity);
    
    void change(T entity);
    
    T getById(int id);
    
    List<T> getAll();
}

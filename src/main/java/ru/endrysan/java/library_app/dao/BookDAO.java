package ru.endrysan.java.library_app.dao;

import java.io.File;
import java.io.IOException;
import java.util.List;

import ru.endrysan.java.library_app.model.Book;

public class BookDAO implements GenericDAO<Book> {

    @Override
    public void save(Book entity) {
        
    }

    @Override
    public void delete(Book entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void change(Book entity) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Book get() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Book> getAll() {
        // TODO Auto-generated method stub
        return null;
    }

}

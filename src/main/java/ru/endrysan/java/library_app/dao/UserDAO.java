package ru.endrysan.java.library_app.dao;

import java.util.List;

import ru.endrysan.java.library_app.model.User;

public class UserDAO implements GenericDAO<User> {

    @Override
    public void save(User entity) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void delete(User entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void change(User entity) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public User get() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<User> getAll() {
        // TODO Auto-generated method stub
        return null;
    }

}

package ru.endrysan.java.library_app.services;

import java.util.List;

import ru.endrysan.java.library_app.dao.Cache;
import ru.endrysan.java.library_app.dao.CardDAO;
import ru.endrysan.java.library_app.dao.UserDAO;
import ru.endrysan.java.library_app.model.User;

public class UserService {
    
    private static UserService instance;
    private static boolean useCache;
    private Cache cache;
    private UserDAO userDAO;
    
    private UserService() {
        
    }
    
    private UserService(boolean useCache) {
        this.useCache = useCache;
        cache = Cache.getInstance();
        userDAO = UserDAO.getInstance();
    }
    
    public static UserService getInstance(boolean useCache) {
        if (instance == null) {
            instance = new UserService(useCache);
        }
        return instance;
    }
    
    public static UserService getInstance() {
        if (instance == null) {
            instance = new UserService();
        }
        return instance;
    }
    public void save(User user) {
        if (useCache) {
            cache.addUser(user);
        }
        else {
            userDAO.save(user);
        }
    }
    public List<User> getAll() {
        if (useCache) {
            return cache.getAllUser();
        }
        else {
            return userDAO.getAll();
        }
    }

}

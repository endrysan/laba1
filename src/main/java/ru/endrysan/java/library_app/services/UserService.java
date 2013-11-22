package ru.endrysan.java.library_app.services;

import java.util.List;

import ru.endrysan.java.library_app.dao.Cache;
import ru.endrysan.java.library_app.dao.UserDAO;
import ru.endrysan.java.library_app.model.User;

public class UserService {
    private boolean useCache;
    private Cache cache;
    private UserDAO userDAO;
    public UserService(boolean useCache) {
        this.useCache = useCache;
        cache = Cache.getInstance();
        userDAO = new UserDAO();
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

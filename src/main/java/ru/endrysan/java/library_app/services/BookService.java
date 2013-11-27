package ru.endrysan.java.library_app.services;

import java.util.List;

import ru.endrysan.java.library_app.dao.BookDAO;
import ru.endrysan.java.library_app.dao.Cache;
import ru.endrysan.java.library_app.dao.CardDAO;
import ru.endrysan.java.library_app.model.Book;

public class BookService {
    
    private static BookService instance;
    private static boolean useCache;
    private Cache cache;
    private BookDAO bookDAO;
    
    private BookService() {
        
    }
    
    private BookService(boolean useCache) {
        this.useCache = useCache;
        cache = Cache.getInstance();
        bookDAO = BookDAO.getInstance();
    }
    
    public static BookService getInstance(boolean useCache) {
        if (instance == null) {
            instance = new BookService(useCache);
        }
        return instance;
    }
    
    public static BookService getInstance() {
        if (instance == null) {
            instance = new BookService();
        }
        return instance;
    }
    
    public void save(Book book) {
        if (useCache) {
            cache.addBook(book);
        }
        else {
            bookDAO.save(book);
        }
    }
    
    public List<Book> getAll() {
        if (useCache) {
            return cache.getAllBook();
        }
        else {
            return bookDAO.getAll();
        }
    }

}

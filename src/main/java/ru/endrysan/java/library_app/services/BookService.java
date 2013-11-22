package ru.endrysan.java.library_app.services;

import java.util.List;

import ru.endrysan.java.library_app.dao.BookDAO;
import ru.endrysan.java.library_app.dao.Cache;
import ru.endrysan.java.library_app.model.Book;

public class BookService {
    private boolean useCache;
    private Cache cache;
    private BookDAO bookDAO;
    
    public BookService(boolean useCache){
        this.useCache = useCache;
        cache = Cache.getInstance();
        bookDAO = new BookDAO();
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

package ru.endrysan.java.library_app.dao;

import java.util.ArrayList;
import java.util.List;

import ru.endrysan.java.library_app.model.Book;
import ru.endrysan.java.library_app.model.Card;
import ru.endrysan.java.library_app.model.User;

public class Cache {
    
    private Cache() {
        
    }
    
    private static Cache instance;
    
    private List<User> listUser = new ArrayList<User>();
    private List<Book> listBook = new ArrayList<Book>();
    private List<Card> listCard = new ArrayList<Card>();
    
    public static Cache getInstance() {
        if (instance == null) {
            instance = new Cache();
        }
        return instance;
    }
    
    public void addUser(User user) {
        listUser.add(user);
    }
    public List<User> getAllUser() {
        return listUser;
    }

    public void addBook(Book book) {
        listBook.add(book);
    }
    public List<Book> getAllBook() {
        return listBook;
    }

    public void addCard(Card card) {
        listCard.add(card);
    }
    public List<Card> gettAllCard() {
        return listCard;
    }

}

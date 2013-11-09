package ru.endrysan.java.library_app.dao;

import java.util.List;

import ru.endrysan.java.library_app.model.Card;

public class CardDAO implements GenericDAO<Card> {

    @Override
    public void save(Card entity) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void delete(Card entity) {
        throw new UnsupportedOperationException("Card can't be deleted");
    }

    @Override
    public void change(Card entity) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Card get() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Card> getAll() {
        // TODO Auto-generated method stub
        return null;
    }

    
}

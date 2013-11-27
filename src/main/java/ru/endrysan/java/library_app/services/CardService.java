package ru.endrysan.java.library_app.services;

import java.util.List;

import ru.endrysan.java.library_app.dao.Cache;
import ru.endrysan.java.library_app.dao.CardDAO;
import ru.endrysan.java.library_app.model.Card;

public class CardService {
    
    private static CardService instance;
    private static boolean useCache;
    private Cache cache;
    private CardDAO cardDAO;
    
    private CardService() {
        
    }
    
    private CardService(boolean useCache) {
        this.useCache = useCache;
        cache = Cache.getInstance();
        cardDAO = CardDAO.getInstance();
    }
    
    public static CardService getInstance(boolean useCache) {
        if (instance == null) {
            instance = new CardService(useCache);
        }
        return instance;
    }
    
    public static CardService getInstance() {
        if (instance == null) {
            instance = new CardService();
        }
        return instance;
    }
    public void save(Card card) {
        if (useCache) {
            cache.addCard(card);
        }
        else {
            cardDAO.save(card);
        }
    }
    public List<Card> getAll() {
        if (useCache) {
            return cache.gettAllCard();
        }
        else {
            return cardDAO.getAll();
        }
    }

}

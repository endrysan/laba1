package ru.endrysan.java.library_app.services;

import java.util.List;

import ru.endrysan.java.library_app.dao.Cache;
import ru.endrysan.java.library_app.dao.CardDAO;
import ru.endrysan.java.library_app.model.Card;

public class CardService {
    private boolean useCache;
    private Cache cache;
    private CardDAO cardDAO;
    public CardService(boolean useCache) {
        this.useCache = useCache;
        cache = Cache.getInstance();
        cardDAO = new CardDAO();
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

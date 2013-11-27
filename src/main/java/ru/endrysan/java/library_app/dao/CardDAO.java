package ru.endrysan.java.library_app.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

import ru.endrysan.java.library_app.model.Card;
import ru.endrysan.java.library_app.model.Card.Status;

public class CardDAO implements GenericDAO<Card> {

    private UserDAO user = UserDAO.getInstance();
    private BookDAO book = BookDAO.getInstance(); 
    private File file;
    private static String filename;
    private static CardDAO instance;
    
    private CardDAO() {
    }
    
    private CardDAO(String filename) {
        this.filename = filename;
        file = new File(filename);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    public static CardDAO getInstance() {
        if (instance == null) {
            instance = new CardDAO();
        }
        return instance;
    }
    
    public static CardDAO getInstance(String filename) {
        if (instance == null) {
            instance = new CardDAO(filename);
        }
        return instance;
    }
    
    @Override
    public void save(Card card) {
        int lastCardId = 0;
        List<Card> cards = new ArrayList<Card>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            
            for (String s = reader.readLine(); s != null; s = reader.readLine()) {
                Card newCard = new Card();
                int cardId = Integer.parseInt(s);
                if (cardId > lastCardId) {
                    lastCardId = cardId;
                }
                newCard.setID(cardId);
                newCard.setUser(user.getById(cardId));
                newCard.setBook(book.getById(cardId));
                newCard.setStatus(Status.valueOf(reader.readLine()));
                newCard.setStartDate(Integer.parseInt(reader.readLine()));
                newCard.setEndDate(Integer.parseInt(reader.readLine()));
                cards.add(newCard);
            }
            card.setID(lastCardId + 1);
            cards.add(card);
            reader.close();
            
            FileWriter writer = new FileWriter(file);
            for (Card c : cards) {
                writer.write(c.getID() + "\n");
                writer.write(c.getUser() + "\n");
                writer.write(c.getBook() + "\n");
                writer.write(c.getStatus() + "\n");
                writer.write(c.getStartDate() + "\n");
                writer.write(c.getEndDate() + "\n");
            }
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
    public Card getById(int id) {
        List<Card> listCard = new ArrayList<Card>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            
            for (String s = reader.readLine(); s != null; s = reader.readLine()) {
                Card newCard = new Card();
                int cardId = Integer.parseInt(s);
                newCard.setID(cardId);
                newCard.setUser(user.getById(cardId));
                newCard.setBook(book.getById(cardId));
                newCard.setStatus(Status.valueOf(reader.readLine()));
                newCard.setStartDate(Integer.parseInt(reader.readLine()));
                newCard.setEndDate(Integer.parseInt(reader.readLine()));
                listCard.add(newCard);
            }
            reader.close();
            
            for (Card u: listCard) {
                if (id == u.getID()) {
                    return u;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Card> getAll() {
        List<Card> listCard = new ArrayList<Card>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            
            for (String s = reader.readLine(); s != null; s = reader.readLine()) {
                Card newCard = new Card();
                int cardId = Integer.parseInt(s);
                newCard.setID(cardId);
                newCard.setUser(user.getById(cardId));
                newCard.setBook(book.getById(cardId));
                newCard.setStatus(Status.valueOf(reader.readLine()));
                newCard.setStartDate(Integer.parseInt(reader.readLine()));
                newCard.setEndDate(Integer.parseInt(reader.readLine()));
                listCard.add(newCard);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listCard;
    }

}

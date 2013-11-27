package ru.endrysan.java.library_app;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

import ru.endrysan.java.library_app.dao.BookDAO;
import ru.endrysan.java.library_app.dao.CardDAO;
import ru.endrysan.java.library_app.dao.ReadXml;
import ru.endrysan.java.library_app.dao.UserDAO;
import ru.endrysan.java.library_app.services.BookService;
import ru.endrysan.java.library_app.services.CardService;
import ru.endrysan.java.library_app.services.UserService;

public class Configuration {
    
    private String filenameUsers;
    private String filenameBooks;
    private String filenameCards;
    private boolean useCache;
    
    public Configuration() {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse("location.xml");
            
            useCache = ReadXml.returnCache(doc.getFirstChild());
            
            UserService.getInstance(useCache);
            BookService.getInstance(useCache);
            CardService.getInstance(useCache);
            
            filenameUsers = ReadXml.returnLocation("users", doc.getFirstChild());
            filenameBooks = ReadXml.returnLocation("books", doc.getFirstChild());
            filenameCards = ReadXml.returnLocation("cards", doc.getFirstChild());
            
            UserDAO.getInstance(filenameUsers);
            BookDAO.getInstance(filenameBooks);
            CardDAO.getInstance(filenameCards);
            
        } catch(Exception e) {
            
        }
    }
    

}

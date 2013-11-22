package ru.endrysan.java.library_app.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import ru.endrysan.java.library_app.dao.BookDAO;
import ru.endrysan.java.library_app.model.Book;
import ru.endrysan.java.library_app.model.Book.Genre;
import ru.endrysan.java.library_app.services.BookService;
import ru.endrysan.java.library_app.view.CreateBookView;

public class CreateBookController implements ActionListener {
    
    private CreateBookView parentCreateBookView;
    
    public CreateBookController(CreateBookView parentCreateBookView) {
        this.parentCreateBookView = parentCreateBookView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == parentCreateBookView.buttonAddBook) {
            onAddBook(e);
        }
        if(e.getSource() == parentCreateBookView.buttonCancel) {
            parentCreateBookView.setVisible(false);
            parentCreateBookView.dispose();
        }
        
    }

    private void onAddBook(ActionEvent e) {
        Book newBook = new Book();
        BookService bookService = new BookService(true);
        List<Book> listBook = new ArrayList<Book>();
        
        listBook.addAll(bookService.getAll());
        
        for (Book b : listBook) {
            if ("".equals(parentCreateBookView.fieldAuthor) || "".equals(parentCreateBookView.fieldTitle) || 
                    "".equals(parentCreateBookView.fieldPublication) || "".equals(parentCreateBookView.fieldPages) ||
                    "".equals(parentCreateBookView.fieldGenre)) {
                parentCreateBookView.labelNotification.setText("input all fields");
            }
            else {
                newBook.setAuthor(parentCreateBookView.fieldAuthor.getText());
                newBook.setTitle(parentCreateBookView.fieldTitle.getText());
                newBook.setPublication(Integer.parseInt(parentCreateBookView.fieldPublication.getText()));
                newBook.setPages(Integer.parseInt(parentCreateBookView.fieldPages.getText()));
                newBook.setGenre(Genre.valueOf(parentCreateBookView.fieldGenre.getText()));
                bookService.save(newBook);
                parentCreateBookView.setVisible(false);
            }
        }
        
    }
    
}

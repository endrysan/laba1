package ru.endrysan.java.library_app.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import ru.endrysan.java.library_app.dao.BookDAO;
import ru.endrysan.java.library_app.model.Book;
import ru.endrysan.java.library_app.model.Book.Genre;
import ru.endrysan.java.library_app.view.CreateBookView;

public class CreateBookController implements ActionListener {
    
    CreateBookView parentCreateBookView;
    
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
        BookDAO book = new BookDAO();
        List<Book> listBook = new ArrayList<Book>();
        
        listBook.addAll(book.getAll());
        
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
                book.save(newBook);
                parentCreateBookView.setVisible(false);
            }
        }
        
    }
    
}

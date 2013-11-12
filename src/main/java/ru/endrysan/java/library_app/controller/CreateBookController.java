package ru.endrysan.java.library_app.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        
    }
    
}

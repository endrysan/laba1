package ru.endrysan.java.library_app.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ru.endrysan.java.library_app.view.CreateBookView;
import ru.endrysan.java.library_app.view.CreateUserView;
import ru.endrysan.java.library_app.view.MainView;
import ru.endrysan.java.library_app.view.ViewBook;
import ru.endrysan.java.library_app.view.ViewUser;

public class MainController implements ActionListener {
    MainView parentMainView;
    
    public MainController(MainView parentMainView) {
        this.parentMainView = parentMainView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == parentMainView.buttonViewUser) {
            new ViewUser();
        }
        if(e.getSource() == parentMainView.buttonViewBook) {
            new ViewBook();
        }
        if (e.getSource() == parentMainView.buttonCreateUser) {
            new CreateUserView();
        }
        if (e.getSource() == parentMainView.buttonCreateBook) {
            new CreateBookView();
        }
    }

}

package ru.endrysan.java.library_app.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ru.endrysan.java.library_app.view.CreateUserView;

public class CreateUserController implements ActionListener {

    CreateUserView parentCreateUserView;
    
    public CreateUserController(CreateUserView parentCreateUserView) {
        this.parentCreateUserView = parentCreateUserView;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == parentCreateUserView.buttonAddUser) {
            onAddUser(e);
        }
        if (e.getSource() == parentCreateUserView.buttonCancel) {
            parentCreateUserView.setVisible(false);
            parentCreateUserView.dispose();
        }
    }

    private void onAddUser(ActionEvent e) {
        
    }

}

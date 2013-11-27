package ru.endrysan.java.library_app.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import ru.endrysan.java.library_app.model.User;
import ru.endrysan.java.library_app.dao.UserDAO;
import ru.endrysan.java.library_app.services.UserService;
import ru.endrysan.java.library_app.view.CreateUserView;

public class CreateUserController implements ActionListener {

    public CreateUserView parentCreateUserView;
    
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
        String displayFieldTextFirstName = parentCreateUserView.fieldFirstName.getText();
        String displayFieldTextLastName = parentCreateUserView.fieldLastName.getText();
        boolean displayFieldTextActivity = Boolean.parseBoolean(parentCreateUserView.fieldActivity.getText());
        
        User newUser = new User();
        UserService userService = UserService.getInstance();
        List<User> listUser = new ArrayList<User>();
        
        listUser.addAll(userService.getAll());
        
        for (User u : listUser) {
            if ("".equals(displayFieldTextFirstName) || "".equals(displayFieldTextFirstName) || 
                "".equals(displayFieldTextActivity)) {
                parentCreateUserView.labelNotification.setText("input all fields");
                break;
            }
            if (displayFieldTextFirstName.equals(u.getFirstName()) && 
                displayFieldTextLastName.equals(u.getLastName())) {
                parentCreateUserView.labelNotification.setText("user is logged");
            }
            else {
                newUser.setFirstName(displayFieldTextFirstName);
                newUser.setLastName(displayFieldTextLastName);
                newUser.setActive(displayFieldTextActivity);
                userService.save(newUser);
                parentCreateUserView.setVisible(false);
            }
            
        }
    }

}

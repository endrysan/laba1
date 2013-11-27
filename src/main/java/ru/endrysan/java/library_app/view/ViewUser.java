package ru.endrysan.java.library_app.view;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;

import ru.endrysan.java.library_app.controller.ViewUserController;
import ru.endrysan.java.library_app.dao.UserDAO;
import ru.endrysan.java.library_app.model.User;

public class ViewUser extends JFrame implements View {

    public ViewUser() {
        
        super("View User");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        List<User> users = new ArrayList<User>();
        UserDAO userDAO = UserDAO.getInstance();
        users.addAll(userDAO.getAll());
        
        TableModel model = new ViewUserController(users);
        JTable table = new JTable(model);
 
        getContentPane().add(new JScrollPane(table));
 
        setPreferredSize(new Dimension(260, 220));
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
 
}

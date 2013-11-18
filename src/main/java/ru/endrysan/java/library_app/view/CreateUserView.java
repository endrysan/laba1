package ru.endrysan.java.library_app.view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ru.endrysan.java.library_app.controller.CreateUserController;

public class CreateUserView extends JFrame implements View {

    public JButton buttonAddUser;
    public JButton buttonCancel;
    public JTextField fieldFirstName;
    public JTextField fieldLastName;
    public JLabel labelNotification;
    
    public CreateUserView() {
        super("Create User");
        setPreferredSize(new Dimension(300, 180));
        setResizable(false);
        
        setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        
        JPanel panelFrame = new JPanel(new GridLayout(2, 2, 5, 10));
        
        panelFrame.add(new JLabel("First name"));
        panelFrame.add(fieldLastName = new JTextField(10));
        panelFrame.add(new JLabel("Last name"));
        panelFrame.add(fieldLastName = new JTextField(10));
        
        JPanel panelNotification = new JPanel();
        panelNotification.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 0));
        labelNotification = new JLabel("123413241234");
        panelNotification.add(labelNotification);
        
        buttonAddUser = new JButton("add");
        buttonCancel = new JButton("cancel");
        JPanel panelButton = new JPanel();
        panelButton.add(buttonAddUser);
        panelButton.add(buttonCancel);
        
        add(panelFrame);
        add(panelNotification);
        add(panelButton);
        
        CreateUserController userController = new CreateUserController(this);
        buttonAddUser.addActionListener(userController);
        buttonCancel.addActionListener(userController);
        
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        
    }
    @Override
    public void layoutYouself() {
        
    }
    
    public static void main(String[] args) {
        new CreateUserView();
    }

}

package ru.endrysan.java.library_app.view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ru.endrysan.java.library_app.controller.CreateBookController;
import ru.endrysan.java.library_app.controller.MainController;

public class MainView extends JFrame implements View {
    
    public JButton buttonViewUser;
    public JButton buttonViewBook;
    public JButton buttonCreateUser;
    public JButton buttonCreateBook;
    public MainView() {
        super("Main View");
        setPreferredSize(new Dimension(300, 180));
        setResizable(false);
        
        setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        
        JPanel panelFrame = new JPanel(new GridLayout(2, 2, 5, 10));
        
        panelFrame.add(buttonViewUser = new JButton("view user"));
        panelFrame.add(buttonViewBook = new JButton("view book"));
        panelFrame.add(buttonCreateUser = new JButton("create user"));
        panelFrame.add(buttonCreateBook = new JButton("create book"));
        
        add(panelFrame);
        
        MainController mainController = new MainController(this);
        buttonViewUser.addActionListener(mainController);
        buttonViewBook.addActionListener(mainController);
        buttonCreateUser.addActionListener(mainController);
        buttonCreateBook.addActionListener(mainController);
        
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new MainView();
    }

    @Override
    public void layoutYouself() {
        // TODO Auto-generated method stub
        
    }

}

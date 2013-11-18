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

public class CreateBookView extends JFrame implements View {
    
    public JButton buttonAddBook;
    public JButton buttonCancel;
    public JLabel labelNotification;
    public JTextField fieldAuthor;
    public JTextField fieldTitle;
    public JTextField fieldPublication;
    public JTextField fieldPages;
    public JTextField fieldGenre;
    
    public CreateBookView() {
        super("Create Book");
        setPreferredSize(new Dimension(300, 300));
        setResizable(false);
        
        setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        
        JPanel panelFrame = new JPanel(new GridLayout(5, 5, 5, 10));
        
        panelFrame.add(new JLabel("author"));
        panelFrame.add(fieldAuthor = new JTextField(10));
        panelFrame.add(new JLabel("title"));
        panelFrame.add(fieldTitle = new JTextField(10));
        panelFrame.add(new JLabel("publication"));
        panelFrame.add(fieldPublication = new JTextField(10));
        panelFrame.add(new JLabel("pages"));
        panelFrame.add(fieldPages = new JTextField(10));
        panelFrame.add(new JLabel("genre"));
        panelFrame.add(fieldGenre = new JTextField(10));
        
        JPanel panelNotification = new JPanel();
        labelNotification = new JLabel("");
        panelNotification.add(labelNotification);
        
        JPanel panelButton = new JPanel();
        buttonAddBook = new JButton("Add Book");
        buttonCancel = new JButton("Cancel");
        panelButton.add(buttonAddBook);
        panelButton.add(buttonCancel);
        
        add(panelFrame);
        add(panelNotification);
        add(panelButton);
        
        CreateBookController createBookController = new CreateBookController(this);
        buttonAddBook.addActionListener(createBookController);
        buttonCancel.addActionListener(createBookController);
        
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    @Override
    public void layoutYouself() {
        
    }
    public static void main(String[] args) {
        new CreateBookView();
    }
}

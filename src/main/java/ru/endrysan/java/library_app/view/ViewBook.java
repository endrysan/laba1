package ru.endrysan.java.library_app.view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import ru.endrysan.java.library_app.controller.MainController;

public class ViewBook extends JFrame implements View {
    
    public ViewBook() {
        super("View Book");
        setPreferredSize(new Dimension(300, 180));
        setResizable(false);
        
        setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        
        JPanel panelFrame = new JPanel(new GridLayout(2, 2, 5, 10));
        
        
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void layoutYouself() {
        // TODO Auto-generated method stub
        
    }
}

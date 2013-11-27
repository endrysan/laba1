package ru.endrysan.java.library_app.view;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;

import ru.endrysan.java.library_app.controller.ViewBookController;
import ru.endrysan.java.library_app.dao.BookDAO;
import ru.endrysan.java.library_app.model.Book;

public class ViewBook extends JFrame implements View {
    
    public ViewBook() {
        super("View Book");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        List<Book> books = new ArrayList<Book>();
        BookDAO bookDAO = BookDAO.getInstance();
        books.addAll(bookDAO.getAll());
        
        TableModel model = new ViewBookController(books);
        JTable table = new JTable(model);
 
        getContentPane().add(new JScrollPane(table));
 
        setPreferredSize(new Dimension(460, 220));
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

}

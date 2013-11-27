package ru.endrysan.java.library_app.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import ru.endrysan.java.library_app.model.Book;

public class ViewBookController implements TableModel {

    private Set<TableModelListener> listeners = new HashSet<TableModelListener>();
    
    private List<Book> books;

    public ViewBookController(List<Book> books) {
        this.books = books;
    }

    public void addTableModelListener(TableModelListener listener) {
        listeners.add(listener);
    }

    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    public int getColumnCount() {
        return 6;
    }

    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
        case 0:
            return "id";
        case 1:
            return "Author";
        case 2:
            return "Title";
        case 3:
            return "Publication";
        case 4:
            return "Pages";
        case 5:
            return "Genre";
        }
        return "";
    }

    public int getRowCount() {
        return books.size();
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        Book book = books.get(rowIndex);
        switch (columnIndex) {
        case 0:
            return book.getID();
        case 1:
            return book.getAuthor();
        case 2:
            return book.getTitle();
        case 3:
            return book.getPublication();
        case 4:
            return book.getPages();
        case 5:
            return book.getGenre();
        }
        return "";
    }

    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    public void removeTableModelListener(TableModelListener listener) {
        listeners.remove(listener);
    }

    public void setValueAt(Object value, int rowIndex, int columnIndex) {

    }

}

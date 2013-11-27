package ru.endrysan.java.library_app.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import ru.endrysan.java.library_app.model.User;

public class ViewUserController implements TableModel {
    
    private Set<TableModelListener> listeners = new HashSet<TableModelListener>();
    
    private List<User> users;

    public ViewUserController(List<User> users) {
        this.users = users;
    }

    public void addTableModelListener(TableModelListener listener) {
        listeners.add(listener);
    }

    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    public int getColumnCount() {
        return 4;
    }

    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
        case 0:
            return "id";
        case 1:
            return "First Name";
        case 2:
            return "Last Name";
        case 3:
            return "Activity";
        }
        return "";
    }

    public int getRowCount() {
        return users.size();
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        User user = users.get(rowIndex);
        switch (columnIndex) {
        case 0:
            return user.getID();
        case 1:
            return user.getFirstName();
        case 2:
            return user.getLastName();
        case 3:
            return user.isActive();
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


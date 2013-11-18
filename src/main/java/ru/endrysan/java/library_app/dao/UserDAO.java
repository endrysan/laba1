package ru.endrysan.java.library_app.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ru.endrysan.java.library_app.model.User;

public class UserDAO implements GenericDAO<User> {

    public static final String filename = "user.txt";
    private File file;
    
    public UserDAO() {
        file = new File(filename);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    @Override
    public void save(User user) {
        int lastUserId = 0;
        List<User> users = new ArrayList<User>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            
            for (String s = reader.readLine(); s != null; s = reader.readLine()) {
                User newUser = new User();
                int userId = Integer.parseInt(s);
                if (userId > lastUserId) {
                    lastUserId = userId;
                }
                newUser.setID(userId);
                newUser.setFirstName(reader.readLine());
                newUser.setLastName(reader.readLine());
                newUser.setActive(Boolean.parseBoolean(reader.readLine()));
                users.add(newUser);
            }
            user.setID(lastUserId + 1);
            users.add(user);
            reader.close();
            
            FileWriter writer = new FileWriter(file);
            for (User u: users) {
                writer.write(u.getID() + "\n");
                writer.write(u.getFirstName() + "\n");
                writer.write(u.getLastName() + "\n");
                writer.write(u.isActive() + "\n");
            }
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(User user) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void change(User entity) {
        
    }

    @Override
    public User getById(int id) {
        List<User> listUser = new ArrayList<User>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            
            for (String s = reader.readLine(); s != null; s = reader.readLine()) {
                User newUser = new User();
                newUser.setID(Integer.parseInt(s));
                newUser.setFirstName(reader.readLine());
                newUser.setLastName(reader.readLine());
                newUser.setActive(Boolean.parseBoolean(reader.readLine()));
                listUser.add(newUser);
            }
            reader.close();
            
            for (User u : listUser) {
                if (id == u.getID()) {
                    return u;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<User> getAll() {
        List<User> listUser = new ArrayList<User>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            
            for (String s = reader.readLine(); s != null; s = reader.readLine()) {
                User newUser = new User();
                newUser.setID(Integer.parseInt(s));
                newUser.setFirstName(reader.readLine());
                newUser.setLastName(reader.readLine());
                newUser.setActive(Boolean.parseBoolean(reader.readLine()));
                listUser.add(newUser);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listUser;
    }

}

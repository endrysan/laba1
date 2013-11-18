package ru.endrysan.java.library_app.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ru.endrysan.java.library_app.model.Book;
import ru.endrysan.java.library_app.model.Book.Genre;

public class BookDAO implements GenericDAO<Book> {

    public static final String filename = "book.txt";
    private File file;
    
    public BookDAO() {
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
    public void save(Book book) {
        int lastBookId = 0;
        List<Book> books = new ArrayList<Book>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            
            for (String s = reader.readLine(); s != null; s = reader.readLine()) {
                Book newBook = new Book();
                int bookId = Integer.parseInt(s);
                if (bookId > lastBookId) {
                    lastBookId = bookId;
                }
                newBook.setID(bookId);
                newBook.setAuthor(reader.readLine());
                newBook.setTitle(reader.readLine());
                newBook.setPublication(Integer.parseInt(reader.readLine()));
                newBook.setPages(Integer.parseInt(reader.readLine()));
                newBook.setGenre(Genre.valueOf(reader.readLine()));
                books.add(newBook);
            }
            book.setID(lastBookId + 1);
            books.add(book);
            reader.close();
            
            FileWriter writer = new FileWriter(file);
            for (Book b : books) {
                writer.write(b.getID() + "\n");
                writer.write(b.getAuthor() + "\n");
                writer.write(b.getTitle() + "\n");
                writer.write(b.getPublication() + "\n");
                writer.write(b.getPages() + "\n");
                writer.write(b.getGenre() + "\n");
            }
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Book entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void change(Book entity) {
        //
    }

    @Override
    public Book getById(int id) {
        List<Book> listBook = new ArrayList<Book>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            
            for (String s = reader.readLine(); s != null; s = reader.readLine()) {
                Book newBook = new Book();
                newBook.setID(Integer.parseInt(s));
                newBook.setAuthor(reader.readLine());
                newBook.setTitle(reader.readLine());
                newBook.setPublication(Integer.parseInt(reader.readLine()));
                newBook.setPages(Integer.parseInt(reader.readLine()));
                newBook.setGenre(Genre.valueOf(reader.readLine()));
                listBook.add(newBook);
            }
            reader.close();
            
            for (Book u: listBook) {
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
    public List<Book> getAll() {
        List<Book> listBook = new ArrayList<Book>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            
            for (String s = reader.readLine(); s != null; s = reader.readLine()) {
                Book newBook = new Book();
                newBook.setID(Integer.parseInt(s));
                newBook.setAuthor(reader.readLine());
                newBook.setTitle(reader.readLine());
                newBook.setPublication(Integer.parseInt(reader.readLine()));
                newBook.setPages(Integer.parseInt(reader.readLine()));
                newBook.setGenre(Genre.valueOf(reader.readLine()));
                listBook.add(newBook);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listBook;
    }

}

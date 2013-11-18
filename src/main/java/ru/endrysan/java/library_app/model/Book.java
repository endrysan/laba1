package ru.endrysan.java.library_app.model;

public class Book implements Entity {

    public enum Genre {
        DRAMA,
        FANTASY,
        MYSTERY,
        DETECTIVE
    }
    
    private int id;
    private String author;
    private String title;
    private int publication;
    private int pages;
    private Genre genre;
    
    @Override
    public int getID() {
        return id;
    }

    @Override
    public void setID(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPublication() {
        return publication;
    }

    public void setPublication(int publication) {
        this.publication = publication;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

}

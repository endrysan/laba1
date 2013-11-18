import java.util.ArrayList;
import java.util.List;

import ru.endrysan.java.library_app.dao.BookDAO;
import ru.endrysan.java.library_app.dao.UserDAO;
import ru.endrysan.java.library_app.model.Book;
import ru.endrysan.java.library_app.model.Book.Genre;
import ru.endrysan.java.library_app.model.User;


public class Application {

    public static void main(String[] args) {
        List<Book> listBook = new ArrayList<Book>();
        Book newBook = new Book();
        BookDAO bookDAO = new BookDAO();
//        
//        newBook.setAuthor("tyu");
//        newBook.setGenre(Genre.MYSTERY);
//        newBook.setPages(123);
//        newBook.setPublication(10092000);
//        newBook.setTitle("mnb");
        listBook = bookDAO.getAll();
        for (Book u : listBook) {
            System.out.println(u.getID());
            System.out.println(u.getAuthor());
            System.out.println(u.getTitle());
            System.out.println(u.getPages());
            System.out.println(u.getPublication());
            System.out.println(u.getGenre());
        }

    }

}

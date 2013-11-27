package ru.endrysan.java.library_app;

import ru.endrysan.java.library_app.view.MainView;


public class Application {

    public Application() {
        new Configuration();
        new MainView();
    }
    
    public static void main(String[] args) {
        new Application();
    }

}

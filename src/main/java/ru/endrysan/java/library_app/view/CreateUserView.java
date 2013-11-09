package ru.endrysan.java.library_app.view;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class CreateUserView extends JFrame implements View {

    private JTextField firstName;
    private JTextField lastName;
    private JCheckBox active;
    private JButton addUser;
    private JButton cancel;
    
    public CreateUserView() {
        firstName = new JTextField();
        lastName = new JTextField();
        active = new JCheckBox();
        addUser = new JButton("add user");
        cancel = new JButton("cancel");
        
        
    }
    @Override
    public void layoutYouself() {
        // TODO Auto-generated method stub
        
    }

}

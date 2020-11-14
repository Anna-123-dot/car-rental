package swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyFrame extends JFrame {


    public MyFrame() throws HeadlessException {
        super("Car rental- Welcome");
        setLocation(400, 400);
        setSize(300, 300);


        JPanel carImage = new CarImage();
        add(carImage);


        setLocation(400, 400);
        setSize(300, 300);
        setLayout(new FlowLayout());

        ButtonPanel buttons = new ButtonPanel();
        add(buttons);


        pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}


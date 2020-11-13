package swing;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {

    public MyFrame() throws HeadlessException {
        super("Car rental- Welcome");

        JPanel carImage = new CarImage();
        add(carImage);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocation(400, 400);
        setSize(300, 300);
        setLayout(new FlowLayout());

        add(new JButton("Button no 1"));
        add(new JButton("Button no 2"));
        add(new JButton("Button no 3"));


        setVisible(true);
    }
}

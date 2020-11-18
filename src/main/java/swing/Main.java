package swing;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        ImageIcon image = new ImageIcon("caricon.png");
        JLabel label = new JLabel();
        JFrame frame = new JFrame();

        frame.setTitle("Best cars");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(1500, 800);
        frame.add(label);


        label.setText("Welcome to our car rental company Best Cars!");
        label.setIcon(image);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.TOP);
        label.setForeground(new Color(0, 0, 139));
        label.setFont(new Font("MV Boli", Font.PLAIN, 20));
        label.setIconTextGap(50);
        label.setBackground(new Color(245, 245, 245));
        label.setBounds(100, 100, 250, 250);

    }
}


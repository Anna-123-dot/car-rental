package menu;



import dao.CarDao;
import dao.CustomerDao;

import javax.swing.*;
import java.awt.*;

public class CarMenu extends JFrame {


    private static void createAndShowCarMenuGUI() {

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        CarDao carDao = new CarDao();
        Container contentPane = frame.getContentPane();
        JButton buttonAdd = new JButton("Add customer");
        contentPane.add(buttonAdd);

        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowCarMenuGUI();
            }
        });
    }
}

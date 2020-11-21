package menu;

import dao.CarDao;
import dao.PresentRentalsDao;
import model.PresentRentals;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PresentRentalsMenu extends JFrame {

    public void createAndShowPresentRentalsMenuGUI() {

        JFrame frame = new JFrame("PRESENT RENTALS MENU");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        PresentRentalsDao presentRentalsDao = new PresentRentalsDao();
        JButton buttonShowAll = new JButton("Show all");
        Container contentPane = frame.getContentPane();
        contentPane.add(buttonShowAll);


        buttonShowAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                presentRentalsDao.findAll().forEach(presentRentals -> System.out.println(presentRentals.toString()));
            }
        });

        frame.pack();
        frame.setVisible(true);
    }


}



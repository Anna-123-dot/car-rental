package menu;

import javax.swing.*;

public class PresentRentalsMenu extends JFrame {

    private static void createAndShowPresentRentalsMenuGUI() {

        JFrame frame = new JFrame("PRESENT RENTALS MENU");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowPresentRentalsMenuGUI();
            }
        });
    }
}


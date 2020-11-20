package menu;



import javax.swing.*;

public class CarMenu extends JFrame {


    private static void createAndShowCarMenuGUI() {

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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

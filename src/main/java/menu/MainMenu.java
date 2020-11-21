package menu;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class MainMenu extends JPanel implements ActionListener {


    protected JButton b1, b2, b3;
    CarMenu carMenu = new CarMenu();
    CustomerMenu customerMenu = new CustomerMenu();
    PresentRentalsMenu presentRentalsMenu = new PresentRentalsMenu();

    public MainMenu() {
        b1 = new JButton("Edit car");
        b1.setVerticalTextPosition(AbstractButton.CENTER);
        b1.setHorizontalTextPosition(AbstractButton.LEADING);
        b1.setMnemonic(KeyEvent.VK_D);
        b1.setActionCommand("enable");

        b2 = new JButton("Edit customer");
        b2.setVerticalTextPosition(AbstractButton.BOTTOM);
        b2.setHorizontalTextPosition(AbstractButton.CENTER);
        b2.setMnemonic(KeyEvent.VK_M);
        b2.setActionCommand("enable");

        b3 = new JButton("Edit present rentals");
        b3.setMnemonic(KeyEvent.VK_E);
        b3.setActionCommand("enable");


        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);


        add(b1);
        add(b2);
        add(b3);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            carMenu.createAndShowCarMenuGUI();

        } else if (e.getSource() == b2) {
            customerMenu.createAndShowCustomerMenuGUI();

        } else {

            presentRentalsMenu.createAndShowPresentRentalsMenuGUI();
        }
    }


    private static void createAndShowMainMenuGUI() {

        JFrame frame = new JFrame("WELCOME TO OUR CAR RENTAL COMPANY SITE");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MainMenu newContentPane = new MainMenu();

        frame.setContentPane(newContentPane);
        frame.getContentPane().add(new JLabel(new ImageIcon("caricon.png")));

        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowMainMenuGUI();
            }
        });
    }
}


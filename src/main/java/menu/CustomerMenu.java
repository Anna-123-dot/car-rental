package menu;

import dao.CustomerDao;
import model.Customer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerMenu extends JFrame {


    private static void createAndShowCustomerMenuGUI() {
        CustomerDao customerDao = new CustomerDao();
        JFrame f = new JFrame();
        Container contentPane = f.getContentPane();

        JButton buttonAdd = new JButton("Add customer");
        JButton buttonRemove = new JButton("Remove customer");

        JTextField firstName = new JTextField();
        JTextField lastName = new JTextField();
        JTextField customerId = new JTextField();

        JLabel labelFirstName = new JLabel("Please insert customer first name");
        JPanel panelFirstName = new JPanel(new BorderLayout());
        panelFirstName.add(labelFirstName, BorderLayout.NORTH);
        panelFirstName.add(firstName, BorderLayout.SOUTH);

        JLabel labelLastName = new JLabel("Please insert customer last name");
        JPanel panelLastName = new JPanel(new BorderLayout());
        panelLastName.add(labelLastName, BorderLayout.NORTH);
        panelLastName.add(lastName, BorderLayout.SOUTH);

        JLabel labelCustomerId = new JLabel("Please insert customer first name");
        JPanel panelCustomerId = new JPanel(new BorderLayout());
        panelCustomerId.add(labelCustomerId, BorderLayout.PAGE_END);
        panelCustomerId.add(customerId, BorderLayout.SOUTH);


        buttonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (e.getSource() == buttonAdd) {
                    Customer customer = new Customer(firstName.getText(), lastName.getText());
                    customerDao.add(customer);
                } else {
                    Customer customer = new Customer(firstName.getText(), lastName.getText());
                    customerDao.remove(customer);
                }
            }
        });


        contentPane.add(buttonAdd);
        contentPane.add(buttonRemove);
        contentPane.add(panelFirstName);
        contentPane.add(panelLastName);


        f.setLayout(new GridLayout(3, 2));
        f.setVisible(true);
        f.pack();


    }

    public static void main(String[] args) {

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowCustomerMenuGUI();
            }
        });
    }
}
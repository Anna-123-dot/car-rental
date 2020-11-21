package menu;

import dao.CustomerDao;
import model.Customer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerMenu extends JFrame {


    public void createAndShowCustomerMenuGUI() {
        CustomerDao customerDao = new CustomerDao();
        JFrame f = new JFrame("CUSTOMER MENU");
        Container contentPane = f.getContentPane();

        JButton buttonAdd = new JButton("Add customer");
        JButton buttonRemove = new JButton("Remove customer");
        JButton buttonShowAllCustomers = new JButton("Show all");

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

        JLabel labelCustomerId = new JLabel("Please insert customer id");
        JPanel panelCustomerId = new JPanel(new BorderLayout());
        panelCustomerId.add(labelCustomerId, BorderLayout.PAGE_END);
        panelCustomerId.add(customerId);

        JPanel panelShowAll = new JPanel();
        panelShowAll.add(buttonShowAllCustomers);



        buttonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Customer customer = new Customer(firstName.getText(), lastName.getText());
                customerDao.add(customer);
                }

        });
        buttonShowAllCustomers.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                customerDao.findAll().forEach(customer -> System.out.println(customer.toString()));
            }
        });
        buttonRemove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(customerId.getText());
                Customer customerToBeRemoved = customerDao.findById(id);
                customerDao.remove(customerToBeRemoved);
                }

        });


        contentPane.add(buttonAdd);
        contentPane.add(buttonRemove);
        contentPane.add(panelFirstName);
        contentPane.add(panelLastName);
        contentPane.add(panelCustomerId);

        contentPane.add(buttonShowAllCustomers);


        f.setLayout(new FlowLayout(FlowLayout.LEFT));
        f.setVisible(true);
        f.pack();


    }


}
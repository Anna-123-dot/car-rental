package menu;

import dao.CustomerDao;
import model.Customer;
import javax.swing.*;

public class CustomerMenu extends JFrame {

    public void createAndShowCustomerMenuGUI() {

        CustomerDao customerDao = new CustomerDao();
        JButton jButton1 = new javax.swing.JButton();
        JButton jButton2 = new javax.swing.JButton();
        JButton jButton3 = new javax.swing.JButton();
        JLabel jLabel1 = new javax.swing.JLabel();
        JTextField firstName = new javax.swing.JTextField();
        JTextField lastName = new javax.swing.JTextField();
        JLabel jLabel2 = new javax.swing.JLabel();
        JLabel jLabel4 = new javax.swing.JLabel();
        JTextField customerId = new javax.swing.JTextField();
        JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        JTable jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CUSTOMER MENU");

        jButton1.setText("Add customer");
        jButton1.addActionListener(evt -> {
            Customer customer = new Customer(firstName.getText(), lastName.getText());
            customerDao.add(customer);
            jTable1.setModel(new CustomerDao().allCustomerTable(new CustomerDao().findAll()));
            jScrollPane1.setViewportView(jTable1);
        });

        jButton2.setText("Remove customer");
        jButton2.addActionListener(evt -> {
            int id = Integer.parseInt(customerId.getText());
            Customer customerToBeRemoved = customerDao.findById(id);
            customerDao.remove(customerToBeRemoved);
            jTable1.setModel(new CustomerDao().allCustomerTable(new CustomerDao().findAll()));
            jScrollPane1.setViewportView(jTable1);
        });

        jButton3.setText("Show all");
        jButton3.addActionListener(evt -> {
            jTable1.setModel(new CustomerDao().allCustomerTable(new CustomerDao().findAll()));
            jScrollPane1.setViewportView(jTable1);
        });

        jLabel1.setText("Customer first name");
        jLabel2.setText("Customer last name");
        jLabel4.setText("Customer id");

        jTable1.setModel(new CustomerDao().allCustomerTable(new CustomerDao().findAll()));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(84, 84, 84)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                        .addComponent(firstName, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(79, 79, 79)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                        .addComponent(lastName, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(90, 90, 90)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jButton3)
                                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(customerId, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(99, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton1)
                                        .addComponent(jButton2)
                                        .addComponent(jButton3))
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(firstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(customerId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(28, 28, 28)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
        setVisible(true);
    }
}
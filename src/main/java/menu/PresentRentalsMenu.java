package menu;

import com.toedter.calendar.JDateChooser;
import dao.CarDao;
import dao.CustomerDao;
import dao.PresentRentalsDao;
import date.DateConversion;
import model.PresentRentals;

import javax.swing.*;


public class PresentRentalsMenu extends JFrame {

    @SuppressWarnings("ConstantConditions")
    public void createAndShowPresentRentalsMenuGUI() {

        PresentRentalsDao presentRentalsDao = new PresentRentalsDao();
        CustomerDao customerDao = new CustomerDao();
        CarDao carDao = new CarDao();
        JButton jButton1 = new javax.swing.JButton();
        JButton jButton2 = new javax.swing.JButton();
        JButton jButton3 = new javax.swing.JButton();
        JDateChooser jDateChooserRentalDate = new com.toedter.calendar.JDateChooser();
        JDateChooser jDateChooserPlannedReturnDate = new com.toedter.calendar.JDateChooser();
        JDateChooser jDateChooserReturnDate = new com.toedter.calendar.JDateChooser();
        JTextField jTextField4 = new javax.swing.JTextField();
        JTextField jTextField1 = new JTextField();
        JTextField jTextField2 = new JTextField();
        JLabel jLabel1 = new javax.swing.JLabel();
        JLabel jLabel2 = new javax.swing.JLabel();
        JLabel jLabel3 = new javax.swing.JLabel();
        JLabel jLabel4 = new javax.swing.JLabel();
        JLabel jLabelChooseCar = new javax.swing.JLabel("Choose car");
        JLabel jLabelChooseCustomer = new javax.swing.JLabel("Choose customer");
        JLabel jLabelCarId = new JLabel("Car id no");
        JLabel jLabelCustomerId = new JLabel("Customer id no");
        JComboBox<Integer> jComboBox1 = new javax.swing.JComboBox<>();
        for (int i = 1; i < carDao.findAll().size() + 1; i++) {
            jComboBox1.addItem(i);
        }
        JComboBox<Integer> jComboBox2 = new javax.swing.JComboBox<>();
        for (int i = 1; i < customerDao.findAll().size() + 1; i++) {
            jComboBox2.addItem(i);
        }
        JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        JTable jTablePresentRentals = new javax.swing.JTable();
        JScrollPane jScrollPane2 = new javax.swing.JScrollPane();
        JTable jTableCustomers = new javax.swing.JTable();
        JScrollPane jScrollPane3 = new javax.swing.JScrollPane();
        JTable jTableCars = new javax.swing.JTable();

        jComboBox1.addActionListener(evt -> {

        });
        jComboBox2.addActionListener(evt -> {

        });


        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("PRESENT RENTALS MENU");

        jButton1.setText("Add");
        jButton1.addActionListener(evt -> {

            int chosenCar = (int) jComboBox1.getSelectedItem();
            int chosenCustomer = (int) jComboBox2.getSelectedItem();
            PresentRentals newPresentRental = new PresentRentals(DateConversion.convertToLocalDate(jDateChooserRentalDate.getDate()), DateConversion.convertToLocalDate(jDateChooserPlannedReturnDate.getDate()), DateConversion.convertToLocalDate(jDateChooserReturnDate.getDate()), carDao.findById(chosenCar), customerDao.findById(chosenCustomer));
            presentRentalsDao.add(newPresentRental);
            jTablePresentRentals.setModel(presentRentalsDao.allPresentRentalsTable(new PresentRentalsDao().findAll()));
            jScrollPane1.setViewportView(jTablePresentRentals);
        });
        jButton2.setText("Remove");
        jButton2.addActionListener(evt -> {
            PresentRentals presentRentalsToBeRemoved = presentRentalsDao.findById(Integer.parseInt(jTextField4.getText()));
            presentRentalsDao.remove(presentRentalsToBeRemoved);
            jTablePresentRentals.setModel(presentRentalsDao.allPresentRentalsTable(new PresentRentalsDao().findAll()));
            jScrollPane1.setViewportView(jTablePresentRentals);
        });
        jButton3.setText("Update planned return date");
        jButton3.addActionListener(evt -> {
            PresentRentals presentRentalsToBeChange = presentRentalsDao.findById(Integer.parseInt(jTextField4.getText()));
            presentRentalsToBeChange.setPlannedReturnDate(DateConversion.convertToLocalDate(jDateChooserPlannedReturnDate.getDate()));
            presentRentalsDao.update(presentRentalsToBeChange);
            jTablePresentRentals.setModel(presentRentalsDao.allPresentRentalsTable(new PresentRentalsDao().findAll()));
            jScrollPane1.setViewportView(jTablePresentRentals);
        });
        jLabel1.setText("Rental date");
        jLabel2.setText("Planned return date");
        jLabel3.setText("Return date");
        jLabel4.setText("Present rental id no");

        jTablePresentRentals.setModel(presentRentalsDao.allPresentRentalsTable(new PresentRentalsDao().findAll()));
        jScrollPane1.setViewportView(jTablePresentRentals);
        jTableCustomers.setModel(customerDao.allCustomerTable(new CustomerDao().findAll()));
        jScrollPane2.setViewportView(jTableCustomers);
        jTableCars.setModel(carDao.allCarTable(new CarDao().findAll()));
        jScrollPane3.setViewportView(jTableCars);
        jDateChooserRentalDate.setDateFormatString("yyyy-MM-dd");
        jDateChooserPlannedReturnDate.setDateFormatString("yyyy-MM-dd");
        jDateChooserReturnDate.setDateFormatString("yyyy-MM-dd");


        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addComponent(jButton3))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(80, 80, 80)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabelCarId, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(10, 10, 10))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(jDateChooserRentalDate, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(114, 114, 114)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jDateChooserPlannedReturnDate, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabelChooseCar, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(122, 122, 122)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(145, 145, 145)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jDateChooserReturnDate, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabelCustomerId, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(0, 167, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabelChooseCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(264, 264, 264)
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(201, 201, 201)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jScrollPane3)
                                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 567, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(13, 13, 13)
                                                .addComponent(jButton1))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(jLabel1)
                                                                .addComponent(jLabel2))
                                                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(21, 21, 21)
                                                .addComponent(jButton2))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jDateChooserRentalDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jDateChooserReturnDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jDateChooserPlannedReturnDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabelChooseCustomer)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabelChooseCar)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3)
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabelCustomerId)
                                        .addComponent(jLabelCarId))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(88, 88, 88)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(55, 55, 55)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(77, 77, 77)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(205, Short.MAX_VALUE))
        );

        pack();
        setVisible(true);
    }

}



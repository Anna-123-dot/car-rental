package menu;

import dao.CarDao;
import model.Car;

import javax.swing.*;

public class CarMenu extends JFrame {

    public void createAndShowCarMenuGUI() {

        CarDao carDao = new CarDao();
        JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        JButton jButton1 = new javax.swing.JButton();
        JButton jButton2 = new javax.swing.JButton();
        JButton jButton3 = new javax.swing.JButton();
        JTextField jTextField1 = new javax.swing.JTextField();
        JTextField jTextField2 = new javax.swing.JTextField();
        JTextField jTextField3 = new javax.swing.JTextField();
        JTextField jTextField4 = new javax.swing.JTextField();
        JTextField jTextField5 = new javax.swing.JTextField();
        JTextField jTextField6 = new javax.swing.JTextField();
        JLabel jLabel1 = new javax.swing.JLabel();
        JLabel jLabel2 = new javax.swing.JLabel();
        JLabel jLabel3 = new javax.swing.JLabel();
        JLabel jLabel4 = new javax.swing.JLabel();
        JLabel jLabel5 = new javax.swing.JLabel();
        JLabel jLabel6 = new javax.swing.JLabel();
        JScrollPane jScrollPane2 = new javax.swing.JScrollPane();
        JTable jTable2 = new javax.swing.JTable();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CAR MENU");

        jButton1.setText("Add car");
        jButton1.addActionListener(evt -> {
            Car newCar = new Car(jTextField1.getText(), jTextField2.getText(), jTextField3.getText(), jTextField4.getText(), Boolean.parseBoolean(jTextField5.getText()));
            carDao.add(newCar);
            jTable2.setModel(new CarDao().allCarTable(( new CarDao().findAll() )));
            jScrollPane2.setViewportView(jTable2);
        });

        jButton2.setText("Remove car");
        jButton2.addActionListener(evt -> {
            Car carToBeRemoved = carDao.findById(Integer.parseInt(jTextField6.getText()));
            carDao.remove(carToBeRemoved);
            jTable2.setModel(new CarDao().allCarTable(( new CarDao().findAll() )));
            jScrollPane2.setViewportView(jTable2);
        });

        jButton3.setText("Show all");
        jButton3.addActionListener(evt -> {
            jTable2.setModel(new CarDao().allCarTable(( new CarDao().findAll() )));
            jScrollPane2.setViewportView(jTable2);
        });

        jLabel1.setText("Car brand");
        jLabel2.setText("Car model");
        jLabel3.setText("Color");
        jLabel4.setText("Car registration no");
        jLabel5.setText("Is car damaged?");
        jLabel6.setText("Car id");

        jTable2.setModel(new CarDao().allCarTable(( new CarDao().findAll() )));
        jScrollPane2.setViewportView(jTable2);


        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                                                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(63, 63, 63)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                                                        .addComponent(jTextField2)
                                                        .addComponent(jTextField3))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                .addComponent(jTextField6, javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(jTextField5, javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                                                                .addComponent(jTextField4, javax.swing.GroupLayout.Alignment.LEADING)))
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(8, 8, 8)
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 663, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(29, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addComponent(jButton1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel5)
                                        .addComponent(jButton2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel6)
                                        .addComponent(jButton3))
                                .addGap(2, 2, 2)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 137, Short.MAX_VALUE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(128, 128, 128))
        );

        pack();
        setVisible(true);
    }
}


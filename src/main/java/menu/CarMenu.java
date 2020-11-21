package menu;


import dao.CarDao;
import dao.CustomerDao;
import model.Car;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CarMenu extends JFrame {


    public void createAndShowCarMenuGUI() {

        JFrame frame = new JFrame("CAR MENU");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        CarDao carDao = new CarDao();
        Container contentPane = frame.getContentPane();
        JButton buttonAdd = new JButton("Add car");
        JButton buttonShowAll = new JButton("Show all");
        JButton buttonRemove = new JButton("Remove car");
        JTextField brand = new JTextField("Brand");
        JTextField model = new JTextField("Model");
        JTextField color = new JTextField("Color");
        JTextField registrationNumber = new JTextField("Registration number");
        JTextField isDamagedTxt = new JTextField("Is damaged");
        JTextField carId = new JTextField("Car id");

        contentPane.add(buttonAdd);
        contentPane.add(buttonRemove);
        contentPane.add(buttonShowAll);

        contentPane.add(brand);
        contentPane.add(model);
        contentPane.add(color);
        contentPane.add(registrationNumber);
        contentPane.add(isDamagedTxt);
        contentPane.add(carId);

        buttonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Car newCar = new Car(brand.getText(), model.getText(), color.getText(), registrationNumber.getText(),Boolean.parseBoolean(isDamagedTxt.getText()));
                carDao.add(newCar);
            }
        });
        buttonRemove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Car carToBeRemoved = carDao.findById(Integer.parseInt(carId.getText()));
                carDao.remove(carToBeRemoved);
            }
        });

        buttonShowAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carDao.findAll().forEach(car -> System.out.println(car.toString()));
            }
        });

        frame.setLayout(new FlowLayout(FlowLayout.LEFT));
        frame.pack();
        frame.setVisible(true);
    }


}


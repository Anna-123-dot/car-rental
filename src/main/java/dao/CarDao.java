package dao;

import database.SessionProvider;
import model.Car;
import org.hibernate.Session;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class CarDao extends AbstractDao<Car> {


    public CarDao() {
        super(Car.class);

    }

    public List<Car> allDamagedCarsFees(boolean isDamaged) {
        Session session = SessionProvider.getSession();
        List<Car> records = session.createQuery("from Car as c where c.isDamaged=:isDamaged", Car.class)
                .setParameter("isDamaged", isDamaged)
                .stream().filter(e -> {
                    System.out.println("Za uszkodzenia samochodu naliczono dodatkową opłatę w wysokości 500 PLN");
                    return isDamaged;
                })
                .collect(Collectors.toList());

        session.close();
        return records;
    }
    public DefaultTableModel allCarTable(List<Car> cars) {

        List<String[]> values = new ArrayList<>();
        for (Car car : cars) {
            values.add(new String[]{String.valueOf(car.getId()), car.getBrand(), car.getModel(), car.getColor(), car.getRegistrationNumber(), String.valueOf(car.isDamaged())});
        }
        String[] column = {"Id", "Brand", "Model","Color", "Registration number", "Is damaged?"};

        return new DefaultTableModel(values.toArray(new Object[][]{}), column);
    }

}








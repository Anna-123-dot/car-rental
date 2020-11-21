package dao;

import database.SessionProvider;
import model.Car;
import org.hibernate.Session;

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

}








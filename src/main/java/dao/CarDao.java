package dao;

import database.SessionProvider;
import model.Car;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;


import java.util.List;


public class CarDao extends AbstractDao<Car> {

    public CarDao() {
        super(Car.class);
    }



    public List<Car> findAll() {
        Session session = SessionProvider.getSession();
        List<Car> carList = session.createQuery("from Car", Car.class).list();
        session.close();
        return carList;
    }
}



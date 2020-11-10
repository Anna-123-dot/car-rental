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

    public void updateInformationAboutDamages(int id, boolean isDamaged) {
        Session session = SessionProvider.getSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Car car = session.get(Car.class, id);
            car.setDamaged(isDamaged);
            session.update(car);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {

            session.close();

        }
    }

    public List<Car> findAll() {
        Session session = SessionProvider.getSession();
        List<Car> carList = session.createQuery("from Car", Car.class).list();
        session.close();
        return carList;
    }
}



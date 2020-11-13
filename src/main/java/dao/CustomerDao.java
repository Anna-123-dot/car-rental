package dao;

import database.SessionProvider;
import model.Car;
import model.Customer;
import org.hibernate.Session;

import java.util.List;

public class CustomerDao extends AbstractDao<Customer> {

    public CustomerDao() {
        super(Customer.class);
    }

    public List<Customer> findAll() {
        Session session = SessionProvider.getSession();
        List<Customer> customerList = session.createQuery("from Customer",Customer.class).list();
        session.close();
        return customerList;
    }
}

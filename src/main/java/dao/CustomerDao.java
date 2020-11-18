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



}

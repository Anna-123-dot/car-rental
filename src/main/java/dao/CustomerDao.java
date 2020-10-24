package dao;

import model.Customer;

public class CustomerDao extends AbstractDao<Customer> {

    public CustomerDao() {
        super(Customer.class);
    }
}

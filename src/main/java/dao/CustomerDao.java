package dao;

import model.Customer;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao extends AbstractDao<Customer> {

    public CustomerDao() {
        super(Customer.class);
    }

    public DefaultTableModel allCustomerTable(List<Customer> customers) {

        List<String[]> values = new ArrayList<>();
        for (Customer c : customers) {
            values.add(new String[]{String.valueOf(c.getId()), c.getFirstName(), c.getLastName()});
        }
        String[] column = {"Id", "First name", "Last name"};

        return new DefaultTableModel(values.toArray(new Object[][]{}), column);
    }

}

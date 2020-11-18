package dao;

import database.SessionProvider;
import model.Car;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class CarDao extends AbstractDao<Car> {


    public CarDao() {
        super(Car.class);

    }



}




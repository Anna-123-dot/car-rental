package dao;

import database.SessionProvider;
import model.PresentRentals;
import org.hibernate.Session;

import java.time.LocalDateTime;
import java.util.List;

public class PresentRentalsDao extends AbstractDao<PresentRentals> {

    public PresentRentalsDao() {
        super(PresentRentals.class);
    }


}

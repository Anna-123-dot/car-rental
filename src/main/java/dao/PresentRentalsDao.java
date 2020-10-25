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
    public List<PresentRentals> lateReturn (LocalDateTime plannedReturnDate, LocalDateTime returnDate) {
        Session session = SessionProvider.getSession();
        List<PresentRentals> records = session.createQuery("select r.plannedReturnDate, r.returnDate from PresentRentals as r", PresentRentals.class)
                .list();
        session.close();
        return records;
    }


}

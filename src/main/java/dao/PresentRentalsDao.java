package dao;

import database.SessionProvider;
import model.PresentRentals;
import org.hibernate.Session;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class PresentRentalsDao extends AbstractDao<PresentRentals> {

    public PresentRentalsDao() {
        super(PresentRentals.class);
    }

    public List<PresentRentals> lateReturn() {
        Session session = SessionProvider.getSession();
        List<Object[]> list = session.createQuery("select r.id, r.plannedReturnDate, r.returnDate from PresentRentals as r", Object[].class)
                .list();
        List<PresentRentals> records = list.stream()
                .filter(columns -> {
                    LocalDateTime plannedReturnDate = LocalDateTime.parse(columns[1].toString());
                    LocalDateTime returnDate = LocalDateTime.parse(columns[2].toString());
                    int result = returnDate.compareTo(plannedReturnDate);
                    return result > 0;
                })
                .map(columns -> {
                    int id = Integer.parseInt(columns[0].toString());
                    return findById(id);
                })
                .collect(Collectors.toList());
        session.close();
        return records;
    }


}

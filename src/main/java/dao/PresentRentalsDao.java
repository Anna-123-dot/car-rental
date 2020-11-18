package dao;

import database.SessionProvider;
import model.Car;
import model.PresentRentals;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

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
                    int id = Integer.parseInt(columns[0].toString());
                    LocalDateTime plannedReturnDate = LocalDateTime.parse(columns[1].toString());
                    LocalDateTime returnDate = LocalDateTime.parse(columns[2].toString());
                    int result = returnDate.compareTo(plannedReturnDate);

                    if (result > 0) {
                        System.out.println("Wynajem nr: " + id + " ,ilość dni o ile przekroczono okresu wynajmu= " + result);
                        System.out.println("Będzie naliczona dodatkowa opłata za przekroczenie terminu zwrotu samochodu 80 PLN/dzień, czyli  " + result * 80 + " PLN");
                    } else if (result == 0) {
                        System.out.println("Wynajem nr: " + id + ". Dziękujemy za terminowy zwrot samochodu");
                    } else {
                        System.out.println("Wynajem nr: " + id + ". Dziękujemy za zwrot samochodu przed czasem");
                    }
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

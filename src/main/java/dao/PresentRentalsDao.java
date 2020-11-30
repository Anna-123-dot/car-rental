package dao;

import database.SessionProvider;
import model.Car;
import model.PresentRentals;
import org.hibernate.Session;


import javax.swing.table.DefaultTableModel;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PresentRentalsDao extends AbstractDao<PresentRentals> {

    public PresentRentalsDao() {
        super(PresentRentals.class);
    }


    public List<PresentRentals> lateReturnAndDamageFees() {
        Session session = SessionProvider.getSession();
        List<Object[]> list = session.createQuery("select r.id, r.plannedReturnDate, r.returnDate, c.isDamaged from PresentRentals as r join Car as c on r.id=c.id", Object[].class)
                .list();
        List<PresentRentals> records = list.stream()
                .filter(columns -> {
                    int id = Integer.parseInt(columns[0].toString());
                    LocalDateTime plannedReturnDate = LocalDateTime.parse(columns[1].toString());
                    LocalDateTime returnDate = LocalDateTime.parse(columns[2].toString());
                    boolean isDamaged = Boolean.parseBoolean(columns[3].toString());

                    if (isDamaged) {
                        System.out.println("Wynajem nr: " + id + ". Za uszkodzenia samochodu naliczono dodatkową opłatę w wysokości 500 PLN");
                    } else {
                        System.out.println("Wynajem nr: " + id + ". Dziękujemy za zwrot nieuszkodzonego samochodu");
                    }
                    int result = returnDate.compareTo(plannedReturnDate);

                    if (result > 0) {
                        System.out.println("Wynajem nr: " + id + ". Ilość dni o ile przekroczono okresu wynajmu= " + result);
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

    public DefaultTableModel allPresentRentalsTable(List<PresentRentals> rentals) {

        List<String[]> values = new ArrayList<>();
        for (PresentRentals r : rentals) {
            values.add(new String[]{String.valueOf(r.getId()), String.valueOf(r.getPlannedReturnDate()), String.valueOf(r.getRentalDate()), String.valueOf(r.getReturnDate()), String.valueOf(r.getCar().getId()), String.valueOf(r.getCustomer().getId())});
        }
        String[] column = {"Id", "Planned return date", "Rental date", "Return date", "Car id", "Customer id"};

        return new DefaultTableModel(values.toArray(new Object[][]{}), column);
    }
}

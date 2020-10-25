import dao.CarDao;
import dao.CustomerDao;
import dao.PresentRentalsDao;
import model.Car;
import model.Customer;
import model.PresentRentals;


import java.time.LocalDateTime;


public class App {
    public static void main(String[] args) {
        CarDao carDao = new CarDao();
        CustomerDao customerDao = new CustomerDao();
        PresentRentalsDao presentRentalsDao = new PresentRentalsDao();
        Car car1 = new Car("Toyota", "Yaris", "grey", "GD12345", false);
        Car car2 = new Car("Ford", "Fiesta", "red", "GD12346", false);
        Car car3 = new Car("Ford", "Focus", "black", "GD12347", false);
        Car car4 = new Car("Suzuki", "Vitara", "white", "GD12348", true);
        Car car5 = new Car("Honda", "Civic", "blue", "GD12349", false);
        //carDao.add(car1);
        //carDao.add(car2);
        //carDao.add(car3);
        //carDao.add(car4);
        //carDao.add(car5);
        Customer customer1 = new Customer("Elżbieta", "Czyżewska");
        Customer customer2 = new Customer("Zofia", "Stryjska");
        Customer customer3 = new Customer("Jerzy", "Malinowski");
        Customer customer4 = new Customer("Wiesław", "Kowalewski");
        Customer customer5 = new Customer("Jacek", "Piotrowski");
        //customerDao.add(customer1);
        //customerDao.add(customer2);
        //customerDao.add(customer3);
        //customerDao.add(customer4);
        //customerDao.add(customer5);
        PresentRentals presentRentals1 = new PresentRentals(LocalDateTime.of(2020, 10, 10, 10, 0, 0),
                LocalDateTime.of(2020, 10, 12, 10, 0, 0), LocalDateTime.of(2020, 10, 14, 14, 15, 0), carDao.findById(1), customerDao.findById(3));
        PresentRentals presentRentals2 = new PresentRentals(LocalDateTime.of(2020, 10, 20, 10, 0, 0),
                LocalDateTime.of(2020, 10, 30, 12, 0, 0), LocalDateTime.of(2020, 10, 30, 11, 0, 0), carDao.findById(2), customerDao.findById(2));
        PresentRentals presentRentals3 = new PresentRentals(LocalDateTime.of(2020, 10, 30, 8, 0, 0),
                LocalDateTime.of(2020, 11, 3, 23, 0, 0), LocalDateTime.of(2020, 11, 2, 23, 59, 0), carDao.findById(5), customerDao.findById(1));
        //presentRentalsDao.add(presentRentals1);
        //presentRentalsDao.add(presentRentals2);
        //presentRentalsDao.add(presentRentals3);
        System.out.println(presentRentalsDao.lateReturn());

    }
}

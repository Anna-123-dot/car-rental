import dao.CarDao;
import dao.CarSegmentClassDao;
import dao.CustomerDao;
import dao.PresentRentalsDao;
import model.*;

import java.math.BigDecimal;
import java.time.LocalDate;

public class App {

    public static void main(String[] args) {
        CarDao carDao = new CarDao();
        CustomerDao customerDao = new CustomerDao();
        PresentRentalsDao presentRentalsDao = new PresentRentalsDao();
        CarSegmentClassDao carSegmentClassDao = new CarSegmentClassDao();
        PriceLogic priceLogic = new PriceLogic();

        Car car1 = new Car("Toyota", "Yaris", "grey", "GD12345", false);
        Car car2 = new Car("Ford", "Fiesta", "red", "GD12346", false);
        Car car3 = new Car("Ford", "Focus", "black", "GD12347", false);
        Car car4 = new Car("Suzuki", "Vitara", "white", "GD12348", true);
        Car car5 = new Car("Honda", "Civic", "blue", "GD12349", false);
        Car car6 = new Car("Opel", "Insignia", "black", "GD12350", false);

       // Adding new car
//        carDao.add(car1);
//        carDao.add(car2);
//        carDao.add(car3);
//        carDao.add(car4);
//        carDao.add(car5);
//        carDao.add(car6);

        //Removing car
        //Car carToBeRemoved = carDao.findById(4);
        //System.out.println(carToBeRemoved);
        //carDao.remove(carToBeRemoved);
        Customer customer1 = new Customer("Elżbieta", "Czyżewska");
        Customer customer2 = new Customer("Zofia", "Stryjska");
        Customer customer3 = new Customer("Jerzy", "Malinowski");
        Customer customer4 = new Customer("Wiesław", "Kowalewski");
        Customer customer5 = new Customer("Jacek", "Piotrowski");
        Customer customer6 = new Customer("Wojciech", "Piepiórka");

        //Adding customer
//        customerDao.add(customer1);
//        customerDao.add(customer2);
//        customerDao.add(customer3);
//        customerDao.add(customer4);
//        customerDao.add(customer5);
//        customerDao.add(customer6);

        //Removing customer
        //Customer customerToBeRemoved = customerDao.findById(1);
        //customerDao.remove(customerToBeRemoved);


//        PresentRentals presentRentals1 = new PresentRentals(LocalDate.of(2020, 10, 20),
//                LocalDate.of(2020, 10, 30), LocalDate.of(2020, 10, 30), BigDecimal.valueOf(160.0),BigDecimal.valueOf(0.0),BigDecimal.valueOf(160.0), RentStatus.FINISHED, carDao.findById(1), customerDao.findById(1));
//        PresentRentals presentRentals3 = new PresentRentals(LocalDate.of(2020, 10, 30),
//                LocalDate.of(2020, 11, 3), LocalDate.of(2020, 11, 2), carDao.findById(5), customerDao.findById(5));
//        PresentRentals presentRentals4 = new PresentRentals(LocalDate.of(2020, 11, 2), LocalDate.of(2020, 11, 3),
//                LocalDate.of(2020, 11, 25), carDao.findById(3), customerDao.findById(5));

        //Adding new rental agreement
//       presentRentalsDao.add(presentRentals1);
//        presentRentalsDao.add(presentRentals2);
//        presentRentalsDao.add(presentRentals3);
//        presentRentalsDao.add(presentRentals4);

        //Modification of plannedReturnDate or any other date when we change .set....
//        PresentRentals presentRentalsToBeChange = presentRentalsDao.findById(3);
//        presentRentalsToBeChange.setPlannedReturnDate(LocalDateTime.of(2020,12,15,18,0,0));
//        presentRentalsDao.update(presentRentalsToBeChange);
//        System.out.println(presentRentalsToBeChange);

        //Here you can set damages for true or false
//        Car carToBeModified = carDao.findById(2);
//        carToBeModified.setDamaged(true);
//        carDao.update(carToBeModified);
//        System.out.println(carToBeModified);

        //Method in which you show extra fees for late return
        //System.out.println(presentRentalsDao.lateReturnAndDamageFees());

//        Showing all cars, customers and present rentals
//        carDao.findAll().forEach(car -> System.out.println(car.toString()));
//        customerDao.findAll().forEach(customer -> System.out.println(customer.toString()));
 //      presentRentalsDao.findAll().forEach(presentRentals -> System.out.println(presentRentals.toString()));

        //System.out.println(carDao.allDamagedCarsFees(true));
presentRentalsDao.allDamagedCarsChargedAdditionalFee();
    }
}

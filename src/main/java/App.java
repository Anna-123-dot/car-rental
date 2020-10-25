import dao.CarDao;
import dao.CustomerDao;
import dao.PresentRentalsDao;
import model.Car;
import model.Customer;
import model.PresentRentals;

public class App {
    public static void main(String[] args) {
        CarDao carDao = new CarDao();
        CustomerDao customerDao = new CustomerDao();
        PresentRentalsDao presentRentalsDao = new PresentRentalsDao();
        Car car1= new Car("Toyota", "Yaris", "grey", "GD12345",false);
        Car car2= new Car("Ford", "Fiesta", "red", "GD12346",false);
        Car car3= new Car("Ford", "Focus", "black", "GD12347",false);
        Car car4= new Car("Suzuki", "Vitara", "white", "GD12348",true);
        Car car5= new Car("Honda", "Civic", "blue", "GD12349",false);
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

    }
}

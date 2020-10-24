package model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "rental")
public class PresentRentals {

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "rentalSeq")
    @GenericGenerator(name = "rentalSeq", strategy = "increment")
    private int id;

    @Column
    private String rentalDate;

    @Column
    private String plannedReturnDate;

    @ManyToOne(targetEntity = Car.class)
    private Car car;

    @ManyToOne(targetEntity = Customer.class)
    private Customer customer;

    public PresentRentals() {
    }

    public PresentRentals(String rentalDate, String plannedReturnDate, Car car, Customer customer) {
        this.rentalDate = rentalDate;
        this.plannedReturnDate = plannedReturnDate;
        this.car = car;
        this.customer = customer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(String rentalDate) {
        this.rentalDate = rentalDate;
    }

    public String getPlannedReturnDate() {
        return plannedReturnDate;
    }

    public void setPlannedReturnDate(String plannedReturnDate) {
        this.plannedReturnDate = plannedReturnDate;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PresentRentals that = (PresentRentals) o;
        return id == that.id &&
                Objects.equals(rentalDate, that.rentalDate) &&
                Objects.equals(plannedReturnDate, that.plannedReturnDate) &&
                Objects.equals(car, that.car) &&
                Objects.equals(customer, that.customer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, rentalDate, plannedReturnDate, car, customer);
    }

    @Override
    public String toString() {
        return "PresentRentals{" +
                "id=" + id +
                ", rentalDate='" + rentalDate + '\'' +
                ", plannedReturnDate='" + plannedReturnDate + '\'' +
                ", car=" + car +
                ", customer=" + customer +
                '}';
    }
}
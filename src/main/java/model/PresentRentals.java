package model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;


@Entity
@Table(name = "rental")
public class PresentRentals {

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "rentalSeq")
    @GenericGenerator(name = "rentalSeq", strategy = "increment")
    private int id;

    @Column(name = "rental_date")
    private LocalDateTime rentalDate;

    @Column(name = "planned_return_date")
    private LocalDateTime plannedReturnDate;

    @Column(name = "return_date")
    private LocalDateTime returnDate;

    @ManyToOne(targetEntity = Car.class)
    private Car car;

    @ManyToOne(targetEntity = Customer.class)
    private Customer customer;

    public PresentRentals() {
    }

    public PresentRentals(LocalDateTime rentalDate, LocalDateTime plannedReturnDate, LocalDateTime returnDate, Car car, Customer customer) {
        this.rentalDate = rentalDate;
        this.plannedReturnDate = plannedReturnDate;
        this.returnDate = returnDate;
        this.car = car;
        this.customer = customer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(LocalDateTime rentalDate) {
        this.rentalDate = rentalDate;
    }

    public LocalDateTime getPlannedReturnDate() {
        return plannedReturnDate;
    }

    public void setPlannedReturnDate(LocalDateTime plannedReturnDate) {
        this.plannedReturnDate = plannedReturnDate;
    }

    public LocalDateTime getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDateTime returnDate) {
        this.returnDate = returnDate;
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
                Objects.equals(returnDate, that.returnDate) &&
                Objects.equals(car, that.car) &&
                Objects.equals(customer, that.customer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, rentalDate, plannedReturnDate, returnDate, car, customer);
    }

    @Override
    public String toString() {
        return "PresentRentals{" +
                "id=" + id +
                ", rentalDate=" + rentalDate +
                ", plannedReturnDate=" + plannedReturnDate +
                ", returnDate=" + returnDate +
                ", car=" + car +
                ", customer=" + customer +
                '}';
    }
}
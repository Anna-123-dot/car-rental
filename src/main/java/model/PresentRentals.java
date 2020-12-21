package model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
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
    private LocalDate rentalDate;

    @Column(name = "planned_return_date")
    private LocalDate plannedReturnDate;

    @Column(name = "return_date")
    private LocalDate returnDate;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "additional_cost")
    private BigDecimal additionalCost;

    @Column(name = "total_price")
    private BigDecimal totalPrice;

    @Enumerated(EnumType.STRING)
    @Column(name = "rent_status")
    private RentStatus rentStatus;

    @ManyToOne(targetEntity = Car.class)
    private Car car;

    @ManyToOne(targetEntity = Customer.class)
    private Customer customer;

    public PresentRentals() {
    }

    public PresentRentals(LocalDate rentalDate, LocalDate plannedReturnDate, LocalDate returnDate, BigDecimal price, BigDecimal additionalCost, BigDecimal totalPrice, RentStatus rentStatus, Car car, Customer customer) {
        
        this.rentalDate = rentalDate;
        this.plannedReturnDate = plannedReturnDate;
        this.returnDate = returnDate;
        this.price = price;
        this.additionalCost = additionalCost;
        this.totalPrice = totalPrice;
        this.rentStatus = rentStatus;
        this.car = car;
        this.customer = customer;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(LocalDate rentalDate) {
        this.rentalDate = rentalDate;
    }

    public LocalDate getPlannedReturnDate() {
        return plannedReturnDate;
    }

    public void setPlannedReturnDate(LocalDate plannedReturnDate) {
        this.plannedReturnDate = plannedReturnDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getAdditionalCost() {
        return additionalCost;
    }

    public BigDecimal setAdditionalCost(BigDecimal additionalCost) {
        this.additionalCost = additionalCost;
        return additionalCost;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public RentStatus getRentStatus() {
        return rentStatus;
    }

    public void setRentStatus(RentStatus rentStatus) {
        this.rentStatus = rentStatus;
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
        return id == that.id && Objects.equals(rentalDate, that.rentalDate) && Objects.equals(plannedReturnDate, that.plannedReturnDate) && Objects.equals(returnDate, that.returnDate) && Objects.equals(price, that.price) && Objects.equals(additionalCost, that.additionalCost) && Objects.equals(totalPrice, that.totalPrice) && rentStatus == that.rentStatus && Objects.equals(car, that.car) && Objects.equals(customer, that.customer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, rentalDate, plannedReturnDate, returnDate, price, additionalCost, totalPrice, rentStatus, car, customer);
    }

    @Override
    public String toString() {
        return "PresentRentals{" +
                "id=" + id +
                ", rentalDate=" + rentalDate +
                ", plannedReturnDate=" + plannedReturnDate +
                ", returnDate=" + returnDate +
                ", price=" + price +
                ", additionalCost=" + additionalCost +
                ", totalPrice=" + totalPrice +
                ", rentStatus=" + rentStatus +
                ", car=" + car +
                ", customer=" + customer +
                '}';
    }
}



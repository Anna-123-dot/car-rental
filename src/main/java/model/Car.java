package model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "car")
public class Car {
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "carSeq")
    @GenericGenerator(name = "carSeq", strategy = "increment")
    private int id;

    @Column
    private String brand;

    @Column
    private String model;

    @Column
    private String color;

    @Column
    private String registrationNumber;



}

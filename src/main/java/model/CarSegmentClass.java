package model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="car_database")
public class CarSegmentClass {

    @Column
    @Enumerated(EnumType.STRING)
    private CarSegment segment;

    @Column
    private String model;

    @Column
    private String color;

    public CarSegmentClass() {
    }

    public CarSegmentClass(CarSegment segment, String model, String color) {
        this.segment = segment;
        this.model = model;
        this.color = color;
    }

    public CarSegment getSegment() {
        return segment;
    }

    public void setSegment(CarSegment segment) {
        this.segment = segment;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarSegmentClass that = (CarSegmentClass) o;
        return segment == that.segment && Objects.equals(model, that.model) && Objects.equals(color, that.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(segment, model, color);
    }

    @Override
    public String toString() {
        return "CarSegmentClass{" +
                "segment=" + segment +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
